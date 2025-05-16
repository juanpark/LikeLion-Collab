package com.sec01;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec01.AddressInfo;
import com.sec01.MyAddress;

public class AppAnnoMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MyAddress res = (MyAddress) context.getBean("myaddress"); // context.getBean("myaddress", MyAddress.class);
		System.out.println(res);
		System.out.println(res.toString());

		res = context.getBean("myaddress02", MyAddress.class); // context.getBean("myaddress", MyAddress.class);
		System.out.println(res);
		System.out.println(res.toString());

		
		 AddressInfo res02 = context.getBean("info", AddressInfo.class); 
		 context.getBean("myaddress", MyAddress.class); System.out.println(res02);
		 res02.prn();
		
		
		
	}
}