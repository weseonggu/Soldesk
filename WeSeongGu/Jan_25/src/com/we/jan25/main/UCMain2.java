package com.we.jan25.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
// set collection
// 중복 제거

public class UCMain2 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<>();
		hs.add(123);
		hs.add(53);
		hs.add(456);
		hs.add(41);
		hs.add(213);
		hs.add(549);
		System.out.println(hs.size());
		//set -> [] or set -> List로 변경해서 사용
		// collection 간의 변환 : 생성자
		ArrayList<Integer> al = new ArrayList<>(hs);//set -> List
		
		
		ArrayList<String> al2 = new ArrayList<>();
		al2.add("a");
		al2.add("a");
		al2.add("12");
		al2.add("12");
		al2.add("gg");
		for (String string : al2) {
			System.out.println(string);
		}
		
		HashSet<String>hs2 = new HashSet<>(al2);
		
		al2 = new ArrayList<>(hs2);
		for (String string : al2) {
			System.out.println(string);
		}
		System.out.println("------------------");
		Weather w = new Weather("dfdf", "dfdf", "dfdfdg", "dfsdfsd");
		HashSet< Weather> weathers = new HashSet<>();
		weathers.add(w);
		weathers.add(w);
		weathers.add(w);
		weathers.add(w);
		weathers.add(new Weather("몰라", "3", "맑음", "-7"));
		weathers.add(new Weather("몰라", "3", "맑음", "-5"));
		weathers.add(new Weather("몰라", "3", "맑음", "-5"));
		weathers.add(new Weather("몰라", "3", "맑음", "-5"));
		// 중복 제거 안됨
		// 중복 제거 -> 똑같은 객체를 제거 해주는 거임 즉 같은 데이터를 가진 다른 데이터는 제거가 안됨
		// 같은 객체를 add한거는 제거가 됨 하지만 new 를 통해서 추가한 객체는 객체의 데이터가  같아도 중복 처리가 안됨
		System.out.println(weathers.size());
	}
}
