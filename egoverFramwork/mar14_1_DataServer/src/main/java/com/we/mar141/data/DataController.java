package com.we.mar141.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {
	@Autowired
	private DataDAO mDAO;
	
	@RequestMapping(value = "/macro.get", 
			method = RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	public @ResponseBody DataInfos macroGet(
			HttpServletRequest req, HttpServletResponse res) {
		// 이 프로젝트 외부의 JavaScript에서도 쓸 수 있게
		res.setHeader("Access-Control-Allow-Origin", "*");
		return mDAO.getJSON(req); 
	}
}
