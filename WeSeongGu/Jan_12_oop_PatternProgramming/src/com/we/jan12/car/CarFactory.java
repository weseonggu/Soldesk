package com.we.jan12.car;

public class CarFactory {
	private String name;
	
	public Car makeCar(String type) {
		if (type.equals("세단")) {
			return new Sedan();
		} else if (type.equals("버스")) {
			return new Bus();
		}
		return new Truck();

	}
}
