package com.monitor.controller.ext;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.monitor.controller.BasicController;
import com.monitor.entity.ManagerUserDetail;
import com.monitor.security.entity.ManagerUser;
import com.monitor.service.ManagerUserService;

/**
 * 管理者 Controller
 * @author ganzhigang
 * 时间：2017年5月10日 下午3:48:31
 */
@Controller
@RequestMapping("/user")
public class ManagerUserController extends BasicController {

	@Autowired
	private ManagerUserService managerUserService;
	
	@RequestMapping("/login")
	@ResponseBody
	public ManagerUser login(String username){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		ManagerUser user = managerUserService.loadManagerUserByNickname(map);
		
		return user;
	}
	
	@RequestMapping("/detail")
	@ResponseBody
	public ManagerUserDetail detail(String mId){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mId", new Integer(mId));
		ManagerUserDetail detail = managerUserService.getManagerUserDetailById(map);
		
		return detail;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject update(ManagerUserDetail param){
		JSONObject jobj = new JSONObject();
		int row = managerUserService.updateManagerUserInfoById(param);
		
		jobj.put("code", 0);
		jobj.put("row", row);
		
		return jobj;
	}
	
}
