package com.we.third;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ThirdM {
	// first 와 second에서 만든 값을 third에서 사용 하려하지만 사용 불가능
	
	// 해결 방법
	
	//session
		// back-end에서 만들어진 값
		// object
		// 사용자와 서버연결에 저장
		//HttpSession hs = request.getSession();
		//hs.setAttribute("pi", pi);
		//Java에서 읽기 : hs.getAttribute("어트리뷰트명")
		//EL : ${sessionScope.어트리뷰트명}
		//기본 유지 시간 30분 아무것도 안하면 저장 값 사라짐 -> 로그인에 사용
	
	// cookie
		// back-end에서 만들어진 값
		// String
		// 사용자pc에 파일로 저장 - 보안적으로 위험함(타인이 볼수 있음-요즘은 암호화함)
		// 유지시간 - 없음
		// JAVA : 코드 참고
		// EL : ${cookie.쿠키명.value}	
	public static void printData(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		Double pi = (Double)hs.getAttribute("pi");
		System.out.println(pi);
		// cookie읽기
		Cookie[] cookies = request.getCookies();
		for (Cookie ck : cookies) {
			if(ck.getName().equals("vvv")) {
				System.out.println(ck.getValue());
			}
		}
	}
}
