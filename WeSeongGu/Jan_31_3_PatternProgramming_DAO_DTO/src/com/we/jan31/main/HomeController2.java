package com.we.jan31.main;

import java.util.ArrayList;

public class HomeController2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Product> arr = null;

		SelectResult sr = new SelectResult();
		ShowSelect ss = new ShowSelect();

		arr = sr.result_select();
		for (Product product : arr) {
			ss.printProduct(product.getName(), product.getPrice());
		}

	}

}
