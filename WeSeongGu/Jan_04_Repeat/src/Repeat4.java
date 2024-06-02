import java.util.Random;
import java.util.Scanner;

public class Repeat4 {

	public Repeat4() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random r = new Random();

		for (int i = 1; i < 11; i++) {
			System.out.println(i);
			if (i == 3) {
				continue;
			}
		}
		System.out.println("--------------------------");
		while (true) {
			int a = r.nextInt(10);
			System.out.println(a);
			if (a == 7)
				break;
		}
//		System.out.println("--------------------------");
//		loop: while (true) {// 루프의 이름을 지정
//			System.out.print("뭐: ");
//			String any = scan.next();
//			switch (any) {
//			case "ㅃㅇ":
//				break loop; // 지정 루프 종료
//			}
//		}
		System.out.println("--------------------------");
		a : for (int i = 0; i < 3; i++) {
			b :for (int j = 0; j < 3; j++) {
				if(j==2)
					break b;
				if(i==1)
					break a;
				System.out.printf("%d %d\n", i, j);
			}
		}
	}
}
