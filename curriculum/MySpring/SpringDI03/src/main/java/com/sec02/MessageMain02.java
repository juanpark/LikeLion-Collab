package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// bean 객체 관리함 
public class MessageMain02 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml");

		// "messagePrint" 빈의 타입 확인
		Class<?> messagePrintType = context.getType("messagePrint");
		System.out.println("messagePrint 빈의 타입: " + messagePrintType.getName());

		// 등록된 모든 빈 이름 확인
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("등록된 빈 이름:");
		for (String beanName : beanNames) {
		    System.out.println("- " + beanName);
		}

		// "messagePrint02" 빈이 싱글톤인지 확인
		boolean isSingleton = context.isSingleton("messagePrint02");
		System.out.println("messagePrint02 빈은 싱글톤인가요? " + isSingleton);

		// 특정 타입의 모든 빈 이름 조회 (MessagePrinter 타입)
		String[] messagePrinterBeans = context.getBeanNamesForType(MessagePrinter.class);
		System.out.println("MessagePrinter 타입의 빈 이름:");
		for (String beanName : messagePrinterBeans) {
		    System.out.println("- " + beanName);
		}
		
	}

}
