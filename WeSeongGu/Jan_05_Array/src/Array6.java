import java.util.Scanner;

public class Array6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("옵션: ");
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		scan.close();
		String[] service = { "24시간", "와이파이", "주차장", "흡연실" };
		for (int i = service.length - 1; i >= 0; i--) {
			if (option >= 1 << i) {
				System.out.println(service[i]);
				option -= 1 << i;
			}
		}
	}
}
