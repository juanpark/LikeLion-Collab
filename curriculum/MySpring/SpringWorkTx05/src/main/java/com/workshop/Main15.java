
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.PaymentService;
import com.workshop.vo.Order;

public class Main15 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(PaymentService.class);
        service.processPayment(new Order("A001"));
        ctx.close();
    }
}
