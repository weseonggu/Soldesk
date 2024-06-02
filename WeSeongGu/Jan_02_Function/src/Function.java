//함수
// 함수명 정하는 방법: 동사+명사 순으로 작성 : ex) getAvg printData 등등
//소스 정리를 위해서 사용
public class Function {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int data1 = getBig(3, 5);
		int time = convertMillisec(data1);
//		Thread.sleep(time);
		smoke_oder();// 함수호출
		num(36);
		printSum(2, 5);
		printSum(8, 7, 21);
		oddEven(8);
		double data = getAvg(7, 6);
		System.out.println(data);
		int num = getSum(8);
		System.out.println(num);
		int fact = getFac(4);
		System.out.println(fact);
		int pivo = getpivo(50);
		System.out.println(pivo);
	}

	public static void num(int n) {// 매개변수있는 함수
		System.out.println("숫자: " + n);
		System.out.println("----------------");
	}

	public static void oddEven(int a) {
		System.out.println(a % 2 == 1 ? "홀수" : "짝수");
	}

	public static void printSum(int a, int b) {
		System.out.println("합: " + (a + b));
	}

	// 함수 오버로딩: 매개변수의 개수또는 자료형이 다르면 오버 로딩으로 사용가능
	public static void printSum(int a, int b, int c) {
		System.out.println("합: " + (a + b + c));
	}

	public static void smoke_oder() {
		System.out.println("야 어머니한테 만원 받아서 ");
		System.out.println("슈퍼 가서");
		System.out.println("한라산을 사와라");
		System.out.println("남은 돈은 과자 사먹고 ");
	}

	public static double getAvg(int a, int b) {// 반환값이 있는 함수
		return (a + b) / 2.0;
	}

	public static int convertMillisec(int sec) {
		return sec * 1000;
	}

	public static int getBig(int a, int b) {
		return a > b ? a : b;
	}

	public static int getSum(int a) {// 공식 사용
		return a * (a + 1) / 2;
	}

	public static int getFac(int x) {// 함수 내부에서 다시 호출 함수를 재귀적으로 사용 (재귀 함수)
		int fact = (x == 1) ? 1 : (getFac(x - 1) * x);
		return fact;
	}
	//재귀함수사용하면 느려짐 점프연산이 걸림(시간 많이 잡아 먹음) 

	public static int getpivo(int l) {// 피보나치
		int num = (l < 3) ? 1 : getpivo(l - 1) + getpivo(l - 2);
		return num;

	}
}