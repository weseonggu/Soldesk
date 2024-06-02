package com.we.kakaoBookSearch;

import org.json.simple.JSONArray;

public class BookInfo {
	private JSONArray authors;
	private String price;
	private String publisher;
	private String title;
	private String addr;
	private String img;
	public BookInfo(Object authors, long price, Object publisher, Object title, Object addr, Object img) {
		super();
		this.authors = (JSONArray)authors ;
		this.price = Long.toString(price);
		this.publisher = (String)publisher;
		this.title = (String)title;
		this.addr = (String)addr;
		this.img = (String)img;
	}
	public JSONArray getAuthors() {
		return authors;
	}
	public void setAuthors(JSONArray authors) {
		this.authors = authors;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
}
