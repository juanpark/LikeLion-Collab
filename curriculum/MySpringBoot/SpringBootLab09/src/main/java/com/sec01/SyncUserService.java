package com.sec01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

//[2] 서비스에서 이벤트 발생
@Service
public class SyncUserService { 
	//ApplicatoinEventPublisher를 주입받아 registerUser 메서드에 publishEvent()를 호출 

	@Autowired
	private ApplicationEventPublisher publisher;
	public void registerUser(String username) {
		publisher.publishEvent(new UserRegisteredEvent(username));
		System.out.println("사용자 등록 완료 (Sync)");
	}
}

