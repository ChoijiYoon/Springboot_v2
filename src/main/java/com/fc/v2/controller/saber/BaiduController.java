package com.fc.v2.controller.saber;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.xasset.auth.XchainAccount;
import com.baidu.xasset.client.base.BaseDef;
import com.baidu.xasset.client.xasset.Asset;
import com.baidu.xasset.client.xasset.XassetDef;
import com.baidu.xasset.common.config.Config;
import com.baidu.xuper.api.Account;
import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.conf.XuperConfig;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.log.Log;
import com.fc.v2.controller.AdminController;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.model.xuper.XuperAccount;
import com.fc.v2.satoken.SaTokenUtil;
import com.fc.v2.service.message.UserMessageHistoryService;
import com.fc.v2.service.user.XuperAccountService;
import com.fc.v2.util.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.logging.Logger;

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
public class BaiduController extends BaseController {
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);


	@Autowired
	private XuperConfig xuperConfig;
	@Autowired
	private XuperAccountService xuperAccountService;

	@ApiOperation(value = "创建区块链账户", notes = "创建区块链账户")
	@GetMapping("/createAccount")
	@ResponseBody
	public AjaxResult getUserMenu(){
		TsysUser user = SaTokenUtil.getUser();
		if (user == null) {
			return AjaxResult.error(500, "用户未登录");
		}
		//判断用户是否已创建
		XuperAccount account = xuperAccountService.getByUserId(Long.parseLong(user.getId()));
		if (account != null) {
			return AjaxResult.error(202, "您已创建账户, 请直接访问个人中心");
		}

		String access = DigestUtils.md5Hex(xuperConfig.getAccessKey());
		String secret = DigestUtils.md5Hex(xuperConfig.getSecretKey());
		Config.XassetCliConfig cfg = new Config.XassetCliConfig();
		cfg.setCredentials(xuperConfig.getAppId(), access, secret);
		cfg.setEndPoint("http://120.48.16.137:8360");
		try {
			// 创建区块链账户
			Account acc = XchainAccount.newXchainEcdsaAccount(XchainAccount.mnemStrgthStrong, XchainAccount.mnemLangEN);
			// 初始化接口类
			Asset handle = new Asset(cfg, Logger.getGlobal());
			// 调用方法
			BaseDef.Resp<XassetDef.GetStokenResp> result = handle.getStoken(acc);
			if (result == null || result.apiResp.errNo != 0) {
				logger.error("创建账户失败 用户id: " + user.getId() + user.getUsername() + " , result返参：" + result);
				return AjaxResult.error(202, "创建账户失败");
			}
			String jsonObject = result.res.body;
			JSONObject json = JSONObject.parseObject(jsonObject);

			JSONObject accessInfo = json.getJSONObject("accessInfo");
			if (accessInfo == null) {
				logger.error("无法获取到创建账号详情");
				return AjaxResult.error(202, "创建账户失败");
			}
			XuperAccount xuperAccount = new XuperAccount();
			xuperAccount.setUserId(Long.parseLong(user.getId()));
			xuperAccount.setXuperAddress(acc.getAddress());
			xuperAccount.setMnemonic(acc.getMnemonic());
			xuperAccount.setPrivateKey(acc.getKeyPair().getPrivateKey().toString());
			xuperAccount.setPublicKey(acc.getKeyPair().getPublicKey().toString());
			xuperAccount.setJsonPublicKey(acc.getKeyPair().getJSONPublicKey());
			xuperAccount.setJsonPrivateKey(acc.getKeyPair().getJSONPrivateKey());
			xuperAccount.setCreateTime(DateUtils.getTenLengthTime());
			xuperAccount.setEditTime(DateUtils.getTenLengthTime());
			xuperAccountService.save(xuperAccount);
		} catch (Exception e) {
			logger.error("创建账户失败 userId: {}, err{}", user.getId(), e.getMessage());
			return AjaxResult.error("创建账户失败");
		}
		return AjaxResult.success();
	}

/*
	@ApiOperation(value = "创建区块链账户", notes = "创建区块链账户")
	@GetMapping("/createAccount")
	@ResponseBody
	public AjaxResult createAccount(){
		TsysUser user = SaTokenUtil.getUser();
		if (user == null) {
			return AjaxResult.error(500, "用户未登录");
		}

		String access = DigestUtils.md5Hex(xuperConfig.getAccessKey());
		String secret = DigestUtils.md5Hex(xuperConfig.getSecretKey());
		Config.XassetCliConfig cfg = new Config.XassetCliConfig();
		cfg.setCredentials(xuperConfig.getAppId(), access, secret);
		cfg.setEndPoint("http://120.48.16.137:8360");
		// 创建区块链账户
		Account acc = XchainAccount.newXchainEcdsaAccount(XchainAccount.mnemStrgthStrong, XchainAccount.mnemLangEN);

		xuperAccountService.save();
		// 初始化接口类
		Asset handle = new Asset(cfg, Logger.getGlobal());
		// 调用方法
		BaseDef.Resp<XassetDef.GetStokenResp> result = handle.getStoken(acc);
		System.out.println(result);
		return AjaxResult.success();
	}*/



}
