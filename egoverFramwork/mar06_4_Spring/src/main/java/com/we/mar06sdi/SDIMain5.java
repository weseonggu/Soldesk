package com.we.mar06sdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SDIMain5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("beans3.xml");

		aac.registerShutdownHook();
		
		Gejang g =aac.getBean("g",Gejang.class);
		System.err.println(g.getProducer().getName());
		System.err.println(g.getProducer().getAge());
		
		aac.close();
	}

}
