package com.we.main;

public class DustMeasurement {
	private String MSRDT;
	private String MSRRGN_NM;
	private String MSRSTE_NM;
	private int PM10;
	private int pm25;
	private double O3;
	private String IDEX_NM;

	public DustMeasurement() {
		// TODO Auto-generated constructor stub
	}

	public DustMeasurement(String mSRDT, String mSRRGN_NM, String mSRSTE_NM, int pM10, int pm25, double o3,
			String iDEX_NM) {
		super();
		MSRDT = mSRDT;
		MSRRGN_NM = mSRRGN_NM;
		MSRSTE_NM = mSRSTE_NM;
		PM10 = pM10;
		this.pm25 = pm25;
		O3 = o3;
		IDEX_NM = iDEX_NM;
	}

	public String getMSRDT() {
		return MSRDT;
	}

	public void setMSRDT(String mSRDT) {
		MSRDT = mSRDT;
	}

	public String getMSRRGN_NM() {
		return MSRRGN_NM;
	}

	public void setMSRRGN_NM(String mSRRGN_NM) {
		MSRRGN_NM = mSRRGN_NM;
	}

	public String getMSRSTE_NM() {
		return MSRSTE_NM;
	}

	public void setMSRSTE_NM(String mSRSTE_NM) {
		MSRSTE_NM = mSRSTE_NM;
	}

	public int getPM10() {
		return PM10;
	}

	public void setPM10(int pM10) {
		PM10 = pM10;
	}

	public int getPm25() {
		return pm25;
	}

	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}

	public double getO3() {
		return O3;
	}

	public void setO3(double o3) {
		O3 = o3;
	}

	public String getIDEX_NM() {
		return IDEX_NM;
	}

	public void setIDEX_NM(String iDEX_NM) {
		IDEX_NM = iDEX_NM;
	}

}
