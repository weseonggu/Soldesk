package com.we.jan18.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class UCMain6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String s1 = sc.next();
		System.out.print("유통기한(YYYYMMDD): ");
		String s2 = sc.next();
		System.out.print("가격: ");
		String s3 = sc.next();
		System.out.print("중량: ");
		String s4 = sc.next();
		
		BufferedWriter bw=null;
		
		try {

			FileOutputStream fos = new FileOutputStream("E:\\study/food.csv",true); //outputStream개조형 1byte라 글자가 덜읽은 상태
			OutputStreamWriter osw =new OutputStreamWriter(fos,"utf-8");
			bw=new BufferedWriter(osw);
			String data = String.format("%s1,%s2,%s3,%s4\r\n", s1,s2,s3,s4);
			bw.write(data);
			bw.flush();
		} catch (Exception e) {
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
