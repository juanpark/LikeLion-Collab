package com.sec04.Builder;

public class Report {
    private final String header;
    private final String body;
    private final String footer;

    public Report(String header, String body, String footer) {
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public void print() {
        System.out.println(header);
        System.out.println(body);
        System.out.println(footer);
    }
}
