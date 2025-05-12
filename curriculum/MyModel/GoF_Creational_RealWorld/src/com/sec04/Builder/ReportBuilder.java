package com.sec04.Builder;

public class ReportBuilder {
    private String header;
    private String body;
    private String footer;

    public ReportBuilder setHeader(String header) {
        this.header = header;
        return this;
    }

    public ReportBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public ReportBuilder setFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public Report build() {
        return new Report(header, body, footer);
    }
}
