
public class Referee {
	int ap;
	int bp;
	int lose;
	int count;
	String[] hand = { "가위", "바위", "보" };

	public void start(APerson a, BPerson b) {
		while (true) {
			what(a, b);
			judge();
			if (lose == 3) {
				tell();
				break;
			}
		}
	}
	/**
	 * 메소드 사용 방법 설명
	 * @param a 어떠한 매개변수인지 설명
	 * @param b 어떠한 매개변수인지 설명
	 */
	public void what(APerson a, BPerson b) {
		System.out.println("안내면 진거 가위 바위 보");
		ap = a.rsp();
		bp = b.rsp();
	}

	public void judge() {
		int win = ap - bp;
		System.out.println("a: " + hand[ap - 1]);
		System.out.println("b: " + hand[bp - 1]);

		if (win == -1 || win == 2) {
			System.out.printf("a패  b승\n");
			count++;
			lose = 1;

		} else if (win == 0) {
			System.out.println("무승부\n");
			lose = 2;
		} else {
			System.out.println("a승  b패\n");
			lose = 3;
		}
	}

	public void tell() {
		System.out.println("b몇연승?: " + count);
	}

}
