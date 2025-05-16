package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import(App.class)
public class AppConfig {
	@Bean(name = {"AA","BB","DD"})
	@Lazy
	public MessagePrinter messagePrint(HelloMessage helloMessage) {
		return new MessagePrinter(helloMessage);
	}
	
	@Bean
	public MessagePrinter messagePrint02(MyMessage myMessage) {
		return new MessagePrinter(myMessage);
	}
	
	@Bean
	public Integer myResource02() {
		return 100;
	}
}
