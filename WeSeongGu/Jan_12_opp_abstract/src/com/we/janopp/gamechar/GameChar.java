package com.we.janopp.gamechar;
// 추상: 추상적인 개념 실체가 있는게 아님
// 추상 클래스: 추상 클래스는 객체를 생성할 수 없다. 이유: 미완성 메소드가 있어서 
// 추상 메소드
// 		추상 메소드를 하나라도 가지고 있으면 추상 클래스여야 한다.
//		상속 받은 하위 클래스에서 반듯이 재정(오버라이딩)을 해야한다.
public abstract class GameChar {// 추상 클래스
	private String name;
	private int age;
	
	public GameChar() {
		// TODO Auto-generated constructor stub
	}

	public GameChar(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
	}
	public abstract void attack();// 추상 메소드
}
