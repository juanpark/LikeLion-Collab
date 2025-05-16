package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

public class MessageMain03 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application02.xml");
        Environment environment = context.getEnvironment();

        // 시스템 속성 접근
        String osName = environment.getProperty("os.name");
        System.out.println("운영체제 이름: " + osName);

        // 환경 변수 접근
        String javaHome = environment.getProperty("JAVA_HOME");
        System.out.println("JAVA_HOME 환경 변수: " + javaHome);

        // 프로파일 정보 접근 (application.properties 또는 application-{profile}.properties 필요)
        // 현재 설정된 프로파일이 있다면 해당 값을 읽어올 수 있습니다.
        // 예시: environment.getProperty("myapp.config.value");

        // 활성화된 프로파일 확인
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("\n활성화된 프로파일:");
        if (activeProfiles.length > 0) {
            for (String profile : activeProfiles) {
                System.out.println("- " + profile);
            }
        } else {
            System.out.println("활성화된 프로파일이 없습니다.");
        }
    }
}