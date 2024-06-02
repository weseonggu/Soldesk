package com.we.jan12_01.market;

public class Market {
	private String product;
	private int price;

	public Market() {
		// TODO Auto-generated constructor stub
	}

	public Market(String product, int price) {
		super();
		this.product = product;
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.println("상품명 "+product);
		System.out.println("가격: "+price);
	}

}
