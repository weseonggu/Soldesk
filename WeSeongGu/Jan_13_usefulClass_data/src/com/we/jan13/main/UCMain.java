package com.we.jan13.main;
//  data clss 유용한 데이터 클래스
public class UCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "뭘 할라 그래도 내용이 너무 없어가지고"; // 문자열 클래스
		
		// 세번째 글자
		System.out.println(s.charAt(2));
		
		// n~m번째 글자
		System.out.println(s.substring(3, 7));
		
		// 뭘 이라는 말로 시작하나
		System.out.println(s.startsWith("뭘"));
		
		//총 글자수
		System.out.println(s.length());
		
		// 너무 -> 참
		System.out.println(s.replace("너무", "참"));
		
		// 없 포함?
		System.out.println(s.contains("없"));
	}

}
