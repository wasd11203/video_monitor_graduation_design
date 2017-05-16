package com.monitor.util.file.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.monitor.controller.BasicController;
import com.monitor.util.file.service.IconService;

@Controller
@RequestMapping("/icon")
public class IconController extends BasicController{

	@Value("${uploadPath}")
	private String directory;
	
	@Value("${iconPath}")
	private String iconPath;
	
	@Value("${request.server}")
	private String requestServer;
	
	@Autowired
	private IconService iconService;
	
	@RequestMapping("/upload")
	@ResponseBody
	public JSONObject upload(MultipartFile picFileMpf, HttpServletRequest req){
		logger.debug("上传的文件为：[{}]",picFileMpf.getOriginalFilename());
		String realPath = req.getSession().getServletContext().getRealPath("/");
		realPath += File.separator+directory;
		realPath += File.separator+iconPath;
		JSONObject jobj = iconService.upload(picFileMpf, realPath);
		String fileName = (String) jobj.get("fileName");	
		jobj.put("fileName", requestServer+directory+iconPath+fileName);
		return jobj;
	}
	
}
