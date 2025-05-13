package com.sec01.ChainOfResponsibility;

/*
 * 	사용자가 페이지 요청을 하게 되면 가로채기해서 doFilter()가 실행된다. 
  	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
    chain.doFilter(request, response); 
    // 페이지 인코딩, 단계별 보안인증 
    }
 */

abstract class Handler {
    protected Handler next;
    public void setNext(Handler next) { this.next = next; } // 체인 구성 담당
    public abstract void handle(int level);
}

class LowLevelHandler extends Handler {
    public void handle(int level) {
        if (level <= 1) System.out.println("Handled by LowLevel");
        else if (next != null) next.handle(level); // 다음 핸들러에게 요청 전달
    }
}

class HighLevelHandler extends Handler {
    public void handle(int level) {
        if (level <= 2) System.out.println("Handled by HighLevel");
        else System.out.println("Request too high");
    }
}

public class TestChainOfResponsibility {
    public static void main(String[] args) {
    	// 체인 실행
        Handler h1 = new LowLevelHandler();
        Handler h2 = new HighLevelHandler();
        h1.setNext(h2);
        h1.handle(2);
    }
}
