package com.we.janopp.gamechar;

import com.we.janopp.flyer.Flyer;
import com.we.janopp.human.Human;

// 추상 메소드를 재정의 해야함 아니면 오류 뜸
// 다중 상속: 여러 클래스를 상속 받을 수 있나? -> 자바는 불가능 정식으로 지원 하지 않음
// 마이너 버전은 가능 -> 인터페이스
public class Irman extends GameChar implements Human, Flyer{

	private String ai;

	public Irman() {
	}

	public Irman(String name, int age, String ai) {
		super(name, age);
		this.ai = ai;
	}

	public String getAi() {
		return ai;
	}

	public void setAi(String ai) {
		this.ai = ai;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(ai);
	}

	@Override
	public void attack() {
		System.out.println("빔 발사");
	}
	
	@Override
	public void eat() {
		System.out.println("냠");
	}
	@Override
	public void flyer() {
		// TODO Auto-generated method stub
		System.out.println("비행 시작");
	}

}
