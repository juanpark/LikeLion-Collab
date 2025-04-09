package com.person.view;

import java.util.List;

import com.person.model.Person;

public class PersonConsoleView {
	
	// 전체 출력
	public void showAllList(List<Person> list) {
		 
		for (Person p : list) {
			System.out.println(p.getName() + "\t" + p.getAddress() + "\t" + p.getPhone());
		}
	}
	
	// 알림 메시지
	public void showMessage(String message) {
		System.out.println(" [알림] " + message);
	}
}
