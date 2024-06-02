package com.we.jan31.main;
// DYO : 데이터를 임시로 저장하는 객체
public class CalcResult {
	private int hab;
	private int cha;
	private int gob;
	private int moks;
	
	public CalcResult() {
		// TODO Auto-generated constructor stub
	}

	public CalcResult(int hab, int cha, int gob, int moks) {
		super();
		this.hab = hab;
		this.cha = cha;
		this.gob = gob;
		this.moks = moks;
	}

	public int getHab() {
		return hab;
	}

	public void setHab(int hab) {
		this.hab = hab;
	}

	public int getCha() {
		return cha;
	}

	public void setCha(int cha) {
		this.cha = cha;
	}

	public int getGob() {
		return gob;
	}

	public void setGob(int gob) {
		this.gob = gob;
	}

	public int getMoks() {
		return moks;
	}

	public void setMoks(int moks) {
		this.moks = moks;
	}
	public void printInfo() {
		System.out.println(gob);
		System.out.println(cha);
		System.out.println(hab);
		System.out.println(moks);
	}
	
	
}
