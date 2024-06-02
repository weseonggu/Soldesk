package com.we.jan13.main;

import java.util.StringTokenizer;

public class UCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ";
		
		
		// ㅎㅎㅎ추가 +는 메모리에 새로 생기고 기존꺼를 지우기 때문에 빅데하기에는 매우 부적절함
		System.out.println(s.concat("ㅎㅎㅎ"));
		
		System.out.println("-----------------------");
		// 문자열을 대량으로 붙일거면 (빅대에서 문자를 여러번 변경하는일이 있을 때)
		// 수정가능한 문자열 객체
		StringBuffer sb = new StringBuffer("ㅋㅋㅋㅋㅋ");
		sb.append("gggg");
		sb.append(123);
		System.out.println(sb.toString());
		
		// 정형데이터에 유리한
		String s3 = "아 근데 회식 예약은 됐나요";
		String[] s4=s3.split(" ");
		System.out.println(s4[1]);
		System.out.println(s4[4]);
		System.out.println("-------------------------");
		
		// 비정형데이터에 유리한
		StringTokenizer st = new StringTokenizer(s3,"");
		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
//		System.out.println(st.nextToken());
		
	}

}
