package com.we.needclass;

public class Search {
	private int c_no;
	private String c_barnd;
	private String c_jijum;
	private String c_location;
	private int s_no;
	private String s_exp;
	private String s_name;
	private int s_price;
	private int s_c_no;

	public Search() {
		// TODO Auto-generated constructor stub
	}

	// 전체 조회
	public Search(String c_barnd, String c_jijum, String c_location, String s_exp, String s_name, int s_price) {
		super();
		this.c_barnd = c_barnd;
		this.c_jijum = c_jijum;
		this.c_location = c_location;
		this.s_exp = s_exp;
		this.s_name = s_name;
		this.s_price = s_price;
	}

	// 상품 조회
	public Search(String s_exp, String s_name, int s_price) {
		super();
		this.s_exp = s_exp;
		this.s_name = s_name;
		this.s_price = s_price;
	}

	// 편의점 찾기 6번
	public Search(int c_no, String c_barnd, String c_jijum, String c_location) {
		super();
		this.c_no = c_no;
		this.c_barnd = c_barnd;
		this.c_jijum = c_jijum;
		this.c_location = c_location;
	}
	// 7번 선택

	public Search(String c_barnd, String c_jijum, String s_name, int s_price) {
		super();
		this.c_barnd = c_barnd;
		this.c_jijum = c_jijum;
		this.s_name = s_name;
		this.s_price = s_price;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getS_c_no() {
		return s_c_no;
	}

	public void setS_c_no(int s_c_no) {
		this.s_c_no = s_c_no;
	}

	public String getC_barnd() {
		return c_barnd;
	}

	public void setC_barnd(String c_barnd) {
		this.c_barnd = c_barnd;
	}

	public String getC_jijum() {
		return c_jijum;
	}

	public void setC_jijum(String c_jijum) {
		this.c_jijum = c_jijum;
	}

	public String getC_location() {
		return c_location;
	}

	public void setC_location(String c_location) {
		this.c_location = c_location;
	}

	public String getS_exp() {
		return s_exp;
	}

	public void setS_exp(String s_exp) {
		this.s_exp = s_exp;
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

	public void showInfoAll() {// 사실상 V(프론트엔드)가 해야하는 일이지만 귀찮으니 지금은 M(벡엔드)에서 처리하는걸로
		System.out.print(c_barnd + "\t");
		System.out.print(c_jijum + "\t");
		System.out.print(c_location + "\t\t");
		System.out.print(s_name + "\t\t");
		System.out.print(s_exp + "\t");
		System.out.println(s_price);
	}

	public void showSnackAll() {// 사실상 V(프론트엔드)가 해야하는 일이지만 귀찮으니 지금은 M(벡엔드)에서 처리하는걸로
		System.out.print(s_name + "\t\t");
		System.out.print(s_exp + "\t");
		System.out.println(s_price);
	}

	public void showSnackAll2() {// 사실상 V(프론트엔드)가 해야하는 일이지만 귀찮으니 지금은 M(벡엔드)에서 처리하는걸로
		System.out.print(c_no + "\t\t");
		System.out.print(c_barnd + "\t");
		System.out.print(c_jijum + "\t");
		System.out.println(c_location + "\t");
	}

	public void showSnackAll3() {// 사실상 V(프론트엔드)가 해야하는 일이지만 귀찮으니 지금은 M(벡엔드)에서 처리하는걸로

		System.out.print(c_barnd + "\t");
		System.out.print(c_jijum + "\t");
		System.out.print(s_name + "\t");
		System.out.println(s_price + "\t");
	}

}
