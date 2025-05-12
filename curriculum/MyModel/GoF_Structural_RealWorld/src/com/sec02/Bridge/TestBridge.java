package com.sec02.Bridge;
public class TestBridge {
    public static void main(String[] args) {
        Message message = new UserMessage(new EmailSender());
        message.send("Bridge Pattern");
    }
}
