package org.aakash.spring.BeanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("org/aakash/spring/BeanScope/config.xml");
		Employee empl = (Employee) context.getBean("employee");
		System.out.println(empl.hashCode());
		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp.hashCode());
	}

}
