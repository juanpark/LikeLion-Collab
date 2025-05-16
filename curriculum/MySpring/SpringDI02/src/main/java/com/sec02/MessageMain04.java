package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MessageMain04 {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml");

        // 클래스패스 리소스 접근
        Resource classpathResource = context.getResource("classpath:application02.xml");
        System.out.println("클래스패스 리소스 존재 여부: " + classpathResource.exists());
        if (classpathResource.exists()) {
            InputStream inputStream = classpathResource.getInputStream();
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("\n클래스패스 리소스 내용:\n" + content);
            inputStream.close();
        }

        // 파일 시스템 리소스 접근 (절대 경로 또는 상대 경로)
        // Resource fileSystemResource = context.getResource("file:/path/to/your/file.txt");
        // System.out.println("파일 시스템 리소스 존재 여부: " + fileSystemResource.exists());

        // URL 리소스 접근
        // Resource urlResource = context.getResource("url:https://www.google.com");
        // System.out.println("URL 리소스 존재 여부: " + urlResource.exists());
        // if (urlResource.exists()) {
        //     InputStream inputStream = urlResource.getInputStream();
        //     // URL 리소스 내용 읽기
        //     inputStream.close();
        // }

        // 빈으로 등록된 리소스 접근
        Integer myResourceBean = context.getBean("myResource02", Integer.class);
        System.out.println("\n빈으로 등록된 리소스: " + myResourceBean);
      /* if (myResourceBean.exists()) {
            InputStream inputStream = myResourceBean.getInputStream();
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            System.out.println("빈으로 등록된 리소스 내용: " + content);
            inputStream.close();
        }*/
    }
}