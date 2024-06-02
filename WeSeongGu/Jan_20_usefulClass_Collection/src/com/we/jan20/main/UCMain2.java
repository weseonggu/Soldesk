package com.we.jan20.main;

import java.util.ArrayList;
import java.util.Comparator;

public class UCMain2 {
	public static void main(String[] args) {
		Student s = new Student("위성구", 100, 90, 80);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(s);
		students.add(new Student("기길동", 84, 54, 79));
		students.add(new Student("기자동", 81, 94, 52));
		students.add(new Student("기쇼동", 21, 100, 84));
		System.out.println("---------------------");
		
		Comparator<Student>c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return (o1.getName()).compareTo(o2.getName());

			}
			
		};
		students.sort(c);
		
		System.out.println(students.get(1).getMat());
		students.get(0).printInfo();
		
		for (Student student : students) {
			student.printInfo();
			System.out.println("---------------------");
		}
		Comparator<Student>c1 = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				Integer a=o1.getEng()+o1.getKor()+o1.getMat();
				Integer b=o2.getEng()+o2.getKor()+o2.getMat();
				return a.compareTo(b);

			}
			
		};
		students.sort(c1);
		students.get(0).printInfo();
	}
}
