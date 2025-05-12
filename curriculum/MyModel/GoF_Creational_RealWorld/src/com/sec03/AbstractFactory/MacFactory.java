package com.sec03.AbstractFactory;

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
}
