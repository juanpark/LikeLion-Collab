package com.sec11.myutil;

public class ProFile<T> {	
	private String name;
	private T dept;
	
	public ProFile(String name, T dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getDept() {
		return dept;
	}
	public void setDept(T dept) {
		this.dept = dept;
	}	
}
