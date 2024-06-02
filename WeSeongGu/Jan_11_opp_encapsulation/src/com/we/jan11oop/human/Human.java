package com.we.jan11oop.human;
//캡슐화
public class Human {
	// private 으로 외부 접근 막기
	private String name;
	private int age;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}

//public맴버 변수는 외부에서 맴버 변수를 접근해서 잘못 된걸로 변경 할 수 있다.
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
		// 목적과 다른 변경을 감지하는 안전장치 
		if(age<0) {
			age*=-1;
		}
		this.age = age;
	}
}
