import java.util.Scanner;

//조건문
public class IfForMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.print("중간 고사: ");
		int middle = scan.nextInt();
		System.out.print("기말 고사: ");
		int last = scan.nextInt();

		scan.close();
		System.out.println("-----------------");

		double avg = (middle + last) / 2.0;
		System.out.printf("평균 점수: %.1f점\n", avg);

		if (avg >= 90) {
			System.out.println("수");
		} else if (avg >= 80) {
			System.out.println("우");
		} else if (avg >= 70) {
			System.out.println("미");
		} else if (avg >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}

	}

}
