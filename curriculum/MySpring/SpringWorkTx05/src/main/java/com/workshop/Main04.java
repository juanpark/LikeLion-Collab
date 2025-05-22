
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.OrderService;

public class Main04 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(OrderService.class);
        try {
            service.orderItem(101L);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        ctx.close();
    }
}
