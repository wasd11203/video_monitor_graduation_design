package com.monitor.mapper;

import java.util.Map;

import com.monitor.entity.ManagerUserDetail;
import com.monitor.security.entity.ManagerUser;

/**
 * 管理者 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:01:02
 *
 */
public interface ManagerMapper {
	
	/**
	 * 根据管理者id 获取详细信息
	 * @param map
	 * @return
	 */
	public ManagerUserDetail selectManagerUserDetailById(Map<String, Object> map);

	/**
	 * 根据管理者id 更新信息
	 * @param manager
	 * @return
	 */
	public int updateManagerUserInfoById(ManagerUserDetail manager);
	
	/**
	 * 根据用户名查找用户信息
	 * @param map
	 * @return
	 */
	public ManagerUser selectManagerUserByNickname(Map<String, Object> map);
	
	/**
	 * 查看用户昵称是否被占用
	 * @param map
	 * @return
	 */
	public int selectManagerUserCountByNickname(Map<String, Object> map);
	
	
}
