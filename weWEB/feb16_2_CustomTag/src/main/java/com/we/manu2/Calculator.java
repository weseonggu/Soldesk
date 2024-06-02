package com.we.manu2;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	
	private static final Calculator C =  new Calculator();
	private Calculator() {
		// TODO Auto-generated constructor stub
	}
	public static Calculator getC() {
		return C;
	}
	public void calc(HttpServletRequest req) {
		int x =Integer.parseInt( req.getParameter("xxx"));
		int y =Integer.parseInt( req.getParameter("yyy"));
		req.setAttribute("result", x+y);
	}
}
