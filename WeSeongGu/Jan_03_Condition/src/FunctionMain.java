import java.util.Scanner;

public class FunctionMain {

	static Scanner scan = new Scanner(System.in);

	public static String getBiman(double o) {
		return o > 120 ? "비만" : "정상";
	}

	public static double getHeight() {
		System.out.print("키: ");
		double height = scan.nextDouble();
		return height > 3 ? height : getHeight();// 미터 단위 방지
	}

	public static String getName() {
		System.out.print("이름: ");
		String name = scan.next();
		return name;
	}

	public static double getOver(double w, double s) {
		return (w / s) * 100;
	}

	public static double getStandard(double h) {
		return (h - 100) * 0.9;
	}

	public static double getWeight() {
		System.out.print("몸무게: ");
		double weight = scan.nextDouble();
		return weight;
	}

	public static void printData(double s, double o, String v, String n) {
		System.out.printf("표준 체중: %.2fkg\n", s);
		System.out.printf("비만도: %.2f%%\n", o);
		System.out.printf("%s씨는 %s\n", n, v);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("---------------------");
		double standard = getStandard(height);
		double over = getOver(weight, standard);
		String value = getBiman(over);
		
		printData(standard, over, value, name);

		System.out.print("끝내려면 뭐라도 치시오");
		String dfsdf = scan.next();

	}

}
