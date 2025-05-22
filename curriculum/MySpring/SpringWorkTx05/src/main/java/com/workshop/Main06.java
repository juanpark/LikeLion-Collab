
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.TimeoutService;

public class Main06 {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(TimeoutService.class);
        service.slowProcess();
        ctx.close();
    }
}
