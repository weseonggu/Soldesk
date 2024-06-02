package com.we.mar071.conversion;

public class UCResult {
	private String from;
	private double result;
	private String to;
	
	public UCResult() {
		// TODO Auto-generated constructor stub
	}

	public UCResult(String from, double result, String to) {
		super();
		this.from = from;
		this.result = result;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}
