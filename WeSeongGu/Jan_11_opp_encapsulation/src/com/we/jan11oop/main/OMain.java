package com.we.jan11oop.main;
//캡슐화
import java.util.Scanner;

import com.we.jan11oop.human.Human;

public class OMain {
	public static void main(String[] args) {
		Human h =new Human("홍길동", 30);
		Scanner sc = new Scanner(System.in);
		h.printInfo();
		System.out.print("수정할 나이: ");
		int age = sc.nextInt();
		
		h.setAge(age);
		
		h.printInfo();
		
		System.out.println("---------------------");
		System.out.println(h.getAge());
	}
}
