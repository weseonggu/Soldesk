package com.we.jan17.main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UVMain3_dust {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HttpURLConnection huc = null;
		
		try {
			URL u = new URL("http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/");
			huc = (HttpURLConnection) u.openConnection(); 
			InputStream is =  huc.getInputStream();
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
			xpp.setInput(is, "utf-8");
			
			int type = xpp.getEventType();

			while (type != XmlPullParser.END_DOCUMENT) {// 문서 끝이 아닐떄까지 반복
				if (type == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("MSRRGN_NM")) {
						xpp.next();
						System.out.println(xpp.getText());
					} else if (xpp.getName().equals("MSRSTE_NM")) {
						xpp.next();
						System.out.println(xpp.getText());
					} else if (xpp.getName().equals("PM10")) {
						xpp.next();
						System.out.println(xpp.getText());
					}else if (xpp.getName().equals("PM25")) {
						xpp.next();
						System.out.println(xpp.getText());
					}else if (xpp.getName().equals("IDEX_NM")) {
						xpp.next();
						System.out.println(xpp.getText());
						System.out.println("---------------");
					}
				} 
				xpp.next();// 다음 dom겍체
				type = xpp.getEventType();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		huc.disconnect();

	}

}
