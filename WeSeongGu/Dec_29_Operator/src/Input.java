import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

//		System.out.print("식당 이름: ");
//		String name = scan.next();
//		System.out.print("식당 주소: ");
//		String address = scan.next();
//		System.out.print("식당 테이블: ");
//		int table = scan.nextInt();
//		System.out.print("식당 별점: ");
//		double score = scan.nextDouble();
//		System.out.print("식당 예약?: ");
//		boolean book = scan.nextBoolean();
//		
//		System.out.printf("식당 이름: %s 주소: %s 테이블 수: %d\n", name, address, table);
//		System.out.printf("별점: %.1f 예약 가?: %b\n",score, book);

		System.out.println("------------------------------");
		System.out.print("x: ");
		int numX = scan.nextInt();
		System.out.print("y: ");
		int numY = scan.nextInt();

		System.out.printf("x는 %d y는 %d", numX, numY);

	}

}