import java.util.Scanner;

// 비만도 검사 
public class IfForMain3 {
	static Scanner scan = new Scanner(System.in);

	public static double getHeight() {
		System.out.print("키(cm): ");
		double height = scan.nextDouble();
		return height > 3 ? height/100 : getHeight();// 미터 단위 방지
	}

	public static String getName() {
		System.out.print("이름: ");
		String name = scan.next();
		return name;
	}

	public static double getWeight() {
		System.out.print("몸무게(kg): ");
		double weight = scan.nextDouble();
		return weight;
	}

	public static double getBMI(double w, double h) {
		return w / (h * h);
	}

	public static String level(double b) {
		String re;
		if (b >= 35) {
			re = "고도비만";
		} else if (b >= 30) {
			re = "중도 비만";
		} else if (b >= 25) {
			re = "경도비만";
		} else if (b >= 23) {
			re = "과체중";
		} else if (b >= 18.5) {
			re = "정상";
		} else {
			re = "저체중";
		}
		return re;
	}

	public static void printData(String v, String n) {
		System.out.printf("%s씨는 %s\n", n, v);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("---------------------");
		double bmi = getBMI(weight, height);
		String result = level(bmi);

		printData(result, name);
	}

}
