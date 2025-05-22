
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.AuditService;
import com.workshop.vo.AuditLog;

public class Main12 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(AuditService.class);
        service.saveAudit(new AuditLog("테스트 감사 로그"));
        ctx.close();
    }
}
