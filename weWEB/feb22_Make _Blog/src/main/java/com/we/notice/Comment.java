package com.we.notice;

import java.util.Date;

public class Comment {
	private int bnr_no;
	private int bnr_bn_no;
	private String bnr_writer;
	private String bnr_txt;
	private Date bnr_date;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int bnr_no, int bnr_bn_no, String bnr_writer, String bnr_txt, Date bnr_date) {
		super();
		this.bnr_no = bnr_no;
		this.bnr_bn_no = bnr_bn_no;
		this.bnr_writer = bnr_writer;
		this.bnr_txt = bnr_txt;
		this.bnr_date = bnr_date;
	}

	public int getBnr_no() {
		return bnr_no;
	}

	public void setBnr_no(int bnr_no) {
		this.bnr_no = bnr_no;
	}

	public int getBnr_bn_no() {
		return bnr_bn_no;
	}

	public void setBnr_bn_no(int bnr_bn_no) {
		this.bnr_bn_no = bnr_bn_no;
	}

	public String getBnr_writer() {
		return bnr_writer;
	}

	public void setBnr_writer(String bnr_writer) {
		this.bnr_writer = bnr_writer;
	}

	public String getBnr_txt() {
		return bnr_txt;
	}

	public void setBnr_txt(String bnr_txt) {
		this.bnr_txt = bnr_txt;
	}

	public Date getBnr_date() {
		return bnr_date;
	}

	public void setBnr_date(Date bnr_date) {
		this.bnr_date = bnr_date;
	}
	
	
	
	
}
//bnr_no number(4) PRIMARY key,
//bnr_bn_no number(3) not null,
//bnr_writer varchar2(10 char)not null,
//bnr_txt varchar2(200 char) not null,
//bnr_date date not null,