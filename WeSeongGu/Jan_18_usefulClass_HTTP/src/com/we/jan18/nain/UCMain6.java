package com.we.jan18.nain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UCMain6 {
//http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardBusStatisticsServiceNew/1/5/20151101/
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			// 파일에 쓰기 준비
			FileOutputStream fos = new FileOutputStream("E:\\study/bus.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			
			for (int m = 1; m < 13; m++) {
				for (int da = 1; da < 32; da++) {
					
					for (int start = 1; start < 40002; start+=1000) {
						
						String d = String.format("/%d/%02d/2015%02d%02d", start, start+999,m,da);
						URL u = new URL(
								"http://openapi.seoul.go.kr:8088/575a4655496b636839386f58586542/json/CardBusStatisticsServiceNew"
										+ d);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();
						InputStreamReader isr = new InputStreamReader(is, "utf-8");
						BufferedReader br = new BufferedReader(isr);
						String data = br.readLine();
						// System.out.println(data);
						
						// JSON parse 하기
						JSONParser jp = new JSONParser();
						JSONObject jo = (JSONObject) jp.parse(data);
						System.out.println(jo);
						if ((JSONObject) jo.get("RESULT") != null) {
							continue;
						}
						JSONObject jo1 = (JSONObject) jo.get("CardBusStatisticsServiceNew");
						JSONArray bus_data = (JSONArray) jo1.get("row");
						System.out.println(bus_data);
						String time = null;
						JSONObject wi = null;
						for (int i = 0; i < bus_data.size(); i++) {
							wi = (JSONObject) bus_data.get(i);
							time = (String) wi.get("USE_DT");
							bw.write((String) time.substring(0, 4) + ",");
							bw.write((String) time.substring(4, 6) + ",");
							bw.write((String) time.substring(6, 8) + ",");
							bw.write((String) wi.get("BUS_ROUTE_NM") + ",");
							bw.write(((String) wi.get("BUS_STA_NM")).replace(",", ".") + ",");
							bw.write(((String) wi.get("BUS_ROUTE_NM")).replace(",", ".") + ",");
							bw.write((int) (double) wi.get("RIDE_PASGR_NUM") + ",");
							bw.write((int) (double) wi.get("ALIGHT_PASGR_NUM") + "\r\n");
							bw.flush();
							
						}
					}
				}
			}


		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
