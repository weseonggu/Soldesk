import java.util.Random;
import java.util.Scanner;

public class Repeat3 {

	public Repeat3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 0;
		while (sum < 1000) {
			sum += i;
			i++;
		}
		System.out.println(i);
		System.out.println(sum);
		System.out.println("------------------------------");

		Random r = new Random();
		int b = 0;
		while (b != 7) {
			b = r.nextInt(10);// 0 ~ 9사이의 랜덤 숫자
			System.out.println(b);
		}
//		System.out.println("------------------------------");
//		Scanner scan =new Scanner(System.in);
//		System.out.print("뭐:");
//		String any=scan.next();
//		while(!(any.equals("ㅃㅇ"))) {
//			System.out.print("뭐:");
//			any=scan.next();
//		}

		System.out.println("------------------------------");

		int notOdd = r.nextInt(100) + 1;
		System.out.println(notOdd);
		while (notOdd % 2 != 0) {
			notOdd = r.nextInt(100) + 1;
			System.out.println(notOdd);
		}
		System.out.println("------------------------------");
		int notOdd1=0;
		do {
			notOdd1 = r.nextInt(100) + 1;
			System.out.println(notOdd1);
		}while (notOdd1 % 2 != 0);

	}

}
