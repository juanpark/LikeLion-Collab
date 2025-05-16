package com.test03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 환경 설정 파일임. 
@ComponentScan("com.test03")  // com.test03 패키지 내 컴포넌트 스캔 -> 모든 bean 관련 @를 스캔하겠다. 
@PropertySource("classpath:/com/test03/a.properties")  // 프로퍼티 파일 등록
public class AppConfig {
}
