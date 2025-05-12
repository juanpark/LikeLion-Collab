package com.sec05.Prototype;

public class TestPrototype {
    public static void main(String[] args) {
        Document original = new Document("Original");
        Document copy = original.clone();
        original.show();
        copy.show();
    }
}
