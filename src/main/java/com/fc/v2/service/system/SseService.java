package com.fc.v2.service.system;

import com.fc.v2.common.sakyamuni.SaberDrawLotsEnum;
import com.fc.v2.common.sakyamuni.SaberTalkType;
import com.fc.v2.controller.request.ChatRequest;
import com.fc.v2.controller.response.ChatResponse;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-08
 */
public interface SseService {
    /**
     * 创建SSE
     * @param uid
     * @return
     */
    SseEmitter createSse(String uid);

    /**
     * 关闭SSE
     * @param uid
     */
    Boolean closeSse(String uid);

    /**
     * 客户端发送消息到服务端
     * @param uid
     * @param chatRequest
     */
    ChatResponse sseChat(String uid, ChatRequest chatRequest, SaberTalkType type, SaberDrawLotsEnum drawLotsEnum);
}
