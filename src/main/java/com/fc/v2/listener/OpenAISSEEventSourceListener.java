package com.fc.v2.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.v2.common.spring.SpringUtils;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.service.system.SysInterUrlService;
import com.fc.v2.util.DateUtils;
import com.fc.v2.util.StringUtils;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 描述：OpenAIEventSourceListener
 *
 * @author https:www.unfbx.com
 * @date 2023-02-22
 */
@Slf4j
public class OpenAISSEEventSourceListener extends EventSourceListener {

    private long tokens;

    private SseEmitter sseEmitter;
    private Long userId;
    public static UserMessageHistoryService userMessageHistoryService= SpringUtils.getBean(UserMessageHistoryService.class);

    public OpenAISSEEventSourceListener(SseEmitter sseEmitter, Long userId) {
        this.sseEmitter = sseEmitter;
        this.userId = userId;
    }

    private Map<Long, String> msgMap = new HashMap<>();
    /**
     * {@inheritDoc}
     */
    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI建立sse连接...");
    }

    /**
     * {@inheritDoc}
     */
    @SneakyThrows
    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI返回数据：{}", data);
        tokens += 1;
        if (data.equals("[DONE]")) {
            log.info("OpenAI返回数据结束了");
            sseEmitter.send(SseEmitter.event()
                    .id("[TOKENS]")
                    .data("<br/><br/>tokens：" + tokens())
                    .reconnectTime(3000));
            sseEmitter.send(SseEmitter.event()
                    .id("[DONE]")
                    .data("[DONE]")
                    .reconnectTime(3000));
            // 之前逻辑, 传输完成后自动关闭sse
            sseEmitter.complete();
            String msgData = msgMap.get(userId);
            if (StringUtils.isNotEmpty(msgData)) {
                UserMessageHistory userMessageHistory = new UserMessageHistory();
                userMessageHistory.setType(1);
                userMessageHistory.setContent(msgData);
                userMessageHistory.setUserId(userId);
                userMessageHistory.setCreateTime(DateUtils.getTenLengthTime());
                userMessageHistoryService.save(userMessageHistory);
            }
            return;
        }
        JSONObject jsonObject1 = JSON.parseObject(data);
        JSONArray jsonObject = jsonObject1.getJSONArray("choices");
        log.info("jsonObject1：{}", jsonObject);
        JSONObject delta1 = jsonObject.getJSONObject(0);
        log.info("delta1：{}", delta1);
        JSONObject delta = delta1.getJSONObject("delta");
        Object content1 = delta.get("content");
        if (content1 != null) {
            String content = content1 + "";
            String msg = msgMap.get(userId);
            if (StringUtils.isEmpty(msg)) {
                msgMap.put(userId, content);
            } else {
                msg = msg + content;
                msgMap.put(userId, msg);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class); // 读取Json
        try {
            sseEmitter.send(SseEmitter.event()
                    .id(completionResponse.getId())
                    .data(completionResponse.getChoices().get(0).getDelta())
                    .reconnectTime(3000));
        } catch (Exception e) {
            log.error("sse信息推送失败！");
            // 推送消息失败，记录错误日志，进行重推
            log.error("SseEmitterServiceImpl[sendMsgToClient]: 推送消息失败：{},尝试进行重推", data, e);
            boolean isSuccess = true;
            // 推送消息失败后，每隔10s推送一次，推送5次
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(10000);
                    if (sseEmitter == null) {
                        log.error("SseEmitterServiceImpl[sendMsgToClient]：{}的第{}次消息重推失败，未创建长链接", id, i + 1);
                        continue;
                    }
                    sseEmitter.send(SseEmitter.event()
                            .id(completionResponse.getId())
                            .data(completionResponse.getChoices().get(0).getDelta())
                            .reconnectTime(3000));
                } catch (Exception ex) {
                    log.error("SseEmitterServiceImpl[sendMsgToClient]：{}的第{}次消息重推失败", id, i + 1, ex);
                    continue;
                }
                log.info("SseEmitterServiceImpl[sendMsgToClient]：{}的第{}次消息重推成功,{}", id, i + 1, data);
                return;
            }
            eventSource.cancel();
            e.printStackTrace();
        }
    }


    @Override
    public void onClosed(EventSource eventSource) {
        log.info("流式输出返回值总共{}tokens", tokens() - 2);
        log.info("OpenAI关闭sse连接...");
    }


    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", body.string(), t);
        } else {
            log.error("OpenAI  sse连接异常data：{}，异常：{}", response, t);
        }
        eventSource.cancel();
    }

    /**
     * tokens
     * @return
     */
    public long tokens() {
        return tokens;
    }
}
