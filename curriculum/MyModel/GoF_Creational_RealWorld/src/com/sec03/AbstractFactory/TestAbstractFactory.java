package com.sec03.AbstractFactory;

public class TestAbstractFactory {
    public static void main(String[] args) {
        GUIFactory factory = new WindowsFactory();
        Button button = factory.createButton();
        button.render();
    }
}
