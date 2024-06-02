import java.util.Scanner;

// 재귀함수 실전 사용

// 재귀함수는 계산용이 아님
// 원하는 형태의 값이 나올때까지 다시 함수를 실행이 필요할때 사용(입력 받는 상황에서 사용)
public class RecursiveFunction {
	public static int getOdd() {
		Scanner scan = new Scanner(System.in);
		System.out.print("홀수: ");
		int num = scan.nextInt();
		
		num = (num % 2 == 1) ? num : getOdd();
		// 재귀 함수로 홀수가 아닐때는 getOdd함수를 다시 실행
		
		scan.close();
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("입력한 숫자는 %d 입니다.\n", getOdd());
	}

}
