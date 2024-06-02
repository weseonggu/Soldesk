package com.we.jstl;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class DataMaker {
	public static void make(HttpServletRequest request) {
		int x = new Random().nextInt(10);
		String[] ar = {"q","W","h","x"};
		
		request.setAttribute("ar", ar);
		request.setAttribute("xxx", x);
		
		ArrayList<Product> produts = new ArrayList<>();
		
		produts.add(new Product("과자", 1000));
		produts.add(new Product("사탕", 100));
		produts.add(new Product("라면", 1700));
		
		request.setAttribute("ps", produts);
	}
}
