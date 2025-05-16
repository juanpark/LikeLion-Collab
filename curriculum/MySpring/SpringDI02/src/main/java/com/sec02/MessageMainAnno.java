package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageMainAnno {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MessagePrinter res = context.getBean("AA",MessagePrinter.class);
		res.print();
		
		res = context.getBean("BB",MessagePrinter.class);
		res.print();
		
		res = context.getBean("DD",MessagePrinter.class);
		res.print();
		
		res = context.getBean("messagePrint02",MessagePrinter.class);
		res.print();
		
		Integer num = context.getBean("myResource02",Integer.class);
		System.out.println(num);
	}
}
