package com.we.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Judge {
	private static final Judge J = new Judge();
	private int num;
	private int tun;
	private Judge() {
		// TODO Auto-generated constructor stub
	}

	public static Judge getJ() {
		return J;
	}
	
	public void getRandomNum() {
		Random r = new Random();
		num =  r.nextInt(5000);
		tun =0;
	}

	public void setTun() {
		this.tun = 0;
	}

	public boolean upDown(HttpServletRequest request) {
		int input = Integer.parseInt( request.getParameter("www"));
		System.out.println("입력 값:"+input);
		if(num == input) {
			request.setAttribute("ans", "정답");
			request.setAttribute("tun", tun);
			setTun();
			return true;
		}else if(num < input) {
			tun++;
			request.setAttribute("ans", "다운");		
			request.setAttribute("tun", tun);
			return false;
		}else if(num > input) {
			tun++;
			request.setAttribute("ans", "업");	
			request.setAttribute("tun", tun);
			return false;
		}
		return true;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}


}
