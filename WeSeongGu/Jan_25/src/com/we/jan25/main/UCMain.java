package com.we.jan25.main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		
		ArrayList<Weather> wArray = new ArrayList<>();

		try {
			String s = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000";
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			// 아파치의 응답 요청 응답 받음 그런 과정을 전부 생략함
			InputStream is = huc.getInputStream();
			///////////////////////////////////////////////////////////
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
			xpp.setInput(is, "utf-8");

			int type = xpp.getEventType();
			String t =null;
			String h = null;
			String temp = null;
			String weather = null;
			String see = null;
			Weather w = null;
			while (type != XmlPullParser.END_DOCUMENT) {// 문서 끝이 아닐떄까지 반복
				
				if (type == XmlPullParser.START_TAG) {
					
					t=xpp.getName();
					if(t.equals("data")) {
						w= new Weather();
					}

				} else if (type == XmlPullParser.TEXT) {
					if (t.equals("hour")) {
						w.setTime(xpp.getText());
					} else if (t.equals("temp")) {
						w.setTemp(xpp.getText());
					} else if (t.equals("wfKor")) {
						w.setState(xpp.getText());
					}else if (t.equals("data")) {
						w.setDay(xpp.getText());
						System.out.println(xpp.getText());
						wArray.add(w);
					}

				} else if (type == XmlPullParser.END_TAG) {
					t="";
				}
				xpp.next();// 다음 dom겍체
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		huc.disconnect();
		Comparator<Weather>cw = new Comparator<Weather>() {
			
			@Override
			public int compare(Weather o1, Weather o2) {
				Double t1 =  Double.parseDouble(o1.getTemp());
				Double t2 =  Double.parseDouble(o2.getTemp());
				return t2.compareTo(t1);
			}
		};
//		wArray.sort(cw);
//		for (Weather weather : wArray) {
//			weather.printInfo();
//		}
	}
}
