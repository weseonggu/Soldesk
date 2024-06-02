import java.util.Scanner;

public class Operater2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		System.out.print("바퀴 둘레: ");
		int wheel = scan.nextInt();
		System.out.print("앞기어 톱니수: ");
		int front = scan.nextInt();
		System.out.print("뒷기어 톱니수: ");
		int back = scan.nextInt();
		System.out.print("패달 돌린 횟수: ");
		double count = scan.nextDouble();
		
		
		double go = (double) front / back;  
		System.out.println("이동거리: " + wheel * go * count + "cm");

	}

}
