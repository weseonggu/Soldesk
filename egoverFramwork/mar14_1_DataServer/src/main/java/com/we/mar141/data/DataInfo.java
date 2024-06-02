package com.we.mar141.data;

import java.math.BigDecimal;

public class DataInfo {
	private String ms_name;
	private BigDecimal ms_price;
	
	public DataInfo() {
		// TODO Auto-generated constructor stub
	}

	public DataInfo(String ms_name, BigDecimal ms_price) {
		super();
		this.ms_name = ms_name;
		this.ms_price = ms_price;
	}

	public String getMs_name() {
		return ms_name;
	}

	public void setMs_name(String ms_name) {
		this.ms_name = ms_name;
	}

	public BigDecimal getMs_price() {
		return ms_price;
	}

	public void setMs_price(BigDecimal ms_price) {
		this.ms_price = ms_price;
	}
	
	
}
