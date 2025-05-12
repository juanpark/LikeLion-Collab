package com.sec04.Decorator;

// SlackDecorator 클래스가 Notifier 인터페이스를 구현하고 생성자로 Notifier를 받아서 처리
public class DiscordDecorator implements Notifier {
    
	private final Notifier wrappee;
    
	// Decorator 패턴
	public DiscordDecorator(Notifier wrappee) { 
		this.wrappee = wrappee; 
	}
    
	public void send() {
        wrappee.send();
        System.out.println("Also sending via Discord");
    }
}
