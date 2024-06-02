
// 함수 재귀적호출
//		recursive
//		함수 속에서 자기자신을 불러서 반복이 생기게
//		이걸 수업안함
//		수업은 함 -> 실제 용도를 잘못...
//		함수 호출 : JUMP연산 - 시간이...

public class FMain2 {
	// 정수를 1개 넣으면
	// 1 + 2 + 3 + ... 그숫자 = ?
	// 를 구하는 함수
	public static int getHab(int x) {
		return (x == 1) ? 1 : (getHab(x - 1) + x);
	}

	// 정수 하나 넣으면
	// 팩토리얼 구하는 함수
	public static int getFactorial(int v) {
		return (v == 1) ? 1 : (getFactorial(v - 1) * v);
	}
	
	// 정수 하나 넣으면
	// 그 위치의 피보나치수열값 구하는 함수
	public static int getFibo(int p) {
		return (p < 3) ? 1 : (getFibo(p - 2) + getFibo(p - 1));
	}
	
	public static void main(String[] args) {
		int v = getFibo(50);
		System.out.println(v);
		
		int fact = getFactorial(6);
		System.out.println(fact);
		
		int hab = getHab(10);
		System.out.println(hab);
	}
}
