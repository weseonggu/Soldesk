package com.we.jan20.main;

import java.util.Iterator;
//mainthread가 끝난다고 해서 subthread가 끝나는건 아님
public class UCMain2 {
	public static void main(String[] args) {

		Thread t = new Thread(new BlueLine());
		t.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("ㅋ");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
