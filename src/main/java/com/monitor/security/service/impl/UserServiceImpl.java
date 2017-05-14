package com.monitor.security.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.mapper.ManagerMapper;
import com.monitor.security.entity.ManagerUser;
import com.monitor.security.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private ManagerMapper managerMapper;
	
	@Override
	public ManagerUser loadManagerUserByNickname(Map<String, Object> map) {
		return managerMapper.selectManagerUserByNickname(map);
	}
}
