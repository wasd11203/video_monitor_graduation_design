package com.monitor.security.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.monitor.controller.BasicController;
import com.monitor.security.entity.ManagerUser;
import com.monitor.security.entity.ManagerUserInfoDetails;
import com.monitor.security.service.UserService;
import com.monitor.util.http.HttpUtil;
import com.monitor.util.random.RandomNum;
import com.taobao.api.ApiException;

@Controller
@RequestMapping("/account")
public class AccountController extends BasicController{

	@Autowired
	private UserService userService;
	
	@Value("${char.source.pool}")
	private String sourcePool;
	
	@Value("${ali.dayu.sdk.url}")
	private String url;
	
	@Value("${ali.dayu.sdk.appkey}")
	private String appkey;
	
	@Value("${ali.dayu.sdk.secret}")
	private String secret;
	
	@Value("${ali.dayu.sdk.extend}")
	private String extend;
	
	@Value("${ali.dayu.sdk.smsType}")
	private String smsType;
	
	@Value("${ali.dayu.sdk.tempLateCode}")
	private String tempLateCode;
	
	@Value("${ali.dayu.sdk.freeSignName}")
	private String freeSignName;
	
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject loginAccount(Principal user){
		Authentication auth = (Authentication) user;
        ManagerUserInfoDetails uid = (ManagerUserInfoDetails) auth.getPrincipal();
        ManagerUser authUser = uid.getUser();
        
		logger.debug("CONTROLLER-- 登陆用户:[{}]",authUser);
		JSONObject jobj = new JSONObject();
		
		if(authUser != null ){
			jobj.put("code", 0);
			jobj.put("user", authUser);
		}else{
			jobj.put("code",1);
		}
		
		return jobj;
	}
	
	@RequestMapping("/logout")
	@ResponseBody
	public JSONObject logoutAccount(String mId){
		logger.debug("CONTROLLER-- 登出用户Id:[{}]",mId);
		JSONObject jobj = new JSONObject();
		if(mId != null && !mId.trim().isEmpty()){
			jobj.put("code", 0);
		}else{
			jobj.put("code",1);
			jobj.put("msg", "登出失败");
		}
		
		return jobj;
	}
	
	@RequestMapping("/sendVerfiyCode")
	@ResponseBody
	public JSONObject sendVerfiyCode(String phone,HttpServletRequest req,HttpServletResponse res){
		
		String code = RandomNum.randomCheckCode(sourcePool);
		Cookie cookie = new Cookie(phone, code);
		// 60S 内有效
		cookie.setMaxAge(60);
		res.addCookie(cookie);
		logger.debug("CONTROLLER-- 向号码:[{}]发送验证码:[{}]",phone,code);
		
		JSONObject resJson = null;
		JSONObject param = new JSONObject();
		param.put("phone", phone);
		param.put("code", code);
		
		try {
			resJson = HttpUtil.alihttpPost(url, appkey, secret, extend, smsType, phone, tempLateCode, freeSignName, param);
		} catch (ApiException e) {
			
			e.printStackTrace();
		}
		
		return resJson;
	}
	
}
