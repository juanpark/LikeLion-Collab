package com.sec03;

/*
 * MyAddress
 * name,	addr,	tel
 * 	이름		주소		전화번호 
 * -----------------------------
 * 	홍길동	서울		02	-000-0000	a1
 * 	정길동	인천		031	-000-0000	b1
 * 	최길동	부산		051	-000-0000	c1
 * 
 */

class U_Address {
	private String name;
	private String addr;
	private String tel;
	
	// member method name
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	// member method addr
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr() {
		return addr;
	}
	
	// member method tel
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;
	}
	
	// create method to print
	public void Prn() {
		System.out.printf("%10s %10s %10s\n", this.getName(), this.getAddr(), this.getTel());
	}
	
	// 재정의 : 상속 시 선조가 가진 메소드를 그대로 정의하고 내용만 다시 정의하는 것
	// 원래 선조의 toString()은 주소를 프린트
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%10s %10s %10s\n", this.getName(), this.getAddr(), this.getTel());
	}
	public static void main(String[] args) {
		U_Address a1 = new U_Address();
		U_Address b1 = new U_Address();
		// a1.Prn();
		// b1.Prn();
		
		System.out.println(a1); //a1.toString()
		System.out.println(b1); //b1.to.String()
	}
}

