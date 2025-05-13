package com.sec01;


public class MyAddress {
	
	private String name;
	private String addr;
	private String tel;
	
	public MyAddress() {
		this("홍길동", "서울시", "000-000-0000");
	}

	public MyAddress(String name) {
		this(name, "부산시", "11-22-0000");
	}
	
	public MyAddress(String name, String addr) {
		this(name, addr, "11-22-0000");
	}
	
	public MyAddress(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "MyAddress [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
}
