import java.util.Iterator;

public class Repeat1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;// 변수선언 후 초기화 없으면 사용못함
		for (int i = 1; i < 11; i++) {// 반복문안에서 변수 만들기 자제하기 메모리 차지 많이함
			sum += i;
		}
		System.out.println(sum);

		int fac = 1;
		for (int i = 1; i < 8; i++) {
			fac *= i;
		}
		System.out.println("fac " + fac);

		int a = 0;
		for (int i = 1; i < 10; i += 2) {
			a += i;
		}
		System.out.println("a " + a);

		int swps = 0;
		for (int i = 1; i < 11; i++) {

			if (i % 2 == 1) {
				swps += i;
			} else {
				swps -= i;
			}
		}
		System.out.println("swps " + swps);
	}

}
// f11 디버그하는것 ctrl + f11이랑 다름
// f6 한 줄씩 실행
//이전 모드 오른쪽 상단 