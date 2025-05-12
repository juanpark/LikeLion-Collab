package com.sec04.Decorator;

// SlackDecorator 클래스가 Notifier 인터페이스를 구현하고 생성자로 Notifier를 받아서 처리
public class SlackDecorator implements Notifier {
    
	private final Notifier wrappee;
    
	// Decorator 패턴
	public SlackDecorator(Notifier wrappee) { 
		this.wrappee = wrappee; 
	}
    
	public void send() {
        wrappee.send();
        System.out.println("Also sending via Slack");
    }
}
