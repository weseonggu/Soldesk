
public class Repeat2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int dan = 1; dan < 10; dan++) {
			for (int i = 2; i < 10; i++) {
				System.out.printf("%dx%d=%d\t", i, dan, i * dan);
			}
			System.out.println();
		}

		System.out.println("----------------");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}

		System.out.println("----------------");
		for (int i = 5; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}

		System.out.println("----------------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("  ");
			}
			System.out.println("ㅋ");
		}

		System.out.println("----------------");
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.printf("%s", (j % 2 != 1) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		String s;
		System.out.println("----------------");
		for (int i = 1; i < 6; i++) {
			s=(i % 2 == 1) ? "ㅋ" : "ㅎ";
			for (int j = 0; j < 2*i-1; j++) {
				System.out.printf("%s", s);
			}
			System.out.println();
		}

	}

}
