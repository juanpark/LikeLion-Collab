package com.sec04.Decorator;
public class BaseNotifier implements Notifier {
    public void send() {
        System.out.println("Sending base notification");
    }
}
