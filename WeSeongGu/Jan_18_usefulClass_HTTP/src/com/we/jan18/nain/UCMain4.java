package com.we.jan18.nain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UCMain4 {
//	https://api.openweathermap.org/data/2.5/weather
//	?
//	lat={lat}: 위도
//	&
//	lon={lon}: 경도
//	&
//	appid={API key}: 키
// 내집 위도 경도
// 3d37.6749836 위도
// 4d127.0583815 경도
	
// 최종 주소
//	https://api.openweathermap.org/data/2.5/weather?lat=37.6749836&lon=127.0583815&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr

	
// JSON parsing - 자바에 없음 - 더많이 사용
	// json javascript를 위한 데이터 표혀 방식 
	// 표현 방식이 자바의 객체 선연 방식이랑 같음
	
	// xml에 비해서 용량이 적음
	// 상위 호환임 그래서 xml을 잘 사용 안함
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		

		
		try {
			URL u = new URL("https://api.openweathermap.org/data/2.5/weather?lat=37.6749836&lon=127.0583815&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr\r\n");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			// 파일에 쓰기
			FileOutputStream fos = new FileOutputStream("E:\\study/weather.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			// 날짜 구하기
			Date now = new Date();
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy,MM,dd,hh,mm,");
			String date = sdf.format(now);
			bw.write(date);
			
			// json paese하는 클래스
			JSONParser jp = new JSONParser();
			//jp.parse(isr);//InputStreamReader 을 주던지 아닌 String(data)를 주던지
			// { 로 시작하면 -> 객체
			JSONObject jo = (JSONObject) jp.parse(data); // 모든 데이터가 저장됨
			// [ 로 시작하면 -> 배열
			// JSONArray jo = (JSONObject) jp.parse(data);
			
			// jo에 모든 객체를 담아 놓음 => 용량이 크면? (문제는 생김)
			// 날씨
			JSONArray w = (JSONArray) jo.get("weather");//weather 배열
			JSONObject w0 = (JSONObject) w.get(0);//weather배열의 객체
			System.out.println(w0.get("description"));
			bw.write( (String)w0.get("description"));
			// 온도 습도
			JSONObject m = (JSONObject) jo.get("main");
			System.out.println(m.get("temp"));
			System.out.println(m.get("humidity"));
			bw.write(m.get("temp")+",");
			bw.write(m.get("humidity")+"\r\n");
			bw.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
