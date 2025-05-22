
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.LogService;

public class Main05 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(LogService.class);
        service.saveLog("로그 메시지 테스트");
        ctx.close();
    }
}
