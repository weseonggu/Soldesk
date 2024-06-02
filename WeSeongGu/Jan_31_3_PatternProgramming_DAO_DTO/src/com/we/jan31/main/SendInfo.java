package com.we.jan31.main;

public class SendInfo {
	private int no;
	private String n;
	private String d;
	private String l;
	private int p;

	public SendInfo() {
		// TODO Auto-generated constructor stub
	}

	public SendInfo( String n, String d, String l, int p) {
		super();

		this.n = n;
		this.d = d;
		this.l = l;
		this.p = p;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getP() {
		return p;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}

}
