import java.util.Scanner;

public class Operation {
	public static void getBiman() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("나이: ");
		int age = scan.nextInt();
		System.out.print("키: ");
		double height = scan.nextDouble();
		System.out.print("몸무게: ");
		double weight = scan.nextDouble();
		double standard = (double) (height - 100) / 100 * 90;
		double over = (weight / standard) * 100;
		
		String value = over > 120 ? "비만" : "정상";
		
		System.out.printf("표준 체중: %.2fkg\n", standard);
		System.out.printf("비만도: %.2f%%\n", over);
		System.out.printf("%s씨는 %s\n", name, value);
		
		System.out.println("끝내려면 뭐라도 치시오");
		String dfsdf = scan.next();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getBiman();


//		System.out.println(age + "살, " + height + "cm");
//
//		boolean a = height >= 150;
//		System.out.println("150이상?: " + a);
//
//		boolean b = age >= 80 && height >= 100;// 논리 결합연산자 &&중간 스킵이가능 &끝까지 계산
//		// &&일경우에는 앞에false가 나올 가능성이 높은걸 먼저 넣어놓으면 중간 스킵으로 속도가 향상 됨
//		System.out.println("and: " + b);
//		boolean c = height >= 100 || age >= 80;// 논리 결합연산자 || 중간 스킵이가능 |끝까지 계산
//		// ||일경우 앞에 true가 나올 가능성이 높은걸 먼저 넣으면 중간 스킵으로 속도 향상됨
//		System.out.println("or: " + c);
//
//		boolean d = age >= 20 ^ height >= 180;
//		System.out.println("xor: " + d);
//
//		boolean e = !d;// not
//		System.out.println("not xor: " + e);
//
//		boolean f = age < 20 && age > 10;
//		System.out.println("10<age<20: " + f);
//
//		boolean g = height > 150;
//		System.out.println("120> 150>: " + g);
//
//		String say = age > 20 ? "안녕하세요" : "나가";// 삼항연산자 사용법: 조건식 ? 값(참) : 값(거짓);
//		System.out.println(say);


	}

}
