package com.we.jan25.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

// map collection
// 순서라는 개념이 없음 
// 기준 - 값으로 찾음
public class UCMain4 {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("사과", 1000);
		hm.put("사과", 2000);
		hm.put("귤", 500);
		
		System.out.println(hm.get("사과"));
		System.out.println("---------------------------");
		
		Set<String> s = hm.keySet();
		ArrayList<String> al = new ArrayList<>(s);
		
		for (String string : al) {
			System.out.println(string);
			System.out.println(hm.get(string));
		}
	}
}
