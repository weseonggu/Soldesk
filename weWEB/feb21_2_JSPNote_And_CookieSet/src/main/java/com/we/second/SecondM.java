package com.we.second;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondM {
	public static void pirntData(HttpServletRequest request) {
		System.out.println(request.getParameter("n"));
	}
	public static void makeData(HttpServletRequest request, HttpServletResponse res) {
		request.setAttribute("q", 20);
		//session
		double pi = 3.14;
		HttpSession hs = request.getSession();
		hs.setMaxInactiveInterval(10);// 유지시간 5초로 변경 
		// 아무것도 안하면 세션 끊어짐 -> 데이터 사라짐
		// 유지 시간안에 request하면 갱신
		// 시간안에 다른 탭에 third주소 복붙하면 정사으로 뜸
		// 하지만 브라우저를 닫으면 유지안됨 (크롬 기준)
		hs.setAttribute("pi", pi);
		
		// cookie
		int iii = 30;
		String s= iii+"";
		Cookie c = new Cookie("vvv", s);
		c.setMaxAge(10);// 무조건 10초동안 살아 있음
		//Response필요
		res.addCookie(c);
		Cookie c2 = new Cookie("bbb", "ㅋㅋㅋ");
		res.addCookie(c2);
	}
}
