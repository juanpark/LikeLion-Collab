package com.student.model;

public class Student {
	private int stdId;
	private String name;
	private String major; 
	private int grade;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int stdId, String name, String major, int grade) {
		super();
		this.stdId = stdId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	
	// stdId는 자동으로 증가하기에 이 부분을 뺀 생성자
	public Student(String name, String major, int grade) {
		super();
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	public int getstdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	
	
}
