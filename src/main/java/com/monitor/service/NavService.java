package com.monitor.service;

import java.util.List;

import com.monitor.entity.nav.TopNav;

/**
 * 导航栏 菜单业务层接口
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:07:47
 *
 */
public interface NavService {

	/**
	 * 获取所有导航菜单
	 * @return
	 */
	public List<TopNav> getNav();
}
