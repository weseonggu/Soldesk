package com.we.needclass;

import java.util.Date;

public class Product {
	private String exp;
	private String name;
	private int price;
	private int cvs;
	private Date exp2;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String exp, String name, int price, int cvs) {
		super();
		this.exp = exp;
		this.name = name;
		this.price = price;
		this.cvs = cvs;
	}

	public Product(Date exp2, String name, int price, int cvs) {
		super();
		this.name = name;
		this.price = price;
		this.cvs = cvs;
		this.exp2 = exp2;
	}

	public Date getExp2() {
		return exp2;
	}

	public void setExp2(Date exp2) {
		this.exp2 = exp2;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
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

	public int getCvs() {
		return cvs;
	}

	public void setCvs(int cvs) {
		this.cvs = cvs;
	}

}
