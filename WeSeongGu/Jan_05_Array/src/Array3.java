import java.util.Scanner;

public class Array3 {
	public static void printAdd2(int a, int b) {
		System.out.println(a+b);
	}
	public static void printAdd3(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	
	public static void printGob(int... a) {// 여러개를 넣는게 가능
		int t=1;
		for (int i : a) {
			t*=i;
		}
		System.out.println(t);
	}
	public static void main(String[] args) {
		printAdd2(0, 0);
		printAdd3(0, 0, 0);
		printGob(1,2,3,4);
	}
}
