package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext(
                new String[] { "appBeans02.xml" }
            );

        Nic_NamePrn prn = context.getBean("MyTest", Nic_NamePrn.class);
        System.out.println(prn);
    }
}
