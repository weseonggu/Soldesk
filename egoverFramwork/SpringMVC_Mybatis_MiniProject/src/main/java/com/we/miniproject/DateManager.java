package com.we.miniproject;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest req) {
		Date now = new  Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		req.setAttribute("curYear", sdf.format(now));
	}
}
