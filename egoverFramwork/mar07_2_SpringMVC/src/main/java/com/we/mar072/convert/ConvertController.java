package com.we.mar072.convert;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvertController {
	
	@Autowired
	private ConvertDAO cDAO;
	
	@RequestMapping(value = "/convert.do", method = RequestMethod.GET)
	public String convert(UCResult ur, HttpServletRequest req){
		cDAO.convertNum(ur, req);
		return "output";
	}
}
