package com.we.jan12.myself;

// onlyone 객체: singleton패턴 

//객체가 필요없다 : static메소드 기반으로

// 객체가 필요
// 		딱하나: singleton패턴 ex) 나자신 은 하나만 있음
// 		여러개: 평소대로
//			대량으로 만들어야함 그와중에 자동으로 뭔가 증가해야함 -> factory 패턴 

public class WeSeoungGu {
	private String name;
	private int age;
	private String address;
	// 2. 수정못하는 객체를 내부에서 생성 수정 못하니깐 public로 만들어도됨
	private static final WeSeoungGu we = new WeSeoungGu("위성구", 25, "노원구");

	// 1. 객체를 외부에서 못만들게 생성자를 제한자를 public -> private
	private WeSeoungGu() {
		// TODO Auto-generated constructor stub
	}

	private WeSeoungGu(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	// 3. 2번이 외부에서 사용 할수 있게 getter만들기

	public static WeSeoungGu getInstance() {
		return we;
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
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		System.out.println("사는 곳: " + address);
	}
}
