package com.we.jan17.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// 자바의 HTTP 클래스 사용
// HTTP
// HTTPS
public class UCMain {

	public static void main(String[] args) {

		HttpsURLConnection huc = null;
		
		try {
			String s ="https://www.naver.com/";
			URL u = new URL(s);
			// http or https
			// HttpURLConnection huc;
			huc = (HttpsURLConnection) u.openConnection(); //return타입이 object라 형변환 해서 사용해야함
			// 아파치의 응답 요청 응답 받음 그런 과정을 전부 생략함
			InputStream is =  huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br =new BufferedReader(isr);
			String line = null;
			while((line = br.readLine())!= null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		huc.disconnect();
	}

}
