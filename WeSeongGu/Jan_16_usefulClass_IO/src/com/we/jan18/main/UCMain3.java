package com.we.jan18.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UCMain3 {

	public static void main(String[] args) {

// 파일에서 읽기	
		BufferedReader br = null;
		try {
			// inputStreamReader 개조형
			FileReader fr = new FileReader("E:\\study/0116.txt");
			br = new BufferedReader(fr);

			String line = null;

			while ((line = br.readLine()) != null) {

				System.out.println(line);

			}

//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
