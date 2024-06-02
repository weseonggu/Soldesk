package com.we.miniproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenGenerater {
	public static void generater(HttpServletRequest req) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		req.setAttribute("token", sdf.format(now));
	}
}
