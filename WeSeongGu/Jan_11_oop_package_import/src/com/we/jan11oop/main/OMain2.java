package com.we.jan11oop.main;
import com.we.jan11oop.product.Dog;
//패키지명 생략 가능 
//		자바 기본페키지 소속 (java.lang)
//		같은 패키지에 있으면 생략 가능
//		OMain2에서 Scanner는 무조건 내거 사용     java.util.Scanner 사용x
import com.we.jan11oop.product.Scanner;
// 이렇게 import했으면 무조건 내가 만든 scanner을 사용함
// 기존의 Scanner울 사용할려면 이렇게 적어야함 java.util.Scanner

// ctrl + shift + o import 정리해주는 단축 키 필요한거 필요없는거 정리 해줌
public class OMain2 {
	public static void main(String[] args) {
		Scanner sc1 =new Scanner();
		
		java.util.Scanner sc =new java.util.Scanner(System.in);
		Dog d =new Dog("후추",3);
//		d.age=2;// 오류 
		d.printInfo();
	}
}
