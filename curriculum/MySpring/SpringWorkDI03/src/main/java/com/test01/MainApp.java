package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderService orderService = ctx.getBean(OrderService.class);
        System.out.println(orderService.order(1, 10000));
    }
}
