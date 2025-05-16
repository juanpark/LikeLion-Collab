package com.person.controller;
import com.person.config.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.*;


public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonController controller = context.getBean(PersonController.class);
		
		controller.run();
		
		((AbstractApplicationContext) context).close();
	}
}
