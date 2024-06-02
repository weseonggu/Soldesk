package com.we.notice;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

public class TokenGenerator {
	
	
	
	public static void gernerate(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSS");
		String token =sdf.format(now);
		request.setAttribute("token", token);
	}
}
