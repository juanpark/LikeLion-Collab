
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.MemberService;

public class Main01 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(MemberService.class);
        service.register("홍길동", "hong@test.com");
        ctx.close();
    }
}
