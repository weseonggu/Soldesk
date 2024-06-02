package com.we.add;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	private static final Calculator C = new Calculator();

	private Calculator() {
	}

	public static Calculator getC() {
		return C;
	}

	public void numAdd(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			String num = req.getParameter("num");
			String[] sarr = num.split("\r\n");
			int sum = 0;
			for (int i = 0; i < sarr.length; i++) {
				try {
					sum += Integer.parseInt(sarr[i]);
				} catch (NumberFormatException e) {
					continue;
				}
			}
		req.setAttribute("sum", sum);
	}
}
