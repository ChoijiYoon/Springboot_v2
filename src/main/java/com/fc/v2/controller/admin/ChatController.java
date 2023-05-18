package com.fc.v2.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.controller.request.ChatRequest;
import com.fc.v2.controller.response.ChatResponse;
import com.fc.v2.service.SseService;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-03-01
 */
@Controller
@Slf4j
@Api(value = "chatgpt")
@RestController
@RequestMapping("/captcha")
public class ChatController extends BaseController {

    private final SseService sseService;

    public ChatController(SseService sseService) {
        this.sseService = sseService;
    }

    /**
     * 创建sse连接
     *
     * @param headers
     * @return
     */
    @CrossOrigin
    @GetMapping("/createSse")
    public SseEmitter createConnect(@RequestHeader Map<String, String> headers) {
        String uid = getUid(headers);
        return sseService.createSse(uid);
    }

    /**
     * 聊天接口
     *
     * @param chatRequest
     * @param headers
     */
    @CrossOrigin
    @PostMapping("/chat")
    @ResponseBody
    public ChatResponse sseChat(@RequestBody ChatRequest chatRequest, @RequestHeader Map<String, String> headers, HttpServletResponse response) {
        String uid = getUid(headers);
        return sseService.sseChat(uid, chatRequest);
    }

    /**
     * 关闭连接
     *
     * @param headers
     */
    @CrossOrigin
    @GetMapping("/closeSse")
    public void closeConnect(@RequestHeader Map<String, String> headers) {
        String uid = getUid(headers);
        sseService.closeSse(uid);
    }

    @GetMapping("")
    public String index() {
        return "fozu.html";
    }

    @GetMapping("/websocket")
    public String websocket() {
        return "websocket.html";
    }

    @GetMapping("/saber")
    public String saber() {
        return "fozu.html";
    }

    /**
     * 获取uid
     *
     * @param headers
     * @return
     */
    private String getUid(Map<String, String> headers) {
        String uid = headers.get("uid");
        if (StrUtil.isBlank(uid)) {
            throw new BaseException(CommonError.SYS_ERROR);
        }
        return uid;
    }


}
