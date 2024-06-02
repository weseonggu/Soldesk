// 함수(function)
//		관련있는 작업들 묶어놓고
//		필요할때마다 그 묶음을 사용
//		=> 소스정리, 느려짐

// 함수명 짓는 조건 == 변수명 짓는 조건
// 변수명 : 명사
// 함수명 : 동사

// 같은 공간내에서 이름은 달라야
// => 한 class내에서 함수명 달라야

// 함수 overloading
//		parameter부분(갯수/자료형)이 다르면 함수명 같아도 됨
//		함수 호출할때 구별이 되니
//		비슷한 기능일때 일부러 함수명을 같게 짓는 테크닉 : overloading
public class FMain {

// 1. 함수 정의
//								parameter, 인자
//								함수에 넣어주는거
//				  				main -> 함수
//				  returnType
//				  결과가 뭐
//	public static 자료형 함수명(자료형 변수명, ...) {
//		...
//		return 값;
//	}
	public static void yaDambae() {
		System.out.println("야 어머니한테 만원받아서");
		System.out.println("슈퍼 가서");
		System.out.println("한라산 한 갑 달라고 하고");
		System.out.println("너 과자 하나 사먹고");
		System.out.println("한라산 가져와");
	}

	// 정수를 하나 넣으면 그게 출력되는 함수
	public static void printNumber(int n) {
		System.out.println(n);
		System.out.println("-----");
	}

	// 정수를 2개 넣으면 그 합을 출력하는 함수
	public static void printHab(int q, int w) {
		int e = q + w;
		System.out.println(e);
	}

	// 정수를 3개 넣으면 그 합을 출력하는 함수
	public static void printHab(int q, int w, int e) {
		System.out.println(q + w + e);
	}
	
	// 정수 1개 넣으면 홀/짝 출력하는 함수
	public static void printOE(int q) {
		System.out.println((q % 2 == 1) ? "홀" : "짝");
	} 
	
	// 정수 2개 넣으면 평균값을 구해주는 함수
	public static double getAvg(int a, int b) {
		double c = (a + b) / 2.0;
		return c; // 결과를 호출한쪽으로 돌려주고 함수끝
	}
	
	// 초단위 넣으면 밀리초단위로 바꿔주는 함수
	public static int convertMilliSec(int sec) {
		return sec * 1000;
	}
	
	// 정수 2개 넣으면 더 큰 수 구해주는 함수
	public static int getBigger(int q, int w) {
		return (q > w) ? q : w;
	}
	
	// main함수 : 자동실행
	public static void main(String[] args) throws InterruptedException {
		int a = getBigger(5, 3);
		// 2. 함수 호출
		// 함수명(값, 값, ...);
		int s = convertMilliSec(a);
		Thread.sleep(s);
		
		double dd = getAvg(10, 20);
		System.out.println(dd);
		
		printOE(5);
		
		printHab(100, 3, 2);
		printHab(59, 23, 1);

		printHab(6, 234);
		printHab(54, 1);

		printNumber(10);
		printNumber(30);

		yaDambae();
		yaDambae();
		yaDambae();
	}
}
