package com.we.mar141;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.we.mar141.data.DataDAO;

@Controller
public class HomeController {
	@Autowired
	private DataDAO dDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		dDAO.getDatas(req);
		return "index";
	}
	
}
