package com.we.home;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int curYear = Integer.parseInt(sdf.format(now));
		request.setAttribute("cy", curYear);
	}
}
