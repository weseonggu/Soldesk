package com.we.jan12_01.main;

import com.we.jan12_01.market.Book;
import com.we.jan12_01.market.Food;
import com.we.jan12_01.market.Market;

public class OMain {
//다형성 polymorphism
	// 상위 타입 면수에 하위 타입 담는게 가능
	// 동적 로딩: 정말로 살행될때 최종적으로 자료형이 결정  - 자바 
	// 정적 로딩: 변수를 만들때 최종적으로 자료형 결정  -> 다형성 불가능
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b = new Book("이것이 자바다", 30000, "홍길동");
		b.printInfo();
		System.out.println("-----------------------------------------------------");
		Food f = new Food("요구르트", 1000, "내일");
		f.printInfo();
		System.out.println("-----------------------------------------------------");
		//다형성
		//상위 클래스 선언(타입 변수명) 하위 클래스 생성(new 하위 클래스)은 가능
		Food v1 = new Food();
		//Food v2= new Book(); // x
		//Food v3 =new Market(); // x
		Market v4 =new Food();// v4의 정체: Food
		v4.printInfo();
		
	}

}
