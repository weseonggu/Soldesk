package com.we.main;

import java.util.Scanner;

public class MarketPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매 금액: ");
		int price = sc.nextInt();
		
		double perpoint = price*0.0075;
		int point = (int)Math.round(perpoint);
		System.out.printf("적립포인트: %d\n",point);
		//System.out.printf("포인트: %.0f원\n",point);
		
		System.out.print("뭐라도 입력: ");
		sc.next();
		sc.close();
	}

}

