package com.we.janopp.gamechar;

public class Hark extends GameChar {
	private int size;

	public Hark() {
		// TODO Auto-generated constructor stub
	}

	public Hark(String name, int age, int size) {
		super(name, age);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(size);
	}
	@Override
	public void attack() {
		System.out.println("주먹질");
	}

}
