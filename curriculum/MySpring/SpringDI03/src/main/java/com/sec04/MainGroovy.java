package com.sec04;

import org.springframework.context.support.GenericGroovyApplicationContext;

public class MainGroovy {
	public static void main(String[] args) {
		GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("app04.groovy");
		MyCollection res = context.getBean("myCollection",MyCollection.class);
		res.printItems();
		res.printArray();
		res.printSet();
		res.printMap();
	}
}
