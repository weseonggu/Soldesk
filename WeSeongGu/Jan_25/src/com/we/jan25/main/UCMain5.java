package com.we.jan25.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UCMain5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호: ");
		int n = sc.nextInt();
		
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 82, 95, 75));
		students.add(new Student("김길동", 44, 88, 12));
		students.add(new Student("이길동", 57, 85, 65));
		
		students.get(n-1).printInfo();
		System.out.println("------------------");
		int sum=0;
		for (Student student : students) {
			sum += student.getEng()+student.getKor()+student.getMath();
			System.out.println(sum / 3.0);
			sum=0;
		}

	}
}
