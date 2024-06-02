package com.we.janopp.human;
// 인터페이스 : 다중상속의 마이너 버전, 객체 생성x
// 		맴버 변수 x, 상수(final)은 가능
// 		메소드 x
//      추상 메소드 o

public interface Human {
	public static final String SLEEP ="잠"; 
	
//	public void goMart() {
//		System.out.println("마트가기");
//	}
	
	public abstract void eat();

}
