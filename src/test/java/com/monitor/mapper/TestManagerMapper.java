package com.monitor.mapper;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.monitor.WebApplicationConfiguration;
import com.monitor.entity.ManagerUserDetail;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestManagerMapper {

	@Autowired
	private ManagerMapper managerMapper;
	
	@Test
	public void test1(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("username", "Admin");
		Object jobj = new Object();
		jobj = JSON.toJSON(managerMapper.selectManagerUserByNickname(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mId", 1);
		Object jobj = new Object();
		jobj = JSON.toJSON(managerMapper.selectManagerUserDetailById(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test3(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("username", "admin");
		Object jobj = new Object();
		jobj = JSON.toJSON(managerMapper.selectManagerUserCountByNickname(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test4(){
		
		ManagerUserDetail manager = new ManagerUserDetail();
		manager.setmId(1);
		manager.setmName("aa");
		manager.setmNickname("Admin");
		manager.setmPassword("123456");
		manager.setmPhone("15727575679");
		manager.setmPic("");
		Object jobj = new Object();
		jobj = JSON.toJSON(managerMapper.updateManagerUserInfoById(manager));
		System.out.println(jobj);
	}
	
}
