package com.we.jan20.main;
// Collection

// 만들때 사이즈 고정x
// 자료형 섞기 가능
// 추가 가능

import java.util.ArrayList;
import java.util.Comparator;

// 계열
// List계열: 배열의 상위 호환 (많이 사용)
// Set계열:  중복데이터 자동제거, 순서x
// Map계열: 키 - 값으로 데이터 저장, 순서x
public class UCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList al = new ArrayList();
//		al.add(13);
//		al.add("ㅋ");
//		System.out.println(al.size());
//		System.out.println(al.get(0));

		// <자료형>: 제네릭
		// 특정 객체 강제
		// 기본 데이터형 불가능
		ArrayList<Integer> al2 = new ArrayList<>();
		al2.add(2); // 자동으로 int->Integer로 형변환
		al2.add(213);
		al2.add(867);
		al2.add(159);
		al2.add(897);
		al2.add(456);
		al2.add(1,9999);// 1번위치에 9999저장
		al2.set(0, 58);// 수정
		al2.remove(3);
		// 리스트 정렬
		Comparator<Integer>c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);// 오름차순
				//return o2.compareTo(o1); 내림차순
			}
		
		};
		al2.sort(c);
		
		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("--------------------");
		for (Integer integer : al2) {
			System.out.println(integer);
		}

	}

}
