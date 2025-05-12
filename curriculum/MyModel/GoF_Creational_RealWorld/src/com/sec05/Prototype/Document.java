package com.sec05.Prototype;

// Cloneable = prototype interface
// Document = prototype class

public class Document implements Cloneable {
    private String content;

    public Document(String content) {
        this.content = content;
    }

    public void show() {
        System.out.println("Document: " + content);
    }
    
    @Override
    public Document clone() {
        return new Document(this.content); // shallow copy
    }
}
