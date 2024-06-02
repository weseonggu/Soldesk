package com.we.jan13.main;

//예외처리
import java.util.Scanner;

public class EHMain {
//error: 자바 문법에 안막게 써서, 
	// 기계어로 번역이 불가능한 상황,
	// 최종 산출물을 못내는경우

//warning :  정리안된 소스
	// 실행에는 문제는 없음
	// 최종 산출물 나옴

//exception : 정싱적인 프로그램
	// 뭔가 외부적인 요인에 의해 문제가 생김
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("x: ");
		int x = sc.nextInt();
		System.out.print("y: ");
		int y = sc.nextInt();

		System.err.println("---------------------");
		try {
			System.out.println(x / y);// 나누기 0은 없음 수학적으로
		} catch (ArithmeticException e) {// 나누기 0을 하면 ArithmeticException가 발생함
			// TODO: handle exception
			System.out.println("나누기0은 없음");
			System.out.println(e.toString());
		}
		try {
			int[] a = { 123, 123 };

			System.out.println(a[y]);
		} catch (ArrayIndexOutOfBoundsException e) {//외부적인 오류인헤 프로그램에 지장이 생기면 예외처리로 안내나 다른 처리를 하도록 해준다.
			// TODO: handle exception
			e.printStackTrace();// 개발자용 
		}catch (Exception e) {// Exception이 최상위 클래스이므로 이게 위에있으면 밑의 예외는 발생 x
			// TODO: handle exception
			e.printStackTrace();// 개발자용
		}
		finally {// 무조건 실행 됨 예외가 발생하던 말던
			System.out.println("끝");
		}

//		System.out.println(x/y);//나누기 0은 없음 수학적으로
//		System.out.println(x+y);
//		System.out.println(x-y);
//		System.out.println(x*y);
		sc.close();
	}
}
