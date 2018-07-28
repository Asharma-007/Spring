package org.aakash.spring.DdependencyCheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("org/aakash/spring/DdependencyCheck/config.xml");
		Prescription hospital = (Prescription) context.getBean("prescription");
		System.out.println(hospital.getId());

	}

}
