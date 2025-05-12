package com.sec01.Adapter;
public class PrinterAdapter implements Printer {
    private final LegacyPrinter legacy;

    public PrinterAdapter(LegacyPrinter legacy) {
        this.legacy = legacy;
    }

    public void print(String message) {
        legacy.oldPrint(message);
    }
}
