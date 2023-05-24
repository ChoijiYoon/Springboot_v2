package com.fc.v2.service.system.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.fc.v2.common.sakyamuni.SaberSakyamuniDrillEnum;
import com.fc.v2.config.LocalCache;
import com.fc.v2.controller.request.ChatRequest;
import com.fc.v2.controller.response.ChatResponse;
import com.fc.v2.listener.OpenAISSEEventSourceListener;
import com.fc.v2.mapper.message.UserMessageHistoryMapper;
import com.fc.v2.mapper.message.UserMessageTrainRecordMapper;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.model.message.UserMessageTrainRecord;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.service.system.SseService;
import com.fc.v2.util.DateUtils;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-08
 */
@Service
@Slf4j
public class SseServiceImpl implements SseService {

    private final OpenAiStreamClient openAiStreamClient;

    @Autowired
    private UserMessageHistoryMapper userMessageHistoryMapper;
    @Autowired
    private UserMessageTrainRecordMapper trainRecordMapper;

    public SseServiceImpl(OpenAiStreamClient openAiStreamClient) {
        this.openAiStreamClient = openAiStreamClient;
    }

    @Override
    public SseEmitter createSse(String uid) {
        //默认30秒超时,设置为0L则永不超时
        SseEmitter sseEmitter = new SseEmitter(0L);
        //完成后回调
        sseEmitter.onCompletion(() -> {
            log.info("[{}]结束连接...................", uid);
            LocalCache.CACHE.remove(uid);
        });
        //超时回调
        sseEmitter.onTimeout(() -> {
            log.info("[{}]连接超时...................", uid);
        });
        //异常回调
        sseEmitter.onError(
                throwable -> {
                    try {
                        log.info("[{}]连接异常,{}", uid, throwable.toString());
                        sseEmitter.send(SseEmitter.event()
                                .id(uid)
                                .name("发生异常！")
                                .data(Message.builder().content("发生异常请重试！").build())
                                .reconnectTime(3000));
                        LocalCache.CACHE.put(uid, sseEmitter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        try {
            sseEmitter.send(SseEmitter.event().reconnectTime(5000));
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalCache.CACHE.put(uid, sseEmitter);
        log.info("[{}]创建sse连接成功！", uid);
        return sseEmitter;
    }

    @Override
    public Boolean closeSse(String uid) {
        boolean isSuccess = false;
        SseEmitter sse = (SseEmitter) LocalCache.CACHE.get(uid);
        if (sse != null) {
            sse.complete();
            //移除
            LocalCache.CACHE.remove(uid);
            isSuccess = true;
        }
        return isSuccess;
    }

    @Override
    public ChatResponse sseChat(String uid, ChatRequest chatRequest) {
        if (StrUtil.isBlank(chatRequest.getMsg())) {
            log.info("参数异常，msg为null uid:{}", uid);
            throw new BaseException("参数异常，msg不能为空~");
        }
        //查询用户历史聊天key
        List<Message> messages = new ArrayList<>();
        UserMessageTrainRecord trainRecord = trainRecordMapper.getByUserId(Long.parseLong(uid));
        if (trainRecord != null) {
            String messageContext = trainRecord.getContent();
            JSONArray jsonArray = new JSONArray(messageContext);
            messages = JSONUtil.toList(jsonArray, Message.class);
            //截取最近十条内容进行回复 暂不支持
            /*if (messages.size() >= 10) {
                messages = messages.subList(1, 10);
            }*/
            Message currentMessage = Message.builder().content(chatRequest.getMsg()).role(Message.Role.USER).build();
            messages.add(currentMessage);
        } else {
            Message systemMessage = Message.builder().content(SaberSakyamuniDrillEnum.ROLE.getContent()).role(Message.Role.SYSTEM).build();
            messages.add(systemMessage);
            Message currentMessage = Message.builder().content(chatRequest.getMsg()).role(Message.Role.USER).build();
            messages.add(currentMessage);
        }

        SseEmitter sseEmitter = (SseEmitter) LocalCache.CACHE.get(uid);

        if (sseEmitter == null) {
            log.info("聊天消息推送失败uid:[{}],没有创建连接，请重试。", uid);
            throw new BaseException("聊天消息推送失败uid:[{}],没有创建连接，请重试。~");
        }
        OpenAISSEEventSourceListener openAIEventSourceListener = new OpenAISSEEventSourceListener(sseEmitter, Long.parseLong(uid));
        ChatCompletion completion = ChatCompletion
                .builder()
                .messages(messages)
                .user(uid)
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .build();
        openAiStreamClient.streamChatCompletion(completion, openAIEventSourceListener);
        if (trainRecord == null) {
            trainRecordMapper.insert(new UserMessageTrainRecord(JSONUtil.toJsonStr(messages), DateUtils.getTenLengthTime(), Long.parseLong(uid), DateUtils.getTenLengthTime()));
        } else {
            trainRecord.setContent(JSONUtil.toJsonStr(messages));
            trainRecord.setEditTime(DateUtils.getTenLengthTime());
            trainRecordMapper.updateByPrimaryKey(trainRecord);
        }
        //记录用户聊天消息
        UserMessageHistory userMessageHistory = new UserMessageHistory();
        userMessageHistory.setUserId(Long.parseLong(uid));
        userMessageHistory.setContent(chatRequest.getMsg());
        userMessageHistory.setCreateTime(DateUtils.getTenLengthTime());
        userMessageHistory.setType(0);
        userMessageHistoryMapper.insert(userMessageHistory);
        ChatResponse response = new ChatResponse();
        response.setQuestionTokens(completion.tokens());
        return response;
    }
}
