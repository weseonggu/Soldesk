package com.we.jan12_01.market;

public class Book extends Market {
	private String writer;

	public Book() {
		System.out.println(getProduct());
		// TODO Auto-generated constructor stub
	}

	public Book(String product, int price, String writer) {
		super(product, price);
		this.writer = writer;
	}

	public String getWirter() {
		return writer;
	}

	public void setWirter(String wirter) {
		this.writer = wirter;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println("저자: "+writer);
	}

}
