package com.we.jan20.main;

public class Student {
	private String name;
	private int kor;
	private int mat;
	private int eng;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(String name, int kor, int mat, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getMat() {
		return mat;
	}


	public void setMat(int mat) {
		this.mat = mat;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}
	public void printInfo() {
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(mat);
	}
}
