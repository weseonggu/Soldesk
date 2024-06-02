package com.we.jan31.main;

import java.util.ArrayList;

public class HomeController3 {
	public static void main(String[] args) {
		ArrayList<CateCount> arr = null;
		arr = SelectResult.select_cate();
		CateProduct_V.printInfo(arr);
	}

}
