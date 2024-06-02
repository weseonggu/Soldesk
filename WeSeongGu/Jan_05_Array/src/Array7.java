import java.util.Random;
import java.util.Scanner;

public class Array7 {
	static private Scanner scan = new Scanner(System.in);
	static private Random r = new Random();

	public static int putWhat(int pc) {
		System.out.println("1. 가위");
		System.out.println("2. 바위");
		System.out.println("3. 보");
		String[] rsp = { "가위", "바위", "보" };
		System.out.println("pc: " + rsp[pc - 1]);
		System.out.print("뭐: ");
		int what = scan.nextInt();
		if (what >= 1 && what <= 3) {
			System.out.println("pc: " + rsp[pc - 1]);
			System.out.printf("나: %s\n", rsp[what - 1]);
			return what;
		} else {
			System.out.println("잘못된 수 입력 다시입력");
			return putWhat(pc);
		}
	}

	public static int judge(int what, int pc) {
		int win = what - pc;
		int  who;
		if (win == -1 || win == 2) {
			System.out.printf("패\n" );
			who=1;
		} else if (win == 0) {
			System.out.println("무승부\n");
			who=2;
		} else {
			System.out.println("승\n");
			who=3;
		}
		return who;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int wincount = 0;
		int win;
		int what;
		int pc;
		while (true) {
			pc = r.nextInt(3) + 1;
			what = putWhat(pc);
			win = judge(what, pc);
			if(win==1) {
				System.out.printf("%d연승\n", wincount);
				break;
			}else if(win==3) {
				wincount++;
			}else {
				
			}
		}

	}

}
