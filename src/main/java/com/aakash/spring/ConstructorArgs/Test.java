package com.aakash.spring.ConstructorArgs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/aakash/spring/ConstructorArgs/config.xml");
		Hospital hospital = (Hospital) context.getBean("hospital");
		System.out.println(hospital.getName());
		System.out.println(hospital.getDepartment());
		System.out.println(hospital.getDrName());
		System.out.println(hospital.getDocAddrs());
		System.out.println(hospital.toString());

	}

}
