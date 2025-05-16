package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class CollectionMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application04.xml");
		MyCollection res = context.getBean("myCollection",MyCollection.class);
		res.printItems();
		res.printArray();
		res.printSet();
		res.printMap();
	}
}
