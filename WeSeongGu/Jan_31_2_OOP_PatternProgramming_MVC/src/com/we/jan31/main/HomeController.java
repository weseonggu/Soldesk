package com.we.jan31.main;

import java.util.ArrayList;

// 프로젝트가 커지면 C도 많아짐
// 그중 프로그램의 진입점 약할해주는 첫C의 이름의 보통 homecontroller or maincontroller로 짓는다
public class HomeController {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr= null;
		ConsoleScreen_v c =new ConsoleScreen_v();
		arr=c.inputNum();
		CalcResult cal = Calculator_m.name(arr);
		cal.printInfo();
		
		c.destory();
	}

}
