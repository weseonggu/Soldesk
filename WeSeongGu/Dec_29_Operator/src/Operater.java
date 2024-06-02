
//연산자 
import java.awt.Window.Type;
import java.util.Scanner;

public class Operater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		int x=scan.nextInt();
//		int y=scan.nextInt();
//		
//		
//		int a=x+y;
//		int b=x-y;
//		int c=x*y;
//		int d=x/y;
//		int e=x%y;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(c);
//		System.out.println(d);
//		System.out.println(e);
//		System.out.println("----------------------");
//		char s='z';
//		System.out.println((int)s);//붙여서 출력 String타입으로 변환됨
//		
//		double g=x/y;
//		System.out.println(g);// int int 계산 -> int , int  double int 계산 -> double
		// 산술 대입 연산자 -= += /= %= ++ --
//		x+=3;
//		System.out.println(x);
//		x++;
//		System.out.println(x);

		// shift 연산자 <<(자주 사용) >> <<<
		// 3 이진수: 11 수만큼 밀기 ex) 3<<2 -> 1100 -> 12
		// 목록에서 다중선택 때 사용하면 유용

		// 공부 방법
		// 1. 저게 뭔데 저 강사가 저기다 써놨나
		// 뭐 추가
		// 정보올림피아드
		System.out.print("구매한 물건 가격: ");
		int total = scan.nextInt();
		System.out.print("낸돈: ");
		int pay = scan.nextInt();
		int change = pay - total;
		System.out.println("거스름 돈: " + change);
		//오만원
		int m50000 = change / 50000;
		change %= 50000;
		//만원
		int m10000 = change / 10000;
		change %= 10000;
		//오천원
		int m5000 = change / 5000;
		change %= 5000;
		//천원
		int m1000 = change / 1000;
		change %= 1000;
		//오백원
		int m500 = change / 500;
		change %= 500;
		//백원
		int m100 = change / 100;
		change %= 100;
		//오십원
		int m50 = change / 50;
		change %= 50;
		//십원 
		int m10 = change / 10;
		change %= 10;
		System.out.printf("50000: %d \n10000: %d \n5000: %d \n1000: %d \n500: %d \n100: %d \n50: %d \n10: %d", m50000,
				m10000, m5000, m1000, m500, m100, m50, m10);
	}

}
