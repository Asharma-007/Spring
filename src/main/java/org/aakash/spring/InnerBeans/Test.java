package org.aakash.spring.InnerBeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("org/aakash/spring/InnerBeans/config.xml");
		Employee empl = (Employee) context.getBean("employee");
		System.out.println(empl.getAddress().getHouseNo());

	}

}
