package com.we.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class SBO {
	private static final SBO Sbo = new SBO();
	private Random r;
	private int num;
	private int[] arr;
	private int strike;
	private int ball;
	private int tun;

	private SBO() {
		r = new Random();
		strike = 0;
		ball = 0;
		tun =0;
		arr = new int[3];
	}

	public static SBO getSbo() {
		return Sbo;
	}

	public void getNum() {
		int num = r.nextInt(900) + 100;
		while (true) {
			arr[0] = num / 100;// 백의 자리 수
			arr[1] = (num % 100) / 10;// 십의 자리 수
			arr[2] = num % 10;// 일의 자리 수
			if (arr[0] == arr[1] || arr[0] == arr[2] || arr[1] == arr[2]) {
				num = r.nextInt(900) + 100;
			} else {
				break;
			}
		}
		System.out.println("랜덤수: "+num);
		System.out.print(arr[0] + ", ");
		System.out.print(arr[1] + ", ");
		System.out.println(arr[2]);
		this.num = num;
	}

	public boolean judge(HttpServletRequest request) {
		tun++;
		request.setAttribute("ttt", tun);
		int userNum = Integer.parseInt(request.getParameter("swing"));
		int[] uarr = new int[3];
		uarr[0] = userNum / 100;// 백의 자리 수
		uarr[1] = (userNum % 100) / 10;// 십의 자리 수
		uarr[2] = userNum % 10;// 일의 자리 수
		if (arr[0] == uarr[0] || arr[1] == uarr[1] || arr[2] == uarr[2]) {// 스트라이트 검사
			strike++;
			System.out.println("스트라이크 " + strike);
			request.setAttribute("sss", strike);
			request.setAttribute("bbb", ball);
			if (strike == 3) {
				strike = 0;
				ball = 0;
				tun=0;
				return true;
			}
		}else if(arr[0] == uarr[0] && arr[1] == uarr[1] && arr[2] == uarr[2]) {
			request.setAttribute("sss", strike);
			request.setAttribute("bbb", ball);
			request.setAttribute("hhh", "홈런");			
			strike = 0;
			ball = 0;
			tun=0;
			return true;
		}else {
			loop: for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < uarr.length; j++) {
					if (arr[i] == uarr[j]) {
						ball++;
						System.out.println("볼" + ball);
						request.setAttribute("sss", strike);
						request.setAttribute("bbb", ball);
						break loop;
					}
				}
			}
			System.out.print(uarr[0] + ", ");
			System.out.print(uarr[1] + ", ");
			System.out.println(uarr[2]);
			return false;
		}

		return false;
	}

}
