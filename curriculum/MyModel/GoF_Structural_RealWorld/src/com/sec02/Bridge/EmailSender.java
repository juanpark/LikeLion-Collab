package com.sec02.Bridge;
public class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
