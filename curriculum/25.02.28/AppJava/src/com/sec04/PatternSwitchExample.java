package com.sec04;
import java.util.Scanner;
		
/* 	switch (expression) {
 * 		case Integer i when i > 10 -> System.out.println("10보다 큰 정수");
 *  	case String s -> System.out.println("문자열: " + s);
 *  	case null -> System.out.println("Null 값이 입력됨");
 *  	default -> System.out.println("기타 값");
 * 	}
 */

public class PatternSwitchExample {
    public static void main(String[] args) {
        // JDK21 에서 기존과 달라진 문법 
    	// 1) : break를 화살표레이블 (->) 로 대체
    	// 2) 표현식을 간략하게 지정한다.
    	// 3) when문 사용 
    	// 4) null을 사용할 수 있다. 
    
    	
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.printf("Input: ");
    	Object obj = sc.next();
        switch (obj) {
            case Integer i when i > 10 -> System.out.println("10보다 큰 정수: " + i);
            case Integer i -> System.out.println("정수: " + i);
            case String s -> System.out.println("문자열: " + s);
            case null -> System.out.println("Null 값이 입력되었습니다.");
            default -> System.out.println("기타 값: " + obj);
        }
        sc.close();
    }
}

