package com.sec02.FactoryMethod;

public class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}
