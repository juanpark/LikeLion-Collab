
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.ReportService;

public class Main13 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(ReportService.class);
        service.completeReport();
        ctx.close();
    }
}
