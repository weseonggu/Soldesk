package com.we.jan31.main;

public class HomeController {
	public static void main(String[] args) {
		Search s  =new Search();
		SendInfo ran = null;
		try {
			ran = s.input_info();
			System.out.println(Back.reg(ran));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("잘못 입력 하심요");
		}
		s.killsc();
	}
}
