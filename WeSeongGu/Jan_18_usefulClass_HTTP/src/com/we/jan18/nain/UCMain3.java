package com.we.jan18.nain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import we.string.cleaner.StringCleaner;

// 인터넷 주소 형식
// https://  						-protocol 통신방식
// openapi.naver.com  				- 서버주소
// /v1/search/news.xml 				- 폴더/파일/파일
// ? 								- 구분자
// 변수명=값&변수명=값&변수명=값......   	-request parameter(별로 안중요한)

//내부적으로 전다달: request header(보안상 감춰야하는것 들) huc.setRequestProperty("키","값")으로 사용

// 인터넷 주소에는 한글x
// 한글 ->%~~(URL인코딩)
public class UCMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpsURLConnection huc = null;
		BufferedWriter bw = null;

		try {
			String what = "코로나"; // 코로나 -> 인코딩 ->%EC%BD%94%EB%A1%9C%EB%82%98
			what = URLEncoder.encode(what, "utf-8");// utf-8로 원하는 검색어 인코딩
			String s = "https://openapi.naver.com/v1/search/news.xml?query=" + what;
			URL u = new URL(s);
			huc = (HttpsURLConnection) u.openConnection();
			// setRequestProperty(여러개 쓰면 마지막이 키가 됨) or addRequestProperty(키 추가)
			huc.setRequestProperty("X-Naver-Client-Id", "Sqdm8Fxhou1LGDnZRxRn");// request header: id
			huc.setRequestProperty("X-Naver-Client-Secret", "25okncnfTY");// request header: secret
			InputStream is = huc.getInputStream();

			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			// System.out.println(br.readLine());

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");
			
			// 파일에 적기
			FileOutputStream fos = new FileOutputStream("E:\\\\study/news.txt", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			bw = new BufferedWriter(osw);

			int type = xpp.getEventType();
			boolean data = false;
			String t = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("item")) {
						data = true;
					}
				} else if (type == XmlPullParser.TEXT) {
					if (data) {

						if (t.equals("title")) {
							System.out.println(StringCleaner.clean(xpp.getText()) );
							bw.write(StringCleaner.clean(xpp.getText())+"\t");
							bw.flush();
						} else if (t.equals("description")) {
							System.out.println(StringCleaner.clean(xpp.getText()));
							bw.write(StringCleaner.clean(xpp.getText())+"\r\n");
							bw.flush();
						}
					}

				} else if (type == XmlPullParser.END_TAG) {
					t = "";
				}
				xpp.next();
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
	}

}
