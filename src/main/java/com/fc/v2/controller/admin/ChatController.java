package com.fc.v2.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.controller.request.ChatRequest;
import com.fc.v2.controller.response.ChatResponse;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.satoken.SaTokenUtil;
import com.fc.v2.service.system.SseService;
import com.fc.v2.util.StringUtils;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private SseService sseService;

    /**
     * 创建sse连接
     *
     * @param headers
     * @return
     */
    @CrossOrigin
    @GetMapping("/createSse")
    public SseEmitter createConnect(@RequestHeader Map<String, String> headers) {
        TsysUser user = SaTokenUtil.getUser();
        if (user == null || StringUtils.isEmpty(user.getId())) {
            return null;
        }
        String uid = user.getId();
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
    public AjaxResult sseChat(@RequestBody ChatRequest chatRequest, @RequestHeader Map<String, String> headers, HttpServletResponse response) {
        TsysUser user = SaTokenUtil.getUser();
        if (user == null || StringUtils.isEmpty(user.getId())) {
            return AjaxResult.error("用户未登录");
        }
        String uid = user.getId();
        return AjaxResult.successData(AjaxResult.SUCCESS_CODE, sseService.sseChat(uid, chatRequest));
    }

    /**
     * 关闭连接
     *
     * @param headers
     */
    @CrossOrigin
    @GetMapping("/closeSse")
    public AjaxResult closeConnect(@RequestHeader Map<String, String> headers) {
        TsysUser user = SaTokenUtil.getUser();
        if (user == null || StringUtils.isEmpty(user.getId())) {
            return AjaxResult.error("用户未登录");
        }
        String uid = user.getId();

        return AjaxResult.successData(AjaxResult.SUCCESS_CODE, sseService.closeSse(uid));
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
