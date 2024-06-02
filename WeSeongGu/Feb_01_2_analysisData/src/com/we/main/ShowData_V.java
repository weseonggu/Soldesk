package com.we.main;

import java.util.ArrayList;

public class ShowData_V {
	public static void showdata(ArrayList<AvgDust> arr) {
		for (AvgDust avgDust : arr) {
			System.out.print(avgDust.getGu());
			System.out.println(avgDust.getValue());
			System.out.println("------------------");
		}
	}
}
