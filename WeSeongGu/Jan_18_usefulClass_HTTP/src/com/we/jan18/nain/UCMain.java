package com.we.jan18.nain;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain {
// 실시간 미세먼지데이터 csv파일에 기록
	public static void main(String[] args) {
		
		HttpURLConnection huc = null;
		
		BufferedWriter bw = null;
		//날짜 
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,hh,mm");
		String time = sdf.format(now);
		System.out.println(time);

		try {
			URL u = new URL("http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
			xpp.setInput(is, "utf-8");

			int type = xpp.getEventType();
			String a = null;
			String b = null;
			String c = null;
			String d = null;
			String e = null;
			String data = null;
			// 인터넷이 안열리면 파일을 안 열리도록 밑에 다 적기
			FileOutputStream fos = new FileOutputStream("E:\\study/fine_dust.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			while (type != XmlPullParser.END_DOCUMENT) {// 문서 끝이 아닐떄까지 반복
				if (type == XmlPullParser.START_TAG) {
					if (xpp.getName().equals("MSRRGN_NM")) {
						xpp.next();
//						System.out.println(xpp.getText());
						a = xpp.getText();
					} else if (xpp.getName().equals("MSRSTE_NM")) {
						xpp.next();
//						System.out.println(xpp.getText());
						b = xpp.getText();
					} else if (xpp.getName().equals("PM10")) {
						xpp.next();
//						System.out.println(xpp.getText());
						c = xpp.getText();
					} else if (xpp.getName().equals("PM25")) {
						xpp.next();
//						System.out.println(xpp.getText());
						d = xpp.getText();
					} else if (xpp.getName().equals("IDEX_NM")) {
						xpp.next();
//						System.out.println(xpp.getText());
						e = xpp.getText();
//						System.out.println("---------------");
						System.out.printf("%s,%s,%s,%s,%s,%s\r\n", time, a, b, c, d, e);
						data = String.format("%s,%s,%s,%s,%s,%s\r\n", time, a, b, c, d, e);
						bw.write(data);
						bw.flush();
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
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		huc.disconnect();
///////////////////////////////////////////////파일에서 읽기
//		BufferedReader br = null;
//		System.out.println("파일에서 읽어 들이기");
//		int count=0;
//		try {
//			// inputStreamReader 개조형
//			FileReader fr = new FileReader("E:\\study/subway.csv");
//			br = new BufferedReader(fr);
//
//			String line = null;
//
//			while ((line = br.readLine()) != null) {
//
////				System.out.println(line);
//				count++;
//
//			}
//
////			System.out.println(br.readLine());
////			System.out.println(br.readLine());
////			System.out.println(br.readLine());
//			System.out.println(count);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		try {
//			br.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
