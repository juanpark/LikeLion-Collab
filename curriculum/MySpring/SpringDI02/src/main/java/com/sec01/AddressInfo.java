package com.sec01;

public class AddressInfo {
	
	private MyAddress address;
	private int age;
	
	public void setAddress(MyAddress myaddress) {
		this.address = myaddress;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void prn() {
		System.out.println(address.toString());
		System.out.println(this.age);
	}
}
