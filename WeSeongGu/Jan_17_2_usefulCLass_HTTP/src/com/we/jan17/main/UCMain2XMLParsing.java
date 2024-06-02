package com.we.jan17.main;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain2 {
// 기상청 정보 가져오기 (XML표준 사용)
// 데이터 제공자, 제이터 받아서 쓰는 사람
// 간의 통일된 형식이 필요할 것 (csv로는 복잡한게 감당이 안됨)
// 국제표준 데이터 형식
// 		XML: 데이터를 HTML형식으로 표현
//		jSON: 데이터를 JavaScript형식으로 표현

// 데이터 parsing
// 		쓸데 없는 부분 걷어내고, 이쁘게 다듬는 행위

// DOM겍체
	// <xxx>: 시작 태그 xxx: 택스트 </xxx>: 종료 테그

	// XML parsing : 자바에 클래스 없음 다른 클래스 가져와서 사용해야함
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpURLConnection huc = null;

		try {
			// 시상청 사이트 데이터 가져오기
			String s = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000";
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			// 아파치의 응답 요청 응답 받음 그런 과정을 전부 생략함
			InputStream is = huc.getInputStream();
			///////////////////////////////////////////////////////////
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
			xpp.setInput(is, "utf-8");

			// 지금 빨아 당긴게 뭔가
			// 시작태그, 택스트, 종료태그
			int type = xpp.getEventType();
			String h = null;
			String temp = null;
			String weather = null;
			String see = null;
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
					}
				} else if (type == XmlPullParser.TEXT) {

				} else if (type == XmlPullParser.END_TAG) {

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
