package com.sec13.myio;

import java.io.Serializable;

public class Student implements Serializable{ // 해당 클래스를 byteStream으로 변환 -> 직렬화 
	private String 	name;
	private int 	age;
	private int		height;
	private int		weight;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return this.getName() + "   " + this.getAge()  + "  " + this.getHeight()  + "  " + this.getWeight();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	

}
