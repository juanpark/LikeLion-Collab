package com.sec03.AbstractFactory;

public class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
}
