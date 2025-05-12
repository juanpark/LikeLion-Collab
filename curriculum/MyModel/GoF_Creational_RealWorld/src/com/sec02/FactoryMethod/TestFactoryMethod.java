package com.sec02.FactoryMethod;

// factory pattern : java.lang.NumberFormat, java.text.DateFormat, java.util.Locale,
// java.nio.Paths -> get() / java.net.URI.create() / java.sql.DriverManager.getConnect()
public class TestFactoryMethod {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("pdf");
        doc.open();
    }
}
