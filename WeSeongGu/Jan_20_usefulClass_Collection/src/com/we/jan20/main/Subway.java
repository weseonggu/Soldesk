package com.we.jan20.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subway {
	private String year;
	private String month;
	private String day;
	private String line;
	private String station;
	private String ride;
	private String out;
	
	public Subway() {
		// TODO Auto-generated constructor stub
	}



	public Subway(String year, String month, String day, String line, String station, String ride, String out) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.line = line;
		this.station = station;
		this.ride = ride;
		this.out = out;
	}



	public String getDay() {
		return day;
	}



	public void setDay(String day) {
		this.day = day;
	}



	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getRide() {
		return ride;
	}

	public void setRide(String ride) {
		this.ride = ride;
	}

	public String getOut() {
		return out;
	}

	public void setOut(String out) {
		this.out = out;
	}
	
	public Integer IOSum() {
		return Integer.parseInt(ride)+Integer.parseInt(out);
	}
	public void printInfo() {
		System.out.print(year+" ");
		System.out.print(month+" ");
		System.out.print(day+" ");
		System.out.print(station+" ");
		System.out.print(line+" ");
		System.out.print(ride+" ");
		System.out.println(out);
	}
}
