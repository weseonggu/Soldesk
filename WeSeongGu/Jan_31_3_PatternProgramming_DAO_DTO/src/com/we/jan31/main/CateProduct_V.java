package com.we.jan31.main;

import java.util.ArrayList;
import java.util.Iterator;

public class CateProduct_V {
	public static void printInfo(ArrayList<CateCount> arr) {
		for (CateCount cateCount : arr) {
			System.out.println(cateCount.getCate_name());
			System.out.println(cateCount.getCate_count());
		}
	}
}
