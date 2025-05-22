
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.MyService;

public class Main03 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(MyService.class);
        service.outer();
        ctx.close();
    }
}
