package com.sec01.Singleton;

public class Logger {

	// 1. 생성자 private
	private static Logger instance = new Logger();
    private Logger() {}

    // 2. 한번 생성된 객체를 public static으로 리턴 
    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
