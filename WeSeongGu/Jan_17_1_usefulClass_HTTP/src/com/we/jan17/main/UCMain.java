package com.we.jan17.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// 통신
// Socket: 실시간 통신
// HTTP: (인터넷) 요청-응답

// HTTP서버 : JSP/Spring, flask, nodejs
// HTTP클라이언트: 자바에 없어서 만들어야함 -> 아파치 사용
public class UCMain {

	public static void main(String[] args) {
		
		// 아파치 Apache HttpComponents 현재는 자바꺼 사용해서 사용 안함
		
		
		DefaultHttpClient dhc = new DefaultHttpClient();
		try {
			// GET방식 요청 - 기본
			// POST방식 요청 - 레어
			HttpGet hg = new HttpGet("https://www.naver.com/");// 응답 요청
			HttpResponse hr = dhc.execute(hg);//응답이 옴
			HttpEntity he = hr.getEntity();//응답 내용
			InputStream is =he.getContent();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br =new BufferedReader(isr);
			String line = null;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dhc.close();
		// session: 시간 제한 , 시간 지나면 자동으로 끊김
		// HTTP서버쪽에서 끊기도 함
	}

}
