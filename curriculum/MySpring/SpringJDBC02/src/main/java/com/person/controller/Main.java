package com.person.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonController controller = context.getBean(PersonController.class);
		controller.run();
		((AbstractApplicationContext) context).close();
	}
}
