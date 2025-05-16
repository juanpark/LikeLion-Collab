package com.person.view;

import java.io.IOException;
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

	public void saveToFile(List<Person> selectAllPerson, String file_name) {
		// TODO Auto-generated method stub
		try(java.io.FileWriter fw = new java.io.FileWriter(file_name)) {
			for(Person p : selectAllPerson ) {
				fw.write(p.getName() + "\t" + p.getAddress() + "\t" + p.getPhone() + "\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
