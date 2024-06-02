package com.we.mar065sdi.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClacController {
	
	@Autowired
	private CalcDAO cDAO;
	
	
	//reqest paramater 받아오기
	// 1. 기존jsp 스타일 (사진 처리에 사용)
	@RequestMapping(value="/calculate.do1", method = RequestMethod.GET)
	public String index1(HttpServletRequest req) {
		System.out.println("계산하고");
		int x= Integer.parseInt(req.getParameter("x"));
		int y= Integer.parseInt(req.getParameter("y"));
		System.out.println(x);
		System.out.println(y);
		return "output";
	}
	// 2.Spring 스타일
	@RequestMapping(value="/calculate.do2", method = RequestMethod.GET)
	public String index2(
			@RequestParam(value="x") int xx, 
			@RequestParam(value="y") int yy) 
	{
		System.out.println(xx);
		System.out.println(yy);
		return "output";
	}
	//3. Spring 스타일 (객체로  만들어줌) 
	@RequestMapping(value="/calculate.do3", method = RequestMethod.GET)
	public String index3(XXXYYY xxxyyy){
		System.out.println(xxxyyy.getX());
		System.out.println(xxxyyy.getY());
		return "output";
	}
	// 4번
	@RequestMapping(value="/calculate.do", method = RequestMethod.GET)
	public String calxDo(XXXYYY xxxyyy, HttpServletRequest req){
		cDAO.calculate(xxxyyy, req);
		return "output";
	}
	// 1,2,4번을 섞어서  사용
}
