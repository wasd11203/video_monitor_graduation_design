package com.monitor.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.entity.ManagerUserDetail;
import com.monitor.mapper.ManagerMapper;
import com.monitor.service.ManagerUserService;

@Service("managerUserService")
public class ManagerUserServiceImpl implements ManagerUserService{

	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public ManagerUserDetail getManagerUserDetailById(Map<String, Object> map) {
		
		return managerMapper.selectManagerUserDetailById(map);
	}

	@Override
	public int updateManagerUserInfoById(ManagerUserDetail manager) {
		
		return managerMapper.updateManagerUserInfoById(manager);
	}

	@Override
	public int checkNickname(Map<String, Object> map) {
		return managerMapper.selectManagerUserCountByNickname(map);
	}
	
}
