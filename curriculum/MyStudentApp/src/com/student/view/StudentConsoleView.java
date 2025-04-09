package com.student.view;


import java.io.IOException;
import java.util.List;

import com.student.model.Student;

public class StudentConsoleView {
	
	// print all
	public void showAllList(List<Student> list) {
		
		System.out.printf("+------+-------------+----------------+--------+%n");
		System.out.printf("| %-4s | %-11s | %-14s | %-6s |%n", "ID", "Name", "Major", "Grade");
		System.out.printf("+------+-------------+----------------+--------+%n");
		for (Student s : list) {
			System.out.printf("| %-4d | %-11s | %-14s | %-6d |%n",
			        s.getstdId(),
			        s.getName(),
			        s.getMajor(),
			        s.getGrade());
		}
		System.out.printf("+------+-------------+----------------+--------+%n");
	}
	
	// print message
	public void showMessage(String message) {
		System.out.println("[알림] " + message);
	}
	
	public void saveToFile(List<Student> selectAllStudent, String file_name) {
		// TODO Auto-generated method stub
		try(java.io.FileWriter fw = new java.io.FileWriter(file_name)) {
			fw.write(String.format("+------+-------------+----------------+--------+%n"));
			fw.write(String.format("| %-4s | %-11s | %-14s | %-6s |%n", "ID", "Name", "Major", "Grade"));
			fw.write(String.format("+------+-------------+----------------+--------+%n"));
			for(Student s : selectAllStudent ) {
				fw.write(String.format("| %-4d | %-11s | %-14s | %-6d |%n",
				        s.getstdId(),
				        s.getName(),
				        s.getMajor(),
				        s.getGrade()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
