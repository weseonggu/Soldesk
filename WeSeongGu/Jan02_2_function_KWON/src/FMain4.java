import java.util.Scanner;

public class FMain4 {

	public static double calcBimando(double w, double sw) {
		return (w / sw) * 100;
	}

	public static double calcStdWeight(double h) {
		return (h - 100) * 0.9;
	}
	
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키 : ");
		double height = k.nextDouble();
		return (height < 3) ? getHeight() : height;
	}
	
	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("이름 : ");
		return k.next();
	}
	
	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게 : ");
		return k.nextDouble();
	}
	
	public static String judge(double b) {
		return (b > 120) ? "비만" : "정상";
	}
	
	public static void printResult(double sw, double b, String n, String r) {
		System.out.printf("표준체중 : %.1fkg\n", sw);
		System.out.printf("비만도 : %.1f%%\n", b);
		System.out.printf("%s씨는 %s\n", n, r);
	}
	
	public static void main(String[] args) {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("-----");
		double stdWeight = calcStdWeight(height);
		double bimando = calcBimando(weight, stdWeight);
		String result = judge(bimando);
		printResult(stdWeight, bimando, name, result);
	}
}
