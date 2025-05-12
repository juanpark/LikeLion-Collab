package com.sec01.Singleton;

import java.io.IOException;
import java.util.logging.*;

public class TestSingleton2 {
    public static void main(String[] args) {
    	// new 연산자를 사용하지 않고 객체가 정적으로 생성한 메서드를 호출 
        
    	Runtime run = Runtime.getRuntime();
    	try {
			run.exec("open -a Notes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        LogManager res = LogManager.getLogManager();
        java.util.logging.Logger res_Logger = res.getLogger("com.sec01.Singleton.Logger");
        System.out.println(res_Logger);
    }
}
