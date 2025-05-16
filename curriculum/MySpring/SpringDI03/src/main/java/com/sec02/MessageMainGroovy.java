package com.sec02;

import org.springframework.context.support.GenericGroovyApplicationContext;

public class MessageMainGroovy {
    public static void main(String[] args) {
        //.groovy 현재 버전에서 (ver.4 / spring ver.6 XX) import X
        GenericGroovyApplicationContext context = 
            new GenericGroovyApplicationContext("app02.groovy", "app02-2.groovy");

        MessagePrinter printer1 = context.getBean("messagePrint", MessagePrinter.class);
        printer1.print();

        MessagePrinter printer2 = context.getBean("messagePrint02", MessagePrinter.class);
        printer2.print();
    }
}
