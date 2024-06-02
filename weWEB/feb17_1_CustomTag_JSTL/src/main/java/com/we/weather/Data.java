package com.we.weather;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Data {
	private String time;
	private String doo;
	private String weather;
	private String encodingWeather;

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String time, String doo, String weather) throws UnsupportedEncodingException {
		super();
		this.time = time;
		this.doo = doo;
		this.weather = weather;
		this.encodingWeather =  URLEncoder.encode(weather, "euc-kr").replace("+", " ");// 파일명 euc-kr로 인코딩
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDoo() {
		return doo;
	}

	public void setDoo(String doo) {
		this.doo = doo;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getEngWeather() {
		return encodingWeather;
	}

	public void setEngWeather(String engWeather) {
		this.encodingWeather = engWeather;
	}

}
