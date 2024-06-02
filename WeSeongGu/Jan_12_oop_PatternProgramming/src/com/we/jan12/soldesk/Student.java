package com.we.jan12.soldesk;

public class Student {
	private int no;
	private String name;
	private int age;
	private String address;

	// 1. 다른 패키지에서 개채를 못 만들게 함
	// 2. factory 역할을 할 클래스 여기서는 AnYoungGang클래스
	Student() {
		// TODO Auto-generated constructor stub
	}

	Student(int no, String name, int age, String address) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void printInfo() {
		System.out.println(no);
		System.out.println(name);
		System.out.println(age);
		System.out.println(address);
	}
}
