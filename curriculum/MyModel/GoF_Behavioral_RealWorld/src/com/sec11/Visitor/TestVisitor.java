package com.sec11.Visitor;

// 방문자 클래스 : Book 구입하러 갈 때 실행되는 동작을 정의 
interface Visitor {
    void visit(Book book);
}

// 사용자 패턴 
interface Element {
    void accept(Visitor visitor);
}

class Book implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this); // Visitor가 Book에 대한 작업을 원할하게 할 수 있도록 작동
    }
}

class PriceVisitor implements Visitor {
    public void visit(Book book) {
        System.out.println("Book costs $10");
    }
}

public class TestVisitor {
    public static void main(String[] args) {
        Book book = new Book();	// 대상
        Visitor visitor = new PriceVisitor(); // 방문자
        book.accept(visitor); // 수행
    }
}
