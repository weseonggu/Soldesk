
public class PC {
	String cpu;
	int ram;
	int hdd;
	static String maker="삼성";
	
	public void printInfo() {
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
		System.out.println(maker);
	}
	public static void printMaker() {
		System.out.println(maker);
	}
}
