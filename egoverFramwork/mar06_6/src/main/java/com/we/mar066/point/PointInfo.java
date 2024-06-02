package com.we.mar066.point;

public class PointInfo {
	private String name;
	private int price;
	private double point;

	public PointInfo() {
		// TODO Auto-generated constructor stub
	}

	public PointInfo(String name, int price, double point) {
		super();
		this.name = name;
		this.price = price;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

}
