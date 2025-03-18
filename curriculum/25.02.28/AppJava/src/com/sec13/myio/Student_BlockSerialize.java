package com.sec13.myio;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Student_BlockSerialize implements Serializable{ // 해당 클래스를 byteStream으로 변환 -> 직렬화 
	private String 			name;
	public static int 		age;
	private int				height;
	private transient int	weight;
	
	public Student_BlockSerialize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student_BlockSerialize(String name, int age, int height, int weight) {
		super();
		this.name = name;
		Student_BlockSerialize.age = age; 
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return this.getName() + "   " + Student_BlockSerialize.age  + "  " + this.getHeight()  + "  " + this.getWeight();
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
