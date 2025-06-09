package com.sec05;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MySchedulerJob {
	
	//@Scheduled(fixedRate = 5000)
	@Scheduled(fixedDelay = 5000)
	public void runMyTime() {
		//System.out.println("In process..." + LocalDateTime.now());
		System.out.println("In process... [" + 
				Thread.currentThread().getName() + "]"
				+ LocalDateTime.now());
	}
}
