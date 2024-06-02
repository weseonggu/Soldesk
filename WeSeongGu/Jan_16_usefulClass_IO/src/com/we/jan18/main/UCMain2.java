package com.we.jan18.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("뭐: ");
		String s = sc.next();
// 파일에 쓰기		
		// 파일에 쓰기 편하게OutputStreamWriter 개조형
		// 파일이 없으면 만듬 펄더는 안만들어줌
		BufferedWriter bw=null;
		try {
			FileWriter fw = new FileWriter("E:\\study/0116.txt",true);// 기존에 내용에 추가
			// D: 가 엇으면
			// 폴다가 없으면
			// 지금 로그인한 윈도우 계정이 접근 권한이 없다면
			bw = new BufferedWriter(fw);
			bw.write(s+"\r\n");// "\r\n" 엔터 역할 커서 맨앞 줄바꾸기 (윈도우10이전버전에서는 \n 만하면 오류)
			bw.flush();// 강제로 작성
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			bw.close();// 하나만 닫으면 FileWriter BufferedWriter 다 닫힘
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
		
		
	}

}
