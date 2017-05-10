package com.monitor.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.monitor.WebApplicationConfiguration;
import com.monitor.entity.vo.ResourceParam;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestResourceService {

	@Autowired
	private ResourceService resourceService;
	
	@Test
	public void test1(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mId", 1);
		map.put("vTopId", 1);
		map.put("vSecId", 1001);
		map.put("keywords", "修仙");
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceService.getResourceListByKeywords(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("mId", 1);
		map.put("vTopId", 1);
		map.put("vSecId", 1001);
		map.put("keywords", "修仙");
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceService.getResourceByKeywordsCount(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vTitile", "集锦");
		map.put("vName", "勇士110");
		map.put("vPic", null);
		map.put("vIntroduce", "库里---集锦");
		map.put("vPath", "https://v.qq.com/x/cover/sjgx9f43wde9z0t/r0018m0puzt.html?");
		map.put("playCounts", 1);
		map.put("duration", 1000);
		map.put("fabulousCounts", 1);
		map.put("isDel", 0);
		map.put("vSecId", 3004);
		map.put("mId", 1);
		map.put("disComment", 0);
		map.put("vId", 12);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceService.updateResourceById(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test4(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vId", 12);
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceService.getResourceById(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test5(){
		ResourceParam param = new ResourceParam();
		
		param.setvTitle("集锦");
		param.setvName("勇士110");
		param.setvPic("a");
		param.setvIntroduce("a");
		param.setvPath("a");
		param.setDuration(null);
		param.setvSecId(1002);
		param.setmId(1);
		
		Object jobj = new Object();
		jobj = JSON.toJSON(resourceService.createResource(param));
		System.out.println(jobj);
	}
	
}
