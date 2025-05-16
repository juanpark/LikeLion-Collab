package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class AppGroovy {
    public static void main(String[] args) {
        ApplicationContext context = new GenericGroovyApplicationContext("app01.groovy");

        MyAddress addr = context.getBean("myaddress", MyAddress.class);
        System.out.println(addr);
    }
}
