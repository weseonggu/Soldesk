package com.we.jan20.main;

public class BlueLine implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("ㅎ");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
