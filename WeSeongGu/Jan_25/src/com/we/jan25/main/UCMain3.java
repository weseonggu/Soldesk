package com.we.jan25.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

public class UCMain3 {
	public static void main(String[] args) {
		Random r = new Random();
		HashSet<Integer> hs = new HashSet<>();
		while (true) {
			hs.add(r.nextInt(45)+1);
			if (hs.size()==7) {
				break;
			}
		}
		// 정렬 전 출력
		for (Integer integer : hs) {
			System.out.println(integer);
		}
		// set -> List
		ArrayList<Integer> al = new ArrayList<>(hs);
		// 오름 차순 정렬
		Comparator<Integer> c = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
		};
		al.sort(c);
		// 정렬 후 출력
		System.out.println("--------------");
		for (Integer integer : al) {
			System.out.println(integer);
		}
		
		
	}
}
