package com.we.jan13.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UCMain4 {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		System.out.println(now.getYear()+1900);// +1900
		System.out.println(now.getMonth()+1);// +1
		System.out.println(now.getDate());
		// 자바가 업데이트되면서 안맞음 
		// deprecated(더이상 사용하지 않음)
		
		// Date -> String
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy MM");
		String now2 = sdf.format(now);
		System.out.println(now2);
		
		// 특정 시간 날짜
		// String -> Date
		try {
			String d = "2000-01-01";
			SimpleDateFormat sdf2 =  new SimpleDateFormat("yyyy-MM-dd");
			Date d2 =sdf2.parse(d);// 예외 처리 필수
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
