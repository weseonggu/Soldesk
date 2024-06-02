package com.we.main;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class AgeCalculator {
	private static final AgeCalculator AGECALCULATOR= new AgeCalculator();
	
	private AgeCalculator() {
		// TODO Auto-generated constructor stub
	}

	public static AgeCalculator getAgecalculator() {
		return AGECALCULATOR;
	}
	
	public void getAge(HttpServletRequest request) {
		
		// 한글 처리 해야함
		// 이름, 생일 다받아서 한글처리하고 보내 주어야함
		try {
			request.setCharacterEncoding("euc-kr");// 한글처리
			String n = request.getParameter("nnn");
			String b = request.getParameter("bir");
			int birthyear = Integer.parseInt(b.substring(0,4));
			
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			int curyear = Integer.parseInt(sdf.format(now));
			int age = curyear - birthyear+1;
			
			ArrayList<Person> arr = new ArrayList<>();
			arr.add(new Person("kim", 30));
			arr.add(new Person("lee", 40));
			arr.add(new Person("chi", 25));
			request.setAttribute("people", arr);
			
			Person p = new Person(n, age);
			request.setAttribute("pp", p);
			request.setAttribute("a", 10);
			System.out.println(n);
			System.out.println(b);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
