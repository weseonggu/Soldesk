package com.we.weather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
//http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000
public class Weather {
	private static final Weather W =new Weather();
	private Weather() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static Weather getW() {
		return W;
	}


	private ArrayList<Data> http() {
		HttpURLConnection huc = null;
		ArrayList<Data> wData =null;
		try {
			String s = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000";
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
			xpp.setInput(is, "utf-8");

			int type = xpp.getEventType();
			wData = new ArrayList<>();
			String h = null;
			String temp = null;
			String weather = null;
			while (type != XmlPullParser.END_DOCUMENT) {// 문서 끝이 아닐떄까지 반복
				if (type == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("hour")) {
						xpp.next();
						h = xpp.getText();
						System.out.println(h+"시 까지");
					} else if (xpp.getName().equals("temp")) {
						xpp.next();
						temp = xpp.getText();
						System.out.println(temp+"도");
					} else if (xpp.getName().equals("wfKor")) {
						xpp.next();
						weather = xpp.getText();
						System.out.println("닐씨: "+weather);
						System.out.println("------------");
						wData.add(new Data(h, temp, weather));
					}
				} else if (type == XmlPullParser.TEXT) {

				} else if (type == XmlPullParser.END_TAG) {

				}
				xpp.next();// 다음 dom겍체
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		huc.disconnect();
		return wData;
	}
	public void getWeather(HttpServletRequest req) {
		req.setAttribute("weatherData", http());
		
	}
}
