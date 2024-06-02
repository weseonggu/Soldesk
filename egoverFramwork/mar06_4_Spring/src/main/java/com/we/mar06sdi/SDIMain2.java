package com.we.mar06sdi;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class SDIMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory dlbf = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xdbr = new XmlBeanDefinitionReader(dlbf);

		xdbr.loadBeanDefinitions(new ClassPathResource("dogBeans.xml"));
		//dogBeans.xml파일에  개를 만들어 놓고  그개를 불러옴 
		//처음 부를 때 객체를 만들기만 할뿐 (싱글턴 느낌)
		Dog d = (Dog) dlbf.getBean("d");
		System.out.println( d.getName());
		Dog dd = (Dog) dlbf.getBean("d");
		System.out.println( dd.getName());
	}

}
