package com.sec02.FactoryMethod;

// 객체 생성 로직을 클라이언트 코드로부터 분리하는것
// 공장에서 요청에 따라 특정 제품을 만들어 주듯이, 클라이언트가 직접 객체를 생성한느 대신 팩토리 객체생성 위임
public class DocumentFactory {
    public static Document createDocument(String type) {
        return switch (type) {
            case "pdf" -> new PdfDocument();
            case "word" -> new WordDocument();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
