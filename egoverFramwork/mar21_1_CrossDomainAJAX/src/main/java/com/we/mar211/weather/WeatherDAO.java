package com.we.mar211.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {
	public String getWeather() {
		HttpURLConnection huc = null;

		try {
			String s = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1135063000";
			URL u = new URL(s);
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr  = new InputStreamReader(is);
			
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String line= null;
			
			while((line = br.readLine())!=null) {
				sb.append(line);
			}
			return sb.toString();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}
}
