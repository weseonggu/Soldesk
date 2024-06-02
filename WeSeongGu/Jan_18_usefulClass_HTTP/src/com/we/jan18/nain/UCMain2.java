package com.we.jan18.nain;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class UCMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpURLConnection huc = null;

		BufferedWriter bw = null;

		try {
			FileOutputStream fos = new FileOutputStream("E:\\study/subway.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
		for (int y = 2015; y < 2023; y++) {
			for (int m = 1; m < 13; m++) {

				for (int i = 1; i < 32; i++) {

					String s = String.format("%d%02d%02d", y, m, i);

					System.out.println(s);

						URL u = new URL(
								"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/CardSubwayStatsNew/1/650/"
										+ s);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();

						XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
						XmlPullParser xpp = xppf.newPullParser();// 펙토리얼 패턴 사용
						xpp.setInput(is, "utf-8");

						
						

						int type = xpp.getEventType();

						String t=null;

						while (type != XmlPullParser.END_DOCUMENT) {
							if (type == XmlPullParser.START_TAG) {
								t=xpp.getName();
							}else if(type == XmlPullParser.TEXT) {
								if(t.equals("USE_DT")) {
									bw.write(xpp.getText().substring(0,4)+",");
									bw.write(xpp.getText().substring(4,6)+",");
									bw.write(xpp.getText().substring(6,8)+",");
								}else if(t.equals("LINE_NUM")) {
									bw.write(xpp.getText()+",");
								}else if(t.equals("SUB_STA_NM")) {
									bw.write(xpp.getText().replace(",",".")+",");
								}else if(t.equals("RIDE_PASGR_NUM")) {
									bw.write(xpp.getText()+",");
								}else if(t.equals("ALIGHT_PASGR_NUM")) {
									bw.write(xpp.getText()+"\r\n");
									bw.flush();
								}
							}else if(type == XmlPullParser.END_TAG) {
								t="";
							}
							xpp.next();// 다음 dom겍체
							type = xpp.getEventType();
						}
						System.out.println(s);

				}
			}
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
	}

}
