package com.we.jan12.main;

import java.util.Scanner;

import com.we.jan12.car.Car;
import com.we.jan12.car.CarFactory;

public class OMain3 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.print("뭐 만들래: ");
		String type = sc.next();
		CarFactory c=new CarFactory();
		Car c1=c.makeCar(type);
		c1.printInfo();
	}
}
