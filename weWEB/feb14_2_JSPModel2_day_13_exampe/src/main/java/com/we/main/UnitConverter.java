package com.we.main;

import javax.servlet.http.HttpServletRequest;

public class UnitConverter {
	private static final UnitConverter UC = new UnitConverter();
	public UnitConverter() {
		// TODO Auto-generated constructor stub
	}
	public void convert(HttpServletRequest request) {
		double data = Double.parseDouble(request.getParameter("data"));
		String danwe = request.getParameter("danwe");
		String input = null;
		String result = null;
		String color = null;
		if (danwe.equals("inch")) {
			input = Double.toString(data) + " cm";
			result = Double.toString(Math.round((data / 2.54) * 10) / 10.0) + " inch";
			color = "red";
		} else if (danwe.equals("pung")) {
			input = Double.toString(data) + " ㎡";
			result = Double.toString(Math.round((data * 0.3025) * 10) / 10.0) + " 평";
			color = "blue";
		} else if (danwe.equals("mi")) {
			input = Double.toString(data) + " km/h";
			result = Double.toString(Math.round((data / 1.609344) * 10) / 10.0) + " mi/h";
			color = "gray";
		} else if (danwe.equals("f")) {
			input = Double.toString(data) + " ℃";
			result = Double.toString(Math.round((32 + (1.8 * data)) * 10) / 10.0) + " ℉";
			color = "orange";
		}
		System.out.println(input);
		System.out.println(color);
		System.out.println(result);
		request.setAttribute("color", color);
		request.setAttribute("input", input);
		request.setAttribute("result", result);
	}
	public static UnitConverter getUc() {
		return UC;
	}
	
	
}
