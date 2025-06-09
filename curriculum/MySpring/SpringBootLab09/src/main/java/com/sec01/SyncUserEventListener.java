package com.sec01;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//[3] 이벤트 리스너
@Component
public class SyncUserEventListener {
	
	@EventListener
	public void handleUserRegistered(UserRegisteredEvent event) {
		//기타 코드 작성
		System.out.println("환영 메시지 전송 (Sync): " + event.getUsername());
	}
}

