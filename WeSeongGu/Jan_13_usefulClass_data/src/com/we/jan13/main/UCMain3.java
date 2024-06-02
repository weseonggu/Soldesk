package com.we.jan13.main;

import java.util.Scanner;

public class UCMain3 {

	public static void main(String[] args) {
		// 기본형 데이터
		// 1. 기본형은 메소드가 없음
		// 2. 데이터가 힙영역에 있어야 하는 경우가 있음
		
		
		// Wrapper Class
		// 기본형의 객체형
		
		Integer ii = new Integer(10);
		Double dd = new Double(23.123);
		Boolean bb = new Boolean(true);
		System.out.println("---------------------------");
		
		// 기본형 -> 객체형
		int a =30;
		Integer aa = new Integer(a);
		// 객체형 -> 기본형
		Double cc = new Double(123.123);
		double c = cc.doubleValue();
		
		// 기본형 -> String
		int g =123;
		String gg= g+"";
		String gg2 =String.format("%d", g);
		
		// String -> 객체형 -> 기본형
		String h ="12.334";
		Double hh = Double.parseDouble(h);
		double hh2 = hh.doubleValue();
		
		String j ="456";
		int jjj = Integer.parseInt(j);;// 자동으로 변경가능
		
		System.out.println("--------------------------");
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("숫자: ");
		String str = sc.next();
		
		String[] s=str.split(",");
		int sum=0;
		for (int i = 0; i < s.length; i++) {
			try {
				sum+=Integer.parseInt(s[i]);
			} catch (NumberFormatException e) {
				continue;
			}
		}
		System.out.println("합: "+sum);
		
		
	}

}
