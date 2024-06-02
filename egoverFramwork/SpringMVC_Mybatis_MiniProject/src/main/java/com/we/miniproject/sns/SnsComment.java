package com.we.miniproject.sns;

import java.util.Date;

public class SnsComment {
//	bsc_no number(3) primary key,
//    bsc_bs_no number(3) not null,
//    bsc_txt varchar2(1000 char) not null,
//    bsc_date date not null,
//    bsc_writer varchar2(10 char) not null,
	private int bsc_no;
	private int bsc_bs_no;
	private String bsc_txt;
	private Date bsc_date;
	private String bsc_writer;
	
	public SnsComment() {
		// TODO Auto-generated constructor stub
	}
	public SnsComment(int bsc_no, int bsc_bs_no, String bsc_txt, Date bsc_date, String bsc_writer) {
		super();
		this.bsc_no = bsc_no;
		this.bsc_bs_no = bsc_bs_no;
		this.bsc_txt = bsc_txt;
		this.bsc_date = bsc_date;
		this.bsc_writer = bsc_writer;
	}
	public int getBsc_no() {
		return bsc_no;
	}
	public void setBsc_no(int bsc_no) {
		this.bsc_no = bsc_no;
	}
	public int getBsc_bs_no() {
		return bsc_bs_no;
	}
	public void setBsc_bs_no(int bsc_bs_no) {
		this.bsc_bs_no = bsc_bs_no;
	}
	public String getBsc_txt() {
		return bsc_txt;
	}
	public void setBsc_txt(String bsc_txt) {
		this.bsc_txt = bsc_txt;
	}
	public Date getBsc_date() {
		return bsc_date;
	}
	public void setBsc_date(Date bsc_date) {
		this.bsc_date = bsc_date;
	}
	public String getBsc_writer() {
		return bsc_writer;
	}
	public void setBsc_writer(String bsc_writer) {
		this.bsc_writer = bsc_writer;
	}
}
