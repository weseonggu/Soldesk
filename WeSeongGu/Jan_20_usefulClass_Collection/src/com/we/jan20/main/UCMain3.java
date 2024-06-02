package com.we.jan20.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class UCMain3 {
	public static void main(String[] args) {
		BufferedReader br = null;
		ArrayList<Subway> sub = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream("D:\\Data/subway.csv");
			InputStreamReader isr =new InputStreamReader(fis,"utf-8");// euc-kr로 하면 문제 발생 이유 쓸때 utf-8로 했기 때문에
			br = new BufferedReader(isr);
			String line = null;
			// ArrayList에 데이터 저장
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				sub.add(new Subway(data[0], data[1],data[2],data[3],data[4],data[5],data[6]));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 데이터 정렬
		Comparator<Subway>c = new Comparator<Subway>() {
			
			@Override
			public int compare(Subway o1, Subway o2) {
				// TODO Auto-generated method stub
				return o2.IOSum().compareTo(o1.IOSum());

			}
			
		};
		sub.sort(c);
		for (Subway subway : sub) {
			subway.printInfo();
		}
		System.out.println("-------------------");
		sub.get(0).printInfo();
		
	}
}
