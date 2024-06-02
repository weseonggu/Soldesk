package com.we.mar06sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain3 {

	public static void main(String[] args) {
		//dlbf 방식 : 객체를 처음 사용 할 때 생성
		//aac방식 : .xml파일을 로드하는순간 파일을 모든 생성자를 다 만들어 옴
		// 			기존의 가비지콜랙션이 안먹힘
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("dogBeans.xml");
		
		aac.registerShutdownHook();// aac가 없어질때 만들어 놨던 객체들도 메모리에서 같이 없어 지도록 함
		
		System.out.println("--------------");
		Dog dd = aac.getBean("d", Dog.class);
		System.out.println(dd.getName());
		
		Dog dd2 = aac.getBean("d2", Dog.class);
		System.out.println(dd2.getName());
		
		aac.close();// aac 없애기 -> 개도 없어질 것
	}

}
