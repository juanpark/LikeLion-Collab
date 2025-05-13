package com.sec03.Interpreter;

// 검색 필터, 계산 수식 등을 구현할 때 사용하는 패턴 

// 1. 해석이 가능한 표현식을 가진 기본 인터페이스 
interface Expression {
    boolean interpret(String context);
}

// 2. 구체 클래스에서 표현식을 만든다 
class TerminalExpression implements Expression {
    private String data;
    public TerminalExpression(String data) { this.data = data; }
    public boolean interpret(String context) { // 문자열이 포함된 유무를 판단 하는 로직을 설계 
        return context.contains(data);
    }
}

public class TestInterpreter {
    public static void main(String[] args) {
        Expression isJava = new TerminalExpression("Java");
        System.out.println("Is Java? " + isJava.interpret("Java Developer"));
    }
}
