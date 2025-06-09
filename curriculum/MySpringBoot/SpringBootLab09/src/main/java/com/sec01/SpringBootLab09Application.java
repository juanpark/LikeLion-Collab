package com.sec01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sec06"})
public class SpringBootLab09Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLab09Application.class, args);
	}

}
