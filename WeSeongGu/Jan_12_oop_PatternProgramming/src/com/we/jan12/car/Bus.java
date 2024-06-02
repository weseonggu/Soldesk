package com.we.jan12.car;

public class Bus extends Car{

	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bus(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("버스");
	}
}
