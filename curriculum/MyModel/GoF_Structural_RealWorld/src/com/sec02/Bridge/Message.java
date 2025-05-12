package com.sec02.Bridge;
// 브릿지 패턴에서 추상영역은 추상클래스로 선언 후 인터페이스를 has~a 관계로 설계 
public abstract class Message {
    protected MessageSender sender;
    protected Message(MessageSender sender) {
        this.sender = sender;
    }
    public abstract void send(String text);
}
