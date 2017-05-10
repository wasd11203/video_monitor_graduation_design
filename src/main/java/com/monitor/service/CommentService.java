package com.monitor.service;

import java.util.List;
import java.util.Map;

import com.monitor.entity.Comment;

/**
 * 评论 业务层接口
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午8:40:41
 *
 */
public interface CommentService {

	/**
	 * 根据 视频Id查询评论列表
	 * @param map
	 * @return
	 */
	public List<Comment> getCommentListByVid(Map<String, Object> map);

	/**
	 * 获取指定视频id下的评论总数
	 * @param map
	 * @return
	 */
	public int getCommentsCountByVid(Map<String, Object> map);
	
	/**
	 * 更新评论 状态等。。
	 * @param map
	 * @return
	 */
	public int updateComment(Map<String, Object> map);
}
