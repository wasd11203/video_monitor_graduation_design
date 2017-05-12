package com.monitor.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.entity.Resource;
import com.monitor.entity.ResourceDetail;
import com.monitor.entity.vo.ResourceParam;
import com.monitor.mapper.ResourceMapper;
import com.monitor.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ResourceMapper resourceMapper;
	
	@Override
	public List<Resource> getResourceListByKeywords(Map<String, Object> map) {
		return resourceMapper.selectResourceByKeywords(map);
	}

	@Override
	public ResourceDetail getResourceById(Map<String, Object> map) {
		return resourceMapper.selectResourceById(map);
	}

	@Override
	public int updateResourceById(Map<String, Object> map) {
		return resourceMapper.updateResourceById(map);
	}

	@Override
	public int getResourceByKeywordsCount(Map<String, Object> map) {
		
		return resourceMapper.selectResourceByKeywordsCount(map);
	}

	@Override
	public int createResource(ResourceParam resource) {
		
		Long time = System.currentTimeMillis();
		Integer vId = new Integer(time.intValue());
		
		resource.setvId(vId);
		resource.setInTime(new Date());
		resource.setIsDel(0);
		resource.setFabulousCounts(0);
		resource.setPlayCounts(0);
		resource.setDisComment(0);
		resource.setInvalid(0);
		int row = resourceMapper.insertResource(resource);
		return row;
	}

}
