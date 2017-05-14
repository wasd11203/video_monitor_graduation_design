package com.monitor.security.service;

import java.util.Map;

import com.monitor.security.entity.ManagerUser;

/**
 * 管理者 登录时业务接口
 *
 * @author ganzhigang
 * time: 2017年5月13日 下午11:34:15
 *
 */
public interface UserService {

	/**
	 * 根据用户名查找用户信息
	 * @param map
	 * @return
	 */
	public ManagerUser loadManagerUserByNickname(Map<String, Object> map);
	
}
