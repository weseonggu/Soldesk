
import java.util.Scanner;

public class Guest {
	String name;
	double height;
	double weight;
	Scanner scan = new Scanner(System.in);
	double bmi;
	String statues;
	public String tellName() {
		return scan.next();
	}

	public double tellHW() {
		return scan.nextDouble();
	}
}
