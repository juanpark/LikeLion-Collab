package com.sec01.Adapter;
public class TestAdapter {
    public static void main(String[] args) {
        Printer printer = new PrinterAdapter(new LegacyPrinter());
        printer.print("Hello, Adapter!");
    }
}
