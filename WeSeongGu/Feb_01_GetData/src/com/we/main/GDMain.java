package com.we.main;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xmlpull.v1.XmlPullParserException;

public class GDMain {
	// http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/xml/RealtimeCityAir/1/25/
	
	public static void main(String[] args) {
		XmlGetData xdg = null;
		try {
			xdg = new XmlGetData();
			xdg.getdata();			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		xdg.dchttp();

	}
}
