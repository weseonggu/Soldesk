package com.we.jan13.main;

import java.util.Scanner;

import com.we.jan13.calculator.Calculator;

public class EHMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("x: ");
		int x = sc.nextInt();
		System.out.print("y: ");
		int y = sc.nextInt();

		System.err.println("---------------------");

		int z = Calculator.divide(x, y);
		System.out.println(z);
		
		
		// throw로 예외를 main에서 처리함
		try {
			int z1 = Calculator.divide2(x, y);
			System.out.println(z1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("나누기 0은 없습니다.");
		}

	}
}
