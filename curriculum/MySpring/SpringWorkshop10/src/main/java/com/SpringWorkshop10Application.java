package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = {"com.sec01", "com.sec02", "com.sec03"})
public class SpringWorkshop10Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWorkshop10Application.class, args);
	}

}
