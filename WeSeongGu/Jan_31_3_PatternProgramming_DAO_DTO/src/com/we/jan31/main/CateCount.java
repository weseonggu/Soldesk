package com.we.jan31.main;

public class CateCount {
	private String cate_name;
	private int cate_count;
	public CateCount() {
		// TODO Auto-generated constructor stub
	}
	public CateCount(String cate_name, int cate_count) {
		super();
		this.cate_name = cate_name;
		this.cate_count = cate_count;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public int getCate_count() {
		return cate_count;
	}
	public void setCate_count(int cate_count) {
		this.cate_count = cate_count;
	}
	
	
}
