package com.sec06;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {  

	@Async
	public void processAsync(String name) {
		System.out.println("Processing Async: "
			+ name
			+ " (" + Thread.currentThread().getName() + ")");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println("Completed Aync Process: " + name);
	}
}

