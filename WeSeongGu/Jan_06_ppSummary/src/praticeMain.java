import java.util.Arrays;
import java.util.Random;

//로또번호 자동생성기
public class praticeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int count = 0;
		int[] num = { 0, 0, 0, 0, 0, 0, 0 };
		int ball;
		loop: while (true) {
			ball = r.nextInt(45) + 1;
			for (int i : num) {
				if (i == ball) {
					System.out.println("다시");
					continue loop;
				}
			}
			num[count] = ball;
			count++;
			if (count == 7)
				break;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
