import java.util.Scanner;

public class IfForMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("옵션: ");
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		scan.close();
		if (option >= 1 << 3) {// 8
			System.out.println("흡연실");
			option -= (1 << 3);
		}
		if (option >= 1 << 2) {// 4
			System.out.println("주차장");
			option -= (1 << 2);
		}
		if (option >= 1 << 1) {// 2
			System.out.println("와이파이");
			option -= (1 << 1);
		}
		if (option >= 1 << 0) {// 1
			System.out.println("24시간");
		}
	}

}
