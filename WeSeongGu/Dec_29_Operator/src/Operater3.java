import java.util.Scanner;

//논리 연산자 
public class Operater3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("이름: ");
		String name=scan.next();
		
		System.out.print("키: ");
		int height = scan.nextInt();
		
		System.out.print("나이: ");
		int age = scan.nextInt();

		boolean ox = height >= 120;
		boolean ageOX = age < 10;
		boolean age5 = age == 5;
		boolean ageodd = age % 2 == 1;
		boolean nameOX= name.equals("홍길동");// heap 영역은 equals 사용
		System.out.printf("키는: %dcm 나이: %d살\n", height, age);
		System.out.println("탑승 가능?: " + ox);
		System.out.println("탑승 가능? 나이 10살 미만: " + ageOX);
		System.out.println("탑승 가능? 5살: " + age5);
		System.out.println("탑승 가능? 홀수: " + ageodd);
		System.out.println("탑승 가능? 홍길동: " + nameOX);

	}

}
