package com.we.jan13.calculator;

public class Calculator {
	// 1. 직접 처리하기
	public static int divide(int x, int y) {
		try {
			int z = x / y;
			return z;// return보다 finally가 먼저 실핼 된후 return이 작동됨
		} catch (Exception e) {
			System.out.println("나누기 0은 없다.");
			return 0;
		} finally {
			System.out.println("끝");
		}

	}

	// 2. 미루기
	// 수행하다가 문제가 발생하면 함수를 호출한 쪽에서 예외처리를 하도록 하게 한다.
	// 더많이 사용
	// 이유: 예외처리를 상황마다 다르게 해야하는데 여기서 예외를 정의 해버리면
	// 다른 예외 처리를 할 수 없기 때문에 예외를 호출한곳에서 처리 하도록 하는것을 선호한다.
	// Jan_13_thisidjava 프로젝트를 참고 하시오
	public static int divide2(int x, int y) throws ArithmeticException {
		int z = x / y;
		return z;// return보다 finally가 먼저 실핼 된후 return이 작동됨

	}
}
// 