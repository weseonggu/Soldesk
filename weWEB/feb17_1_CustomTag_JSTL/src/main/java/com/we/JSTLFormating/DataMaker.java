package com.we.JSTLFormating;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest request) {
		int x = new Random().nextInt(10);
		String[] ar = {"q","W","h","x"};
		
		request.setAttribute("ar", ar);
		request.setAttribute("xxx", x);
		
	}
}
