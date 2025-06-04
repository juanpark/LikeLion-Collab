package com.lab01;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, Https) throws Exception {
		System.out.println(">>> URL request: " + request.getRequestedSessionId())
	}
}
