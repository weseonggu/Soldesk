package com.we.jan31.main;

// AOP(Aspect Oriented Programming)
// 관점 지향 프로그래밍
// 공통된거 정리

public class Human {
	
	private void ready() {
		System.out.println("씻고");
		System.out.println("옷입고 신발 신고");
		System.out.println("넹베타고 내려가서");
	}
	public void goSchool() {
//		System.out.println("씻고");
//		System.out.println("옷입고 신발 신고");
//		System.out.println("넹베타고 내려가서");
		ready();
		System.out.println("마을 버스 타고 지하철역 가서");
		System.out.println("지하철 타고 또타고");
		System.out.println("도착");
	}
	public void goMart() {
//		System.out.println("씻고");
//		System.out.println("옷입고 신발 신고");
//		System.out.println("넹베타고 내려가서");
		ready();
		System.out.println("걸어서");
		System.out.println("도착");
	}
	public void goPark() {
//		System.out.println("씻고");
//		System.out.println("옷입고 신발 신고");
//		System.out.println("넹베타고 내려가서");
		ready();
		System.out.println("자전거 타고가서");
		System.out.println("도착");
	}
}
