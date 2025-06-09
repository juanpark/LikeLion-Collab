package com.sec03;

//[1] event class
public class OrderCreatedEvent {
	private final String productName;
	private final String email;
	public OrderCreatedEvent(String productName, String email) {
		this.productName = productName;
		this.email = email;
	}
	public String getProductName() {
		return productName;
	}
	public String getEmail() {
		return email;
	}
	
	
}
