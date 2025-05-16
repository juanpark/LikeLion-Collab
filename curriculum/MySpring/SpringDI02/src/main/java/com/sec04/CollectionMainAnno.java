package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sec01.MyAddress;

public class CollectionMainAnno {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
		MyAddress res = (MyAddress) context.getBean("m01");
		System.out.println(res);
		
		res = (MyAddress) context.getBean("m02");
		System.out.println(res);

	}

}
