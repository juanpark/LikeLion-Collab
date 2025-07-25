package com.sec02;

// 생성자 주입 클래스 
public class MessagePrinter {
	
	private final Message message; // 1. 추상 선언 

	public MessagePrinter(Message message) {  //2. 주소대입 
		super();
		this.message = message;
	}
	
	public void print() {
		System.out.println(message.getMessage()); // 3. 대입된 주소의 객체 
	} 
	
}
