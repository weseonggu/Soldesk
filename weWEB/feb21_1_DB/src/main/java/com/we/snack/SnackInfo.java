package com.we.snack;

public class SnackInfo {
	private int s_no;
	private String s_name;
	private int s_price;
	
	public SnackInfo() {
		// TODO Auto-generated constructor stub
	}

	public SnackInfo(int s_no, String s_name, int s_price) {
		super();
		this.s_no = s_no;
		this.s_name = s_name;
		this.s_price = s_price;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}
	
	
}
