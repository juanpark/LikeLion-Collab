package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec01.MyAddress;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application01.xml");
        MyAddress address = (MyAddress) context.getBean("myaddress02");
        System.out.println(address);
    }
}
