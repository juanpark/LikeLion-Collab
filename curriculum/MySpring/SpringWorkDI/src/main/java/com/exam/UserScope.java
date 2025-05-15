package com.exam;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

// 사용자 정의 스코프를 만들어서 생성해보자. 
// ThreadLocal를 이용하여 각 스레드의 사용자별로 고유한 인스턴스를 유지하는 userScope를 만들어 보자.

public class UserScope implements Scope {

	private final ThreadLocal<Map<String, Object>> userScope = ThreadLocal.withInitial(HashMap::new);
	
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		// 사용자별 스코프 정보 리턴
		Map<String, Object> scope = userScope.get();
		return scope.computeIfAbsent(name,  k -> objectFactory.getObject());
	}

	@Override
	public Object remove(String name) {
		// 사용자별 스코프 삭제 
		Map<String, Object> scope = userScope.get();
		return scope.remove(name);
	}

	@Override
	public String getConversationId() {
		return Thread.currentThread().getName();
	}
	
	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object resolveContextualObject(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
