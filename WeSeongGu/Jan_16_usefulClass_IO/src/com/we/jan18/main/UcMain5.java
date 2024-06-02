package com.we.jan18.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UcMain5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// utf-8 디코딩 파일에서 읽어 들이기
		
		BufferedReader br = null;
		try {
			FileInputStream fos = new FileInputStream("E:\\study/0116_2.txt");
			InputStreamReader isr =new InputStreamReader(fos,"utf-8");// euc-kr로 하면 문제 발생 이유 쓸때 utf-8로 했기 때문에
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

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
