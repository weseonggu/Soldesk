package com.we.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Judge {
	private static final Judge J = new Judge();
	private Random r;
	private int win;
	private int lose;
	private int draw;
	private Judge() {
		r = new Random();
		win=0;
		lose=0;
		draw=0;
	}
	public static Judge getJ() {
		return J;
	}
	
	private int putPC() {
		return r.nextInt(3)+1;
	}
	public void judge(HttpServletRequest request) {
		 int pcNum = putPC();
		 int userNum = Integer.parseInt(request.getParameter("put"));
		 int sub =  userNum - pcNum;
		 String result=null; 
		 if(sub == 0) {
			 draw++;
		 }else if(sub == -1 || sub == 2) {
			 lose++;
		 }else if(sub == -2 || sub == 1) {
			 win++;
		 }
		 result = Integer.toString(win)+"승"+Integer.toString(lose)+"패"+Integer.toString(draw)+"무";
		 request.setAttribute("pc", pcNum);
		 request.setAttribute("user", userNum);
		 request.setAttribute("result", result);
	}
}
