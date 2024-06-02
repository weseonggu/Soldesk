import java.util.Scanner;

public class Array5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("구매한 물건 가격: ");
		int total = scan.nextInt();
		System.out.print("낸돈: ");
		int pay = scan.nextInt();
		int change = pay - total;
		System.out.println("거스름 돈: " + change);

		int m = 0;
		int a = 50000;
//		int[] paper = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
//		for (int p : paper) {
//			m = change / p;
//			change %= p;
//			System.out.printf("%d원 짜리 잔돈 %d개\n", p, m);
//		}
		for (int i = 1; i < 9; i++) {
			a /= (i == 1) ? 1 : (i % 2 == 0 ? 5 : 2);
			m = change / a;
			change %= a;
			System.out.printf("%d원 짜리 잔돈 %d개\n", a, m);
		}

	}

}
