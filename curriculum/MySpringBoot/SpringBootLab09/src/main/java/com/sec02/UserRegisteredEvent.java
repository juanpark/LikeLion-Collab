package com.sec02;

//[1] event class
public class UserRegisteredEvent {
	private final String username;
	
	public UserRegisteredEvent(String username) {
		super();
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
}
