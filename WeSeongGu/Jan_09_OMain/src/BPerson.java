import java.util.Random;
import java.util.Scanner;

public class BPerson {
	Random r = new Random();
	Scanner scan = new Scanner(System.in);

	public int rsp() {
		System.out.print("뭐: ");
		int a = scan.nextInt();
		return a > 3 ? rsp() : a;
	}
}
// 자바언어의 특징 -> 남이 작업한거 잘 쓰기