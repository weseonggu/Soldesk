package com.we.jan12_01.market;

public class Food extends Market {
	private String ex;

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String product, int price, String ex) {
		super(product, price);
		this.ex = ex;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("유통기한: "+ ex);
	}
}
