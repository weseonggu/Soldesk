package com.we.jan18.nain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UCMain5_KAKAO {
// 카카오 개발자 센터
	// rest api키 8dc0783d71d5cb4ec931041f4733fe64
	public static void main(String[] args) {
		Scanner sc = null;
		HttpsURLConnection huc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.print("뭐: ");
			String search = sc.next();

			search = URLEncoder.encode(search, "utf-8");
			String s = "https://dapi.kakao.com/v2/local/search/keyword.json";
			s+= "?";
			s+="x=127.0583815&y=37.6749836&radius=2000&query="+search;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			
			huc.setRequestProperty("Authorization", "KakaoAK 8dc0783d71d5cb4ec931041f4733fe64");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			System.out.println(data);
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(data);
			
			JSONArray search_data = (JSONArray) jo.get("documents");
			

			for (int i = 0; i < search_data.size(); i++) {
				JSONObject wi = (JSONObject) search_data.get(i);
				System.out.println(wi.get("place_name"));
				System.out.println(wi.get("road_address_name"));
				System.out.println(wi.get("distance"));
				System.out.println(wi.get("x"));
				System.out.println(wi.get("y"));
				
			}

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();

		sc.close();
	}

}
