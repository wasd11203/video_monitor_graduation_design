package com.monitor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.entity.nav.TopNav;
import com.monitor.mapper.NavMapper;
import com.monitor.service.NavService;

@Service("navService")
public class NavServiceImpl implements NavService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private NavMapper navMapper;
	
	@Override
	public List<TopNav> getNav() {
		return navMapper.selectNav();
	}

}
