package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageMain {
	public static void main(String[] args) {
		// 프로젝트에서 리소스 path가 지정된 곳에 있는 xml 파일을 로드  
		ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml");
		
		MessagePrinter res = context.getBean("messagePrint", MessagePrinter.class);
		res.print();
		
	}
}
