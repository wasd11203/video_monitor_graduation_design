package com.monitor.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monitor.entity.Comment;
import com.monitor.mapper.CommentMapper;
import com.monitor.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<Comment> getCommentListByVid(Map<String, Object> map) {
		return commentMapper.selectCommentsByVid(map);
	}

	@Override
	public int updateComment(Map<String, Object> map) {
		
		return commentMapper.updateComment(map);
	}

	@Override
	public int getCommentsCountByVid(Map<String, Object> map) {
		return commentMapper.selectCommentsCountByVid(map);
	}

}
