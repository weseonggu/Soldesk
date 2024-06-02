package com.we.jan13.star;

import com.we.jan13.human.Human;

public class Star {
	private String name;
	private int size;
	private boolean visible;
	private Human human;
	
	public Star() {
		// TODO Auto-generated constructor stub
	}

	public Star(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public void add(Human h) {
		this.human=h;
		System.out.println(name+"에");
		System.out.println(human.getName()+"이 등록");
	}
	
	
	
}
