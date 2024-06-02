package com.we.notice;

import java.util.Date;

public class Notice {
	private int no;
	private String writer;
	private String title;
	private String txt;
	private Date date;

	public Notice() {
		// TODO Auto-generated constructor stub
	}
	
	public Notice(String writer, String title, String txt, Date date) {
		super();
		this.writer = writer;
		this.title = title;
		this.txt = txt;
		this.date = date;
	}

	public Notice(int no, String writer, String title, String txt, Date date) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.txt = txt;
		this.date = date;
	}
	

	public Notice(int no, String writer, String title, Date date) {
		super();
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.date = date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
