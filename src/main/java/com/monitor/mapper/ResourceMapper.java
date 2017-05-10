package com.monitor.mapper;

import java.util.List;
import java.util.Map;

import com.monitor.entity.Resource;
import com.monitor.entity.ResourceDetail;
import com.monitor.entity.vo.ResourceParam;

/**
 * 视频资源 Mapper
 *
 * @author ganzhigang
 * time: 2017年4月29日 下午4:24:46
 *
 */
public interface ResourceMapper {

	/**
	 * 根据关键字查询 视频列表
	 * @param map
	 * @return
	 */
	public List<Resource> selectResourceByKeywords(Map<String, Object> map);
	
	/**
	 * 获取根据关键字可查询到的视频总数
	 * @param map
	 * @return
	 */
	public int selectResourceByKeywordsCount(Map<String, Object> map);
	
	/**
	 * 根据 视频id查找视频
	 * @param map
	 * @return
	 */
	public ResourceDetail selectResourceById(Map<String, Object> map);
	
	/**
	 * 根据 视频 id 更新视频信息
	 * @param map
	 * @return
	 */
	public int updateResourceById(Map<String, Object> map);
	
	/**
	 * 新增视频记录
	 * @param param
	 * @return
	 */
	public int insertResource(ResourceParam param);
	
}
