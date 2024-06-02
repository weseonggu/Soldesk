package com.we.jan11oop.main;

import com.we.jan11oop.product.Mask;

public class Tester3 extends Mask {
	public void test() {
		Mask m = new Mask();
		m.a = 1;
		m.b = 2;
		m.c = 3;
		m.d = 4;// private라 오류
	}
}
