package com.we.jan12.car;

public class Sedan extends Car{
	
	public Sedan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sedan(int number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("세단");
	}
	
}
