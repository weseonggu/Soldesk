package com.we.jan31.main;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleScreen_v {
	private Scanner k = null;
	
	public ConsoleScreen_v() {
		k = new Scanner(System.in);
	}
	public ArrayList<Integer> inputNum() {
		ArrayList<Integer> arr = new ArrayList<>();
		System.out.print("숫자: ");
		int x = k.nextInt();
		arr.add(x);
		System.out.print("숫자: ");
		int y = k.nextInt();
		arr.add(y);
		return arr;
	}
	public void destory() {
		k.close();
	}

}
