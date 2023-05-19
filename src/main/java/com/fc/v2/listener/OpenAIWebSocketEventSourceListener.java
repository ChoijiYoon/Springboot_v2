package com.fc.v2.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.service.message.UserMessageHistoryService;
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

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 描述：OpenAI流式输出Socket接收
 *
 * @author https:www.unfbx.com
 * @date 2023-03-23
 */
@Slf4j
public class OpenAIWebSocketEventSourceListener extends EventSourceListener {

    private Session session;

    public OpenAIWebSocketEventSourceListener(Session session) {
        this.session = session;
    }

    private static final String END_MSG = "[DONE]";

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
        if (END_MSG.equals(data)) {
            log.info("OpenAI返回数据结束了");
            session.getBasicRemote().sendText(END_MSG);
            /*String msgData = msgMap.get(Long.parseLong(id));
            if (StringUtils.isNotEmpty(msgData)) {
                UserMessageHistory userMessageHistory = new UserMessageHistory();
                userMessageHistory.setType(1);
                userMessageHistory.setContent(msgData);
                userMessageHistory.setUserId(Long.parseLong(id));
                userMessageHistory.setCreateTime(DateUtils.getTenLengthTime());
                userMessageHistoryService.save(userMessageHistory);
            }*/
            return;
        }
        JSONObject jsonObject = JSON.parseObject("choices");
        log.info("jsonObject1：{}", jsonObject);
        JSONObject delta1 = jsonObject.getJSONObject("delta");
        log.info("delta1：{}", delta1);
        String content = delta1.getString("content");
        log.info("content：{}", content);
        String msg = msgMap.get(Long.parseLong(id));
        if (StringUtils.isEmpty(msg)) {
            msgMap.put(Long.parseLong(msg), content);
        } else {
            msg = msg + content;
            msgMap.put(Long.parseLong(msg), msg);
        }
        ObjectMapper mapper = new ObjectMapper();
        ChatCompletionResponse completionResponse = mapper.readValue(data, ChatCompletionResponse.class); // 读取Json
        String delta = mapper.writeValueAsString(completionResponse.getChoices().get(0).getDelta());

        session.getBasicRemote().sendText(delta);
    }


    @Override
    public void onClosed(EventSource eventSource) {
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
}
