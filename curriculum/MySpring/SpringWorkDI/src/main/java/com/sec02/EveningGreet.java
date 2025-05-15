package com.sec02;
import com.sec01.*;

public class EveningGreet implements Greet {
    public String greeting() {
        return "편안한 저녁입니다.";
    }
    
    
    // 생명주기 확인을 위한 메서드 추가 
    public void init() {
    	System.out.println("초기화");
    }
    
    public void doJob() {
    	System.out.println("Bean 수행중 ");
    }
    
    public void destroy() {
    	System.out.println("소멸");
    }
}