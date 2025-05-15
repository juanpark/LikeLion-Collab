package com.sec05;

public class GreetManager {
    private GreetService service;
    public void setService(GreetService service) { this.service = service; }
    public void execute() { service.sayHello(); }
}