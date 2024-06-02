package com.we.jan12.car;

public class Car {
	private int number;

	Car() {
	}

	Car(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void printInfo() {
		System.out.println(number);
		System.out.println("만들었다");
	}



}
