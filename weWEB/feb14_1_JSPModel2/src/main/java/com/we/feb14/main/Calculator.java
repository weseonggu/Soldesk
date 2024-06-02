package com.we.feb14.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public static void add(HttpServletRequest req) {
		int a=Integer.parseInt( req.getParameter("a"));
		int b=Integer.parseInt( req.getParameter("b"));
		req.setAttribute("zz", a+b);
	}
}
