package com.we.jan13.main;

import com.we.jan13.hero.Ironman;
import com.we.jan13.human.Human;
import com.we.jan13.star.Star;

public class OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Star s= new Star("지구");
		Human h =new Human("홍길동");
		Ironman i = new Ironman();
		h.pick(i);
		h.help();
		s.add(h);
		s.setSize(500);
		s.setVisible(true);
	}

}
