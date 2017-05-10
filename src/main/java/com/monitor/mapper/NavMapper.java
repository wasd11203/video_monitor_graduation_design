package com.monitor.mapper;

import java.util.List;

import com.monitor.entity.nav.TopNav;

/**
 * 导航 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:01:02
 *
 */
public interface NavMapper {
	
	/**
	 * 获取所有导航菜单
	 * @return
	 */
	public List<TopNav> selectNav();
}
