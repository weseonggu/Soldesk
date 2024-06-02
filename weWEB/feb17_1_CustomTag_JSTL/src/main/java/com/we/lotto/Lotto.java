package com.we.lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Lotto {
	private static final Lotto L = new Lotto();
	private Random r;
	private Lotto() {
		r = new Random();
	}
	
	public static Lotto getL() {
		return L;
	}
	
	public void getNum(HttpServletRequest req) {
		HashSet<Integer> set =  new HashSet<>();
		while(true) {
			set.add(r.nextInt(45)+1);
			if(set.size() == 6) {
				break;
			}
		}
		ArrayList<Integer> arr = new ArrayList<>(set);
		arr.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		ArrayList<String> arr1 =new ArrayList<>();
		for (Integer integer : arr) {
			arr1.add(String.format("img/lotto/ball_%d.png", integer));
		}
		req.setAttribute("lottoNum", arr1);
	}
}
