package com.we.jan13.human;

import com.we.jan13.hero.Hero;

public class Human {
	private String name;
	private Hero hero;
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void pick (Hero h) {
		this.hero = h;
	}
	public void help() {
		hero.attack();
	}
	
}
