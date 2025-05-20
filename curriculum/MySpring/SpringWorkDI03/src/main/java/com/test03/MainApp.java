package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("classpath:application.groovy");
        OrderService orderService = ctx.getBean(OrderService.class);
        System.out.println(orderService.order(1, 10000));
    }
}
