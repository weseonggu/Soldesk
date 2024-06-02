package com.we.jan12_01.main;

import com.we.jan12_01.market.Book;
import com.we.jan12_01.market.Food;
import com.we.jan12_01.market.Market;

public class OMain2 {
	//다형성 사용 예  객체 배열
	public static void main(String[] args) {
		Market[] product = new Market[2];
		product[0] =new Food("아이스크림", 1500, "내일");
		product[1] = new Book("이것이 자바다", 250000, "홍길스");
		
//		product[0].printInfo();
		System.out.println(product[0].getPrice());
	}
}
