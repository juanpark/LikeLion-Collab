
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.ExceptionService;

public class Main07 {
    public static void main(String[] args) throws Exception {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(ExceptionService.class);
        service.test();
        ctx.close();
    }
}
