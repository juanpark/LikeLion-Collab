package com.sec04.Builder;

// 복잡한 객체의 생성과정을 단계별로 분리하다. -> 객체 생성을 여러 개로 나누었다.
// 빌더 객체 생성 -> 빌더의 메서드를 호출 -> 메서드 체이닝 -> .build()라는 메서드로 최종 객체를 리턴 받는다.
public class TestBuilder {
    public static void main(String[] args) {
        Report report = new ReportBuilder()
            .setHeader("=== Report ===")
            .setBody("Data goes here")
            .setFooter("End of Report")
            .build();
        report.print();
        
        // String, StringBuffer .append("ab").append("b").toString(), StringBuilder 등
        System.out.println(new StringBuffer().append("abc").append("ddd").toString());
    }
}
