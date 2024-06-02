package com.we.jan11oop.main;

import com.we.jan11oop.product.Mask;

public class Tester {
	public void test() {
		Mask m = new Mask();
		m.a=1;
		m.b=2;// 상속 이없음 오류
		m.c=3;// 다른 패키지라 오류
		m.d=4;// private라 오류
	}
}
