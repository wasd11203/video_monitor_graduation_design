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
import com.monitor.entity.Resource;
import com.monitor.entity.ResourceDetail;
import com.monitor.entity.vo.ResourceParam;
import com.monitor.service.ResourceService;

/**
 * 首页相关控制器
 *
 * @author ganzhigang time: 2017年4月29日 下午4:22:51
 *
 */
@Controller("resourceController")
@RequestMapping("/resource")
public class ResourceController extends BasicController {

	@Value("${result.pageSize}")
	private String resultPageSize;

	@Autowired
	private ResourceService resourceService;

	@RequestMapping("/search")
	@ResponseBody
	public JSONObject searchByMark(String mId,String vTopId,String vSecId,String keywords, int curPage) {

		logger.info("管理员:[{}],一级分类:[{}],二级分类:[{}],关键词:[{}]",mId,vTopId,vSecId, keywords);

		JSONObject jobj = new JSONObject();
		Map<String, Object> map = new HashMap<String, Object>();
		int pageSize = Integer.parseInt(resultPageSize);
		int start = (curPage - 1) * pageSize;
		
		Integer m = null;
		Integer top = null;
		Integer sec = null;
		
		if(mId != null && !mId.trim().isEmpty()){
			m = new Integer(mId);
		}
		if(vTopId != null && !vTopId.trim().isEmpty()){
			top = new Integer(vTopId);
		}
		if(vSecId != null && !vSecId.trim().isEmpty()){
			sec = new Integer(vSecId);
		}
		
		map.put("mId", m);
		map.put("vTopId", top);
		map.put("vSecId", sec);
		map.put("keywords", keywords);
		map.put("startIndex", start);
		map.put("pageSize", pageSize);

		List<Resource> res = resourceService.getResourceListByKeywords(map);
		int count = resourceService.getResourceByKeywordsCount(map);

		jobj.put("list", res);
		jobj.put("count", count);

		return jobj;
	}

	@RequestMapping("/detail")
	@ResponseBody
	public ResourceDetail loadResourceDetail(String vId) {
		logger.info("根据视频Id:[{}]列出视频信息", vId);
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = new Integer(vId);

		map.put("vId", id);

		ResourceDetail detail = resourceService.getResourceById(map);

		return detail;
	}

	@RequestMapping("/update")
	@ResponseBody
	public JSONObject updateResourceById(String vId,String vTitle,String vName,
										String vPic,String vIntroduce,String vPath,
										String playCounts,String duration,String fabulousCounts,
										String isDel,String vSecId,String mId,
										String disComment,String invalid){
		logger.info("更新视频信息：[{}],[{}],[{}],"
					+ "[{}],[{}],[{}],"
					+ "[{}],[{}],[{}],"
					+ "[{}],[{}],[{}],"
					+ "[{}],[{}]",
					vId,vTitle,vName,
					vPic,vIntroduce,vPath,
					playCounts,duration,fabulousCounts,
					isDel,vSecId,mId,
					disComment,invalid);
		JSONObject jobj = new JSONObject();
		
		Map<String, Object> map = transToMap(vId, vTitle, vName, vPic, vIntroduce, vPath, playCounts, duration, fabulousCounts, isDel, vSecId,
				mId, disComment,invalid);
		
		int row = resourceService.updateResourceById(map);
		jobj.put("code", 0);
		jobj.put("row", row);
		return jobj;
	}

	@RequestMapping("/create")
	@ResponseBody
	public JSONObject addVideo(ResourceParam param) {
		logger.info("新增视频信息：[{}]",param);
		int row = resourceService.createResource(param);
		JSONObject jobj = new JSONObject();
		jobj.put("code", 0);
		jobj.put("row", row);

		return jobj;
	}

	/**
	 * 参数转换为map
	 * 
	 * @param vId
	 * @param vTitle
	 * @param vName
	 * @param vPic
	 * @param vIntroduce
	 * @param vPath
	 * @param playCounts
	 * @param duration
	 * @param fabulousCounts
	 * @param isDel
	 * @param vSecId
	 * @param mId
	 * @param disComment
	 * @return
	 */
	protected Map<String, Object> transToMap(String vId, String vTitle, String vName, String vPic, String vIntroduce,
			String vPath, String playCounts, String duration, String fabulousCounts, String isDel, String vSecId,
			String mId, String disComment,String invalid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = null;
		Integer play = null;
		Integer dur = null;
		Integer fabulous = null;
		Integer del = null;
		Integer vSec = null;
		Integer m = null;
		Integer dis = null;
		Integer inval = null;
		
		if (vId != null && !vId.trim().isEmpty()) {
			id = new Integer(vId);
		}
		if (playCounts != null && !playCounts.trim().isEmpty()) {
			play = new Integer(playCounts);
		}
		if (duration != null && !duration.trim().isEmpty()) {
			dur = new Integer(duration);
		}
		if (fabulousCounts != null && !fabulousCounts.trim().isEmpty()) {
			fabulous = new Integer(fabulousCounts);
		}
		if (isDel != null && !isDel.trim().isEmpty()) {
			del = new Integer(isDel);
		}
		if (vSecId != null && !vSecId.trim().isEmpty()) {
			vSec = new Integer(vSecId);
		}
		if (mId != null && !mId.trim().isEmpty()) {
			m = new Integer(mId);
		}
		if (disComment != null && !disComment.trim().isEmpty()) {
			dis = new Integer(disComment);
		}
		if (invalid != null && !invalid.trim().isEmpty()) {
			inval = new Integer(invalid);
		}
		
		map.put("vId", id);
		map.put("vTitle", vTitle);
		map.put("vName", vName);
		map.put("vPic", vPic);
		map.put("vIntroduce", vIntroduce);
		map.put("vPath", vPath);
		map.put("playCounts", play);
		map.put("duration", dur);
		map.put("fabulousCounts", fabulous);
		map.put("isDel", del);
		map.put("vSecId", vSec);
		map.put("mId", m);
		map.put("disComment", dis);
		map.put("invalid", inval);
		
		return map;
	}

}
