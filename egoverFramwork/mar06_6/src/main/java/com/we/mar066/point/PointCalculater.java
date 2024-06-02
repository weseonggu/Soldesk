package com.we.mar066.point;

import javax.servlet.http.HttpServletRequest;

public class PointCalculater {
	private double pointRate;
	public PointCalculater() {
		// TODO Auto-generated constructor stub
	}
	public void calculate(PointInfo p, HttpServletRequest req) {
		p.setPoint(p.getPrice() * pointRate);
		req.setAttribute("ppp", p);
	}

	public double getPointRate() {
		return pointRate;
	}

	public void setPointRate(double pointRate) {
		this.pointRate = pointRate;
	}

}
