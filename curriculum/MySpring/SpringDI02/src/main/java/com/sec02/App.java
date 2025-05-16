package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
	
	@Bean
	public HelloMessage hellomessage() {
		return new HelloMessage();
	}
	
	@Bean
	public MyMessage mymessage() {
		return new MyMessage();
	}
}
