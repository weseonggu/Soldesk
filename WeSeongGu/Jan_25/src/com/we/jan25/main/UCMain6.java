package com.we.jan25.main;

import java.util.HashMap;
import java.util.Scanner;

public class UCMain6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름: ");
		String n = sc.next();
		
		HashMap<String, Student> students = new HashMap<>();
		students.put("홍길동", new Student("홍길동", 82, 95, 75));
		students.put("김길동", new Student("김길동", 44, 88, 12));
		students.put("이길동", new Student("이길동", 57, 85, 65));
		
		students.get(n).printInfo();
		
		
		
	}
}
