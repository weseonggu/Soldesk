package com.we.jan13.main;

import java.util.Scanner;

import com.we.jan13.calculator.Calculator;

public class TIJMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("총금액: ");
		int all = sc.nextInt();
		System.out.print("물것 갯수: ");
		int count = sc.nextInt();
		
		// 1. 정해진 예외처리
		int result = Calculator.divide(all, count);
		System.out.println(result);
		
		// 2. 예외처리를 호출한데에서 하면 상황에 맞는 에외처리가능
		try {
			int result2 = Calculator.divide2(all, count);
			System.out.println(result2);
						
		} catch (Exception e) {
			System.out.println("틀린 수식입니다.");
		}
	}
}
