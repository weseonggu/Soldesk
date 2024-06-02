package com.we.mar065sdi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP :  Servlet
//		doGet, doPost - 요청  2개  가능
// Spring : 일반 class
//		일반 메소드

@Controller
public class HomeController {
	// 사이트 첫 방문
	// String return으로 리턴 값의 jsp를 띄어줌
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		System.out.println("테스트");
		return "input";
	}
	
	//http://localhost/mar065sdi/test.t로  get방식 
	@RequestMapping(value="/test.t", method = RequestMethod.GET)
	public void test() {
		System.out.println("테스트");
	}
}
