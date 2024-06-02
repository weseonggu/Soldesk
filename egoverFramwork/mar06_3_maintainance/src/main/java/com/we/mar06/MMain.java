package com.we.mar06;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class MMain {
// Spring : POJO (plain old java object)
//			IoC로 DI해주는 Framwork

// 			IoC(Inversion of Control): 제어권의 역전
//				기존 제어흐름: 프로그램 -제어->파일
//				IoC 제어흐름: 파일 -제어-> 프로그렘
//				DI(Dependency Injection) : 의존성 주입
//					객체 만들고, 값넣고 를 java파일이 아닌 일반  파일에하는거
//					일반 자바 파일은  scr/main/java에 넣고
//					객체는 scr/main/resourses에 객체를 만들어서 불러옴
	public static void main(String[] args) {
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xdbr = new XmlBeanDefinitionReader(dlbf);

		xdbr.loadBeanDefinitions(new ClassPathResource("aaaa.xml"));

		Veihicle vvv = (Veihicle) dlbf.getBean("v");
		// Veihicle vvv = dlbf.getBean("v",Veihicle.class); // 이방식도 됨
		vvv.go();
	}

}
