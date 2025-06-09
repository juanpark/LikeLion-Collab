package com.sec04;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

@Component
public class LifeCycleEventListener {
	
	@EventListener
	public void onStart(ContextRefreshedEvent event) {
		System.out.println("Application Started (ContextRefreshedEvent");
	}
	
	@EventListener
	public void onStop(ContextClosedEvent event) {
		System.out.println("Application Stopped (ContextClosedEvent");
	}
	
	@EventListener
	public void onReady(ApplicationReadyEvent event) {
		System.out.println("Application Reset (ApplicationReadyEvent)");
	}
	
	@EventListener
	public void onFailed(ApplicationFailedEvent event) {
		System.out.println("Application Load Failed (ApplicationFailedEvent)" + event.getException().getMessage());
	}
	
	@EventListener
	public void onRequest(RequestHandledEvent event) {
		//System.out.println("Request Handled (ReqeustHandledEvent)" + event.getFailureCause().getMessage());
		System.out.println("Request Handled (ReqeustHandledEvent)" + event.getClass().getTypeName());
	}
	
}
