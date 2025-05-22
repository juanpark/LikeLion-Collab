
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.MemberQueryService;

public class Main02 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(MemberQueryService.class);
        service.getMemberById(1L);
        ctx.close();
    }
}
