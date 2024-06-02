package com.we.jan18.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UCMain7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		try {
			FileInputStream fos = new FileInputStream("E:\\study/food.csv");
			InputStreamReader isr = new InputStreamReader(fos, "utf-8");
			br = new BufferedReader(isr);
			String line = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E)");
			Date exp =null;
			String[] data;
			int price=0;
			double weight = 0;
			int sum =0;
			int count=0;
			Date now = new Date();
			while ((line = br.readLine()) != null) {
				count++;
				data = line.split(",");
				System.out.println("이름: " + data[0]);
				exp = sdf.parse(data[1]);// String -> Data
				System.out.println("유통기한: " + sdf2.format(exp));
				
				price = Integer.parseInt(data[2]);
				weight = Double.parseDouble(data[3]);
				sum+=price;
				System.out.println("가격: " + price);
				System.out.println("중량: " + weight);
				
				System.out.println("--------------");
				System.out.println(exp.before(now) ? "먹지마": "먹어");
			}
			System.out.println("--------------");
			System.out.println("상품 편균 가격: "+sum/(double)count);

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

	}

}
