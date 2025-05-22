
package com.workshop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.workshop.service.PostService;

public class Main11 {
    public static void main(String[] args) {
        var ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        var service = ctx.getBean(PostService.class);
        service.getPosts();
        ctx.close();
    }
}
