package com.we.jan20.main;
// critical section 설정
// 임계영역 설정
// 여러 쓰레드가 뭐하나를 공유하는 상황
// 한번에 한 쓰레드만 접근 가능하도록 작성
public class Human {
	private String brain;
	
	
	//synchronized메소드:
	// 스레드가 몇개가 돌고 있든지 
	// 그메소드가 끄날때까지 다른 synchronized메소드가 실행 불가
	private synchronized void sayName() {
		for (int i = 0; i < 10; i++) {
			brain ="위성구";
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("이름: "+brain);
		}
	}
	
	private synchronized void sayHobby() {
		for (int i = 0; i < 10; i++) {
			brain ="드라마보기";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("취미: "+brain);
		}
	}
	
	// 이름 취미 동시에 생각 -> 취미: 위성구 이름: 드라마보기 이런 문제 발생
	// main sub thread가 brain을 공유함
	// 다른 스레드가 중간에 들어와서 데이터를 바꿔버림
	public void introduce() {
		Thread t = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				sayName();
			}
		};
		t.start();
		sayHobby();
	}
}
