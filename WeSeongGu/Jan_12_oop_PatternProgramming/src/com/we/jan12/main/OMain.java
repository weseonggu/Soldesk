package com.we.jan12.main;

import com.we.jan12.myself.WeSeoungGu;
import com.we.jan12.soldesk.AnYoungGang;
import com.we.jan12.soldesk.Student;

//onlyone 객체: singleton패턴 중요 spring에서 사용함
public class OMain {
	public static void main(String[] args) {
		WeSeoungGu we1 = WeSeoungGu.getInstance();// 객체 불러 오기
		WeSeoungGu we2 = WeSeoungGu.getInstance();
		System.out.println(we1);
		System.out.println(we2);
		we1.printInfo();

		AnYoungGang q = AnYoungGang.getAn();
		q.printInfo();

		System.out.println("--------------------------------");

		Student s1 = q.consult("홍길동", 30, "양주");
		Student s2 = q.consult("김길동", 20, "포천");

		s1.printInfo();
		s2.printInfo();
	}
}
