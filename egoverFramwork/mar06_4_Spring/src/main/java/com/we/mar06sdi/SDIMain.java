package com.we.mar06sdi;

public class SDIMain {

	public static void main(String[] args) {
		Dog d =  new Dog("뽀삐",1);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		System.out.println("---------------");
		Dog d2 = new Dog();
		d2.setName("뿌비");
		d2.setAge(3);
		System.out.println(d2.getName());
		System.out.println(d2.getAge());
	}

}
