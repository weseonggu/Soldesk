package com.we.jan31.main;
//C ontroller: 흐름제어 V가 필요하면 V꺼내고 M필요하면 M꺼냄 PL급 개발자
public class C {
	public static void main(String[] args) {
		// 프로그램의 시작점
		int n = V.getNo();
		System.out.println(n);
		System.out.println(M.judge(n));
	}

}
