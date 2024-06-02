package com.we.jan12.car;

public class Truck extends Car{
	
	public Truck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Truck(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("트럭");
	}
}
