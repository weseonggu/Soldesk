package com.we.miniproject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.we.miniproject.dataroom.DataDAO;
import com.we.miniproject.member.Member;
import com.we.miniproject.member.MemberDAO;
import com.we.miniproject.sns.SnsDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SnsDAO sDAO;
	@Autowired
	private DataDAO dDAO;
	
	private boolean first;
	
	public HomeController() {
		//HomeController, SnsDAO, SqlSessin셋다
		//tomcat+ Spring에서 servlet-context.xml을 acc방식으로 자동으로 불러오는중
		// 셋중에 뭐가 처음으로 만들어지는 모름
		first =true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home1(HttpServletRequest req) {
		if(first) {
			sDAO.postCounter();
			dDAO.getDataCount();
			first=false;
		}
		mDAO.isLogined(req);
		req.setAttribute("contents", "home.jsp");
		return "index";
	}
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		return home1(req);
	}
	

	
}
