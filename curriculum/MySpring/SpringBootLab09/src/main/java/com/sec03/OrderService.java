package com.sec03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

//[2] 서비스에서 이벤트 발생
@Service
public class OrderService { 
	//ApplicatoinEventPublisher를 주입받아 registerUser 메서드에 publishEvent()를 호출 

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void createOrder(String productName, String email) {
		publisher.publishEvent(new OrderCreatedEvent(productName, email));
		System.out.println("주문 완료 처리 중...");
	}
}

