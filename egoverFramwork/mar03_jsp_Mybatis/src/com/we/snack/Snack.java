package com.we.snack;

import java.math.BigDecimal;
import java.util.Date;

public class Snack {
	private BigDecimal s_no;
	private String s_name;
	private BigDecimal s_price;
	private Date s_exp;
	
	public Snack() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getS_no() {
		return s_no;
	}

	public void setS_no(BigDecimal s_no) {
		this.s_no = s_no;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public BigDecimal getS_price() {
		return s_price;
	}

	public void setS_price(BigDecimal s_price) {
		this.s_price = s_price;
	}

	public Date getS_exp() {
		return s_exp;
	}

	public void setS_exp(Date s_exp) {
		this.s_exp = s_exp;
	}
	
	
}
//S_no number(3)PRIMARY key,
//S_name varchar2(10 char) not null,
//s_price number(4) not null,
//s_exp date not null