package com.test01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMapperTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        EmpMapper mapper = ctx.getBean(EmpMapper.class);
        mapper.insertEmp("홍길동");
        mapper.selectAll().forEach(System.out::println);
    }
}