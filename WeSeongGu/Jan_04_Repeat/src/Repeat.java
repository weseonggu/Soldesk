import java.util.Random;
import java.util.Scanner;

public class Repeat {
	static private Scanner scan = new Scanner(System.in);
	static private Random r = new Random();

	public static int thinkRandom() {
		return r.nextInt(10000) + 1;
	}

	public static int tell() {
		System.out.print("뭐: ");
		int any = scan.nextInt();
		return any < 1 || any > 10000 ? tell() : any;
	}

	public static boolean judge(int any, int num) {
		if (num == any) {
			return true;
		} else if (num > any) {
			System.out.println("up");
			return false;
		} else {
			System.out.println("down");
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = thinkRandom();
		int any = 0;
		System.out.println(num);
		for (int count = 1; true; count++) { // for (int count=1;true;count++) while과 같은 동작을 함
			any = tell();
			if (judge(any, num)) {
				System.out.printf("%d턴만에 정답", count);
				break;
			}
		}
	}

}
