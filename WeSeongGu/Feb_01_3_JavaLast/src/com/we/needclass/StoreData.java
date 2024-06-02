package com.we.needclass;

public class StoreData {
	private String brand;
	private String jijum;
	private String loction;
	private int cvsNum;
	
	public StoreData() {
		// TODO Auto-generated constructor stub
	}

	public StoreData(String brand, String jijum, String loction) {
		super();
		this.brand = brand;
		this.jijum = jijum;
		this.loction = loction;
	}
	
	public StoreData(String jijum, int cvsNum) {
		super();
		this.jijum = jijum;
		this.cvsNum = cvsNum;
	}

	public int getCvsNum() {
		return cvsNum;
	}

	public void setCvsNum(int cvsNum) {
		this.cvsNum = cvsNum;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getJijum() {
		return jijum;
	}

	public void setJijum(String jijum) {
		this.jijum = jijum;
	}

	public String getLoction() {
		return loction;
	}

	public void setLoction(String loction) {
		this.loction = loction;
	}
	
}
