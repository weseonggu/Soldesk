package com.we.jan18.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class UCMain4 {
// encoding: 데이터 -> 전기신호
// decoding: 전기신호 -> 데이터
// encoding decoding 은 같은 방식을 사용해야한다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("뭐: ");
		String s = sc.next();
// utf-8 인코딩
		BufferedWriter bw=null;
		
		try {
			// FileWriter fw; // 2byte라서 이미 글자를 인식하는 수준 
			// 설명 a로 인코딩을 하면 a로 디코딩을 해야하는데 fileWriter, fileReader는 2바이트로 읽어들이는데 
			// 그 클래스만의 방식으로 인코딩 디코딩을 하기때문에 문제가 방생함
			FileOutputStream fos = new FileOutputStream("E:\\study/0116_2.txt",true); //outputStream개조형 1byte라 글자가 덜읽은 상태
			OutputStreamWriter osw =new OutputStreamWriter(fos,"utf-8");
			bw=new BufferedWriter(osw);
			bw.write(s+"\r\n");
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		sc.close();
	}

}
