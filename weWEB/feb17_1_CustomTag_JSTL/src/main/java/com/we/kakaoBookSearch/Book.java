package com.we.kakaoBookSearch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Book {
	private static final Book B= new Book();
	private Book() {
		// TODO Auto-generated constructor stub
	}
	public static Book getB() {
		return B;
	}
	public void searchBook(HttpServletRequest request, HttpServletResponse response) {
		HttpsURLConnection huc = null;
		ArrayList<BookInfo> arr = new ArrayList<>();
		try {
			String name = request.getParameter("search");
			name = URLEncoder.encode(name,"utf-8");
			String s = "https://dapi.kakao.com/v3/search/book";
			s+="?query="+name;
			
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			
			huc.setRequestProperty("Authorization", "KakaoAK 8dc0783d71d5cb4ec931041f4733fe64");
			
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(data);
			
			JSONArray search_data = (JSONArray) jo.get("documents");
			

			for (int i = 0; i < search_data.size(); i++) {
				JSONObject wi = (JSONObject) search_data.get(i);
				BookInfo bi = new BookInfo(wi.get("authors"), (long)wi.get("price")
						, wi.get("publisher"), wi.get("title"), wi.get("url"), wi.get("thumbnail"));
				arr.add(bi);
			}

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		request.setAttribute("bookinfos", arr);

	}
}
