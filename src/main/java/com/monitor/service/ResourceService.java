package com.monitor.service;

import java.util.List;
import java.util.Map;

import com.monitor.entity.Resource;
import com.monitor.entity.ResourceDetail;
import com.monitor.entity.vo.ResourceParam;

/**
 * 视频资源 业务层 接口
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午4:54:30
 *
 */
public interface ResourceService {
	
	/**
	 * 根据关键字查询 视频列表
	 * @param map
	 * @return
	 */
	public List<Resource> getResourceListByKeywords(Map<String, Object> map);
	
	/**
	 * 获取根据关键字可查询到的视频总数
	 * @param map
	 * @return
	 */
	public int getResourceByKeywordsCount(Map<String, Object> map);
	
	/**
	 * 根据 视频id查找视频
	 * @param map
	 * @return
	 */
	public ResourceDetail getResourceById(Map<String, Object> map);
	
	/**
	 * 根据 视频 id 更新视频信息
	 * @param map
	 * @return
	 */
	public int updateResourceById(Map<String, Object> map);
	
	/**
	 * 创建一条视频记录
	 * @param resource
	 * @return
	 */
	public int createResource(ResourceParam resource);
}
