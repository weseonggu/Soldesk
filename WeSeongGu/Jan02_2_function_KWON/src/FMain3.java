import java.util.Scanner;

// recursive
//		반복적으로 함수를 호출하면 느림 -> 계산용x
//		원하는 값 나올때까지 - o
//			입력받는 상황 - 프로그램이 멈춰있음
//							속도 따질 상황이 아님
public class FMain3 {
	public static int getOdd() {
		Scanner k = new Scanner(System.in);
		System.out.print("홀수 : ");
		int a = k.nextInt();
		return (a % 2 == 1) ? a : getOdd();
	}
	public static void main(String[] args) {
		int a = getOdd();
		System.out.println("-----");
		System.out.printf("그거 %d요\n", a);
	}
}
