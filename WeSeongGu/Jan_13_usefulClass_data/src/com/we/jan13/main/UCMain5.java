package com.we.jan13.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class UCMain5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String d = "1999/05/30";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			Date d2 = sdf2.parse(d);// 예외 처리 필수
			System.out.println(d2);
			
			// 요일만 보기
			sdf2 = new SimpleDateFormat("E",Locale.ENGLISH);
			String yoil =sdf2.format(d2);
			System.out.println(yoil);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String student = "홍길동,19990530,100,90,50";
		String[] student2 =  student.split(",");
		Date now = new Date();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy");
		String now2 = sdf.format(now);
		System.out.println(now2);
		int intNow= Integer.parseInt(now2);
		int bdate=0;
		try {
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			Date d2 = sdf2.parse(student2[1]);// 예외 처리 필수
			System.out.println(d2);
			sdf2 = new SimpleDateFormat("Y");
			String yoil =sdf2.format(d2);
			System.out.println(yoil);
			bdate = Integer.parseInt(yoil);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int age = intNow - bdate;
		System.out.println(student2[0]);
		System.out.println(age);
		System.out.println(student2[2]);
		System.out.println(student2[3]);
		System.out.println(student2[4]);
		int sum=0;
		for (int i = 2; i < student2.length; i++) {
			sum += Integer.parseInt(student2[i]);
		}
		System.out.println(sum/3.0);
	}

}
