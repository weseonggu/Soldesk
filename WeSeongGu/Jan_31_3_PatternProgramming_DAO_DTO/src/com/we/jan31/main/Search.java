package com.we.jan31.main;

import java.util.Scanner;

public class Search {
	Scanner what = null;
	
	public Search() {
		what = new Scanner(System.in);
	}
	
	public SendInfo input_info() throws Exception {
		System.out.print("휴개소 이름: ");
		String n =what.next();
		System.out.print("방향: ");
		String d =what.next();
		System.out.print("위치: ");
		String l =what.next();
		System.out.print("주차 대수: ");
		int p =what.nextInt();
		return new SendInfo(n, d, l, p);
		
	}
	
	public void killsc() {
		what.close();
	}
	
}
