package com.monitor.controller.ext;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.monitor.controller.BasicController;
import com.monitor.entity.nav.TopNav;
import com.monitor.service.NavService;

/**
 * 导航栏菜单 控制层
 *
 * @author ganzhigang
 * time: 2017年4月29日 上午11:13:58
 *
 */
@Controller("navController")
@RequestMapping("/nav")
public class NavController extends BasicController{

	@Autowired
	private NavService navService;
	
	@RequestMapping("/loadAll")
	@ResponseBody
	public List<TopNav> getTopNavList(){
		logger.info("列出所有的菜单");
		return navService.getNav();
	}
	
}
