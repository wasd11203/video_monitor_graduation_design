package com.monitor.controller.ext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.monitor.controller.BasicController;
import com.monitor.entity.Comment;
import com.monitor.service.CommentService;

/**
 * 评论 Controller
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午11:00:32
 *
 */
@Controller("commentController")
@RequestMapping("/comment")
public class CommentController extends BasicController{

	@Value("${result.pageSize}")
	private String resultPageSize;
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/list/json")
	@ResponseBody
	public JSONObject getCommentList(String vId,Integer curPage){

		logger.info("根据视频Id:[{}]列出视频的第[{}]页评论",vId,curPage);
		
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = new Integer(vId);
		
		Integer pageSize = new Integer(resultPageSize);
		
		int startIndex = (curPage-1)*pageSize;
		
		map.put("vId", id);
		map.put("startIndex", startIndex);
		map.put("pageSize", pageSize);
		
		List<Comment> comments = commentService.getCommentListByVid(map);
		int count = commentService.getCommentsCountByVid(map);
		jobj.put("list", comments);
		jobj.put("count", count);
		
		return jobj;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public JSONObject updateComment(String dcId,String vId,String dcComment,String isDel,String fabulousCounts){
		logger.info("更新评论:[{}],[{}],[{}],[{}],[{}],[{}]",dcId,vId,dcComment,isDel,fabulousCounts);
		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Integer id = new Integer(dcId);
		Integer v = new Integer(vId);
		Integer dc = new Integer(dcComment);
		Integer del = new Integer(isDel);
		Integer fab = new Integer(fabulousCounts);
		
		map.put("dcId", id);
		map.put("vId", v);
		map.put("dcComment", dc);
		map.put("isDel", del);
		map.put("fabulousCounts", fab);
		
		int row = commentService.updateComment(map);
		
		if(row > 0){
			jobj.put("code", 0);
		}else{
			jobj.put("code", 1);
		}
		
		return jobj;
	}
	
}
