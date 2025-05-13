package com.sec11.Visitor;

interface Visitor {
    void visit(Book book);
}

interface Element {
    void accept(Visitor visitor);
}

class Book implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class PriceVisitor implements Visitor {
    public void visit(Book book) {
        System.out.println("Book costs $10");
    }
}

public class TestVisitor {
    public static void main(String[] args) {
        Book book = new Book();
        Visitor visitor = new PriceVisitor();
        book.accept(visitor);
    }
}
