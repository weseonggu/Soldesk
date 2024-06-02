package com.we.janoop.main;

public class BoardMaker {
	// 1. 맴버 변수
	private String name;
	private String color;
	private static final String MAKER = "모나미";

	// 2-1. 기본 생성자
	public BoardMaker() {
		// TODO Auto-generated constructor stub
	}

	// 2-2. 오버라이딩된 생성자
	public BoardMaker(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	// 3. getter setter 필요한 것만 하기
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	// 4. 기타 메소드
	public void printInfo() {
		System.out.println(name);
		System.out.println(color);
	}

}
