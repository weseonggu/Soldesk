package com.we.jan12.soldesk;

public class AnYoungGang {
	private int studentCount;
	private String name;
	private static final AnYoungGang an = new AnYoungGang("안영광");

	private AnYoungGang() {
		// TODO Auto-generated constructor stub
	}

	private AnYoungGang(String name) {
		super();
		this.name = name;
	}

	public static AnYoungGang getAn() {
		return an;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printInfo() {
		System.out.println(name);
	}
	// factory 패턴
	public Student consult(String n, int a, String h) {
		studentCount++;
		return new Student(studentCount, n, a, h);
	}

}
