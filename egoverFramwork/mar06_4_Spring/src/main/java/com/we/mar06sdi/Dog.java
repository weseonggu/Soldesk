package com.we.mar06sdi;

public class Dog {
	private String name;
	private int age;

	public Dog() {
		// TODO Auto-generated constructor stub
		System.out.println("생성자");
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("매개변수 있는생성자");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("setter");
	}

}
