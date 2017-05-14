package com.monitor.service;

import java.util.Map;

import com.monitor.entity.ManagerUserDetail;

/**
 * 管理者 信息  Service
 * @author ganzhigang
 * 时间：2017年5月10日 下午3:19:53
 */
public interface ManagerUserService {

	/**
	 * 根据管理者id 获取详细信息
	 * @param map
	 * @return
	 */
	public ManagerUserDetail getManagerUserDetailById(Map<String, Object> map);

	/**
	 * 根据管理者id 更新信息
	 * @param manager
	 * @return
	 */
	public int updateManagerUserInfoById(ManagerUserDetail manager);
	
	/**
	 * 查看用户昵称是否被占用
	 * @param map
	 * @return
	 */
	public int checkNickname(Map<String, Object> map);
	
	
}
