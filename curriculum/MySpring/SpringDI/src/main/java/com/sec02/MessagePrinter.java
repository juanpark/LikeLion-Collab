package com.sec02;

// 생성자 주입 클래스
public class MessagePrinter {
	private final Message message;

	public MessagePrinter(Message message) {
		super();
		this.message = message;
	}
	
	public void print() {
		System.out.println(message.getMessage());
	}

}
