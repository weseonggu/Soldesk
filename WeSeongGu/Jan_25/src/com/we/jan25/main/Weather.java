package com.we.jan25.main;

public class Weather {
	private String time;
	private String temp;
	private String state;
	private String day;

	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(String time, String temp, String state, String day) {
		super();
		this.time = time;
		this.temp = temp;
		this.state = state;
		this.day = day;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		if (day.equals("0")) {
			this.day = "오늘";
		} else if (day.equals("1")) {
			this.day = "내일";

		} else if (day.equals("2")) {
			this.day = "모래";
		}
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void printInfo() {
		System.out.println(day);
		System.out.println(time);
		System.out.println(temp);
		System.out.println(state);
	}

}
