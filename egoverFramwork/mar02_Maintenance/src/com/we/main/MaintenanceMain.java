package com.we.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MaintenanceMain {
// .jar 파일로 만들면 추후 유지보수거 불가능 해짐 -> 추후 포인트 퍼센트를 변경하려고 하려면 프로그램을 다시 짜서 고객에게 다시줘야함 -> 번거러윰 증가
// 좀 더 간편한 유지보수를 가능하도록 프로그램을 변경햐야한다.

// 수정이  일어 날만하거는 외부파일에 쓰고 자바에서 불러오는 방식을 사용하면 좀더 편리해진다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("구매 금액: ");
		int price = sc.nextInt();
		// 포인트 퍼샌트를 파일에서 읽어 오는 걸로 변경 -> 적립 포인트 퍼센트가 쉬워짐
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sdedu\\Desktop\\perPoint.txt");
			InputStreamReader isr =  new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String pr = br.readLine();
			double per = Double.parseDouble(pr);
			double perpoint = price*per;
			int point = (int)Math.round(perpoint);
			System.out.printf("적립포인트: %d\n",point);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.printf("포인트: %.0f원\n",point);
		
		System.out.print("뭐라도 입력: ");
		sc.next();
		sc.close();
	}
	
	

	

}
