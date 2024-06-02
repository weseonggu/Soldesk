package com.we.mar072.convert;

public class UCResult {
	private double num;
	private String danwi;
	private String from;
	private double result;
	private String to;

	public UCResult() {
		// TODO Auto-generated constructor stub
	}

	public UCResult(double num, String danwi, String from, double result, String to) {
		super();
		this.num = num;
		this.danwi = danwi;
		this.from = from;
		this.result = result;
		this.to = to;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getDanwi() {
		return danwi;
	}

	public void setDanwi(String danwi) {
		this.danwi = danwi;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}
