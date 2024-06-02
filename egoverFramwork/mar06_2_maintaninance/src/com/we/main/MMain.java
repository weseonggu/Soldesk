package com.we.main;

public class MMain {

	public static void main(String[] args) {
		Veihicle v = new Subway();
		v.go();
		v =  new Bus();
		v.go();
	}

}
