package com.we.main;

public class Guest {
	private String name;
	private double h;
	private double w;
	private String fname;
	private double bmi;
	private String result;
	
	public Guest() {
		// TODO Auto-generated constructor stub
	}

	public Guest(String name, double h, double w, String fname, double bmi, String result) {
		super();
		this.name = name;
		this.h = h;
		this.w = w;
		this.fname = fname;
		this.bmi = bmi;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
