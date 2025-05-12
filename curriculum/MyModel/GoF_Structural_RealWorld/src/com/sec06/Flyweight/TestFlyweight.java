package com.sec06.Flyweight;
public class TestFlyweight {
    public static void main(String[] args) {
        Font a = FontFactory.getFont("Arial");
        Font b = FontFactory.getFont("Arial");
        a.use();
        b.use();
        System.out.println("Same instance: " + (a == b));
    }
}
