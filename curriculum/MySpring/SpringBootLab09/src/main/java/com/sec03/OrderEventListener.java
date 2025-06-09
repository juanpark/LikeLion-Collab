package com.sec03;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
	
	@Order(1)
	@EventListener(condition = "#event.productName.equals('MacBook')")
	public void handleMacBook(OrderCreatedEvent event) {
		System.out.println("[1]MacBook 주문 확인 알림 발송: " + event.getProductName());
	}
	
	@Order(2)
	@EventListener(condition = "#event.productName.equals('Keyboard')")
	public void handleKeyboard(OrderCreatedEvent event) {
		System.out.println("[2]Keyboard 주문 확인 알림 발송: " + event.getProductName());
	}
	
	@Order(3)
	@EventListener(condition = "#event.productName.equals('Notebook')")
	public void handleNotebook(OrderCreatedEvent event) {
		System.out.println("[3]Notebook 주문 확인 알림 발송: " + event.getProductName());
	}
	
	@Order(4)
	@EventListener(condition = "#event.email.endsWith('.com')")
	public void handleComUser(OrderCreatedEvent event) {
		System.out.println("[4] com 도메인 가입자: " + event.getEmail());
	}
	
	@Order(5)
	@EventListener(condition = "#event.email.endsWith('.co.kr')")
	public void handleCoKrUser(OrderCreatedEvent event) {
		System.out.println("[4] co.kr 도메인 가입자: " + event.getEmail());
	}
}
