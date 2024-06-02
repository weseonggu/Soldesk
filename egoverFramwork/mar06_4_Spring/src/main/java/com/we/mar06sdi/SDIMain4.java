package com.we.mar06sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain4 {

	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans2.xml");

		aac.registerShutdownHook();

		System.out.println("--------------");
		Dog dd = aac.getBean("dog", Dog.class);
		System.out.println(dd.getName());
		System.out.println("--------------");

		Human h = aac.getBean("human", Human.class);
		System.out.println(h.getName());
		System.out.println(h.getPet().getName());
		System.out.println("--------------");
		for (String n : h.getNickname()) {
			System.out.println(n);
		}
		System.out.println("--------------");
		for(String n :h.getFriends()) {
			System.out.println(n);
		}
		System.out.println("--------------");
		System.out.println(h.getStats().get("키"));
		System.out.println(h.getStats().get("몸무게"));
		System.out.println("--------------");
		aac.close();
	}

}
