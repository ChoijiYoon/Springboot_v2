package com.fc.v2.controller.saber;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.mapper.custom.TsysUserDao;
import com.fc.v2.model.auto.SysNotice;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.model.custom.SysMenu;
import com.fc.v2.model.message.UserMessageHistory;
import com.fc.v2.satoken.SaTokenUtil;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.util.ServletUtils;
import com.fc.v2.util.StringUtils;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 赛博方法
 * 
 * @ClassName: SaberLoginController
 * @author cgy
 * @date 2023年5月18日11:08:48
 *
 */
@Controller
@RequestMapping("/message")
public class UserMessageController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(UserMessageController.class);

	@Autowired
	private UserMessageHistoryService messageHistoryService;

	@ApiOperation(value = "获取用户历史信息记录", notes = "获取用户历史信息记录")
	@GetMapping("/getUserMenu")
	@ResponseBody
	public AjaxResult getUserMenu(){
		TsysUser user = SaTokenUtil.getUser();
		if (user == null) {
			return AjaxResult.error(500, "用户未登录");
		}
		List<UserMessageHistory> messageHistories = messageHistoryService.getByUserId(Long.parseLong(SaTokenUtil.getUserId()));
		if (CollectionUtils.isNotEmpty(messageHistories)) {
			return AjaxResult.successData(AjaxResult.SUCCESS_CODE, messageHistories);
		}
		return AjaxResult.success();
	}

}
