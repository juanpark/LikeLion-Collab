package com.sec01;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	/*
	 *  <bean id="myaddress" class="com.sec01.MyAddress">
        <constructor-arg value="박길동"/>
    </bean
    */
	@Bean
	public MyAddress myaddress() {
		return new MyAddress("kyuhwan");
	}
	
	@Bean
	public MyAddress myaddress02() {
		return new MyAddress("kyuhwan","ilsan");
	}
	
	@Bean
	public MyAddress myaddress03() {
		return new MyAddress("kyuhwan","ilsan","010-123-4123");
	}
	
	@Bean AddressInfo info() {
		AddressInfo info = new AddressInfo();
		info.setAddress(myaddress03());
		info.setAge(30);
		return info;
	}
	
}
