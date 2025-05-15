package com.sec02;
import com.sec01.*;

public class LunchGreet implements Greet {
    public String greeting() {
        return "재미난 점심이야!";
    }
    
    
    // 생명주기 확인을 위한 메서드 추가 
    public void init() {
    	System.out.println("초기화 " + getClass().getName());
    }
    
    public void doJob() {
    	System.out.println("Bean 수행중 " + getClass().getName());
    }
    
    public void destroy() {
    	System.out.println("소멸 "  + getClass().getName());
    }
}