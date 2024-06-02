package com.we.janopp.main;

import com.we.janopp.gamechar.GameChar;
import com.we.janopp.gamechar.Hark;
import com.we.janopp.gamechar.Irman;
import com.we.janopp.human.Human;

public class OMain {
	public static void main(String[] args) {
		Irman i = new Irman("아이언맨", 30, "자비스");
		i.printInfo();
		i.attack();
		i.eat();
		i.flyer();
		System.out.println("---------------------------");
		Hark h = new Hark("헐크", 25, 99);
		h.printInfo();
		h.attack();
		// anonymous inner class : 익명 내부 클래스
		GameChar g = new GameChar() {
			//자바는 객체를 만드면서 클래스흫 만드는게 가능함
			// GameChar의 하위 클래스
			
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("방패 던지기");
			}
		};
		
		System.out.println("---------------------------");
		Human h1 = new Human() {
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				System.out.println("냠");
			}
		};	
		h1.eat();
	}
}
