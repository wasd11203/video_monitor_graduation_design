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

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=WebApplicationConfiguration.class)// 指定spring-boot的启动类  
public class TestCommentMapper {

	@Autowired
	private CommentMapper commentMapper;
	
	@Test
	public void test1(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("vId", 12);
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.selectCommentsByVid(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test2(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("vId", 12);
		map.put("startIndex", 0);
		map.put("pageSize", 2);
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.selectCommentsCountByVid(map));
		System.out.println(jobj);
	}
	
	@Test
	public void test3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vId", 12);
		map.put("dcComment", "");
		map.put("dcIntime", null);
		map.put("isDel", 1);
		map.put("fabulousCounts", null);
		map.put("vuId", 1);
		map.put("dcId", 1);
		Object jobj = new Object();
		jobj = JSON.toJSON(commentMapper.updateComment(map));
		System.out.println(jobj);
	}
	
}
