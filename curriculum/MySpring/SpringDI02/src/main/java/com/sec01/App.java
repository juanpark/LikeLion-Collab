package com.sec01;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec01.AddressInfo;
import com.sec01.MyAddress;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application05.xml");
		context.getBean("myaddress01");
		
	}
}