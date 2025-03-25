package com.sec06;

import java.util.Objects;

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

	public U_Address() { // 기본 생성자 -> new U_Address();

	}

	public U_Address(String name) {
		super();
		this.name = name;
		this.addr = "Seoul";
		this.tel = "02-000-0000";
	}

	public U_Address(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the addr
	 */
	public String getAddr() {
		return addr;
	}

	/**
	 * @param addr the addr to set
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return String.format("U_Address [getName()=%s, getAddr()=%s, getTel()=%s]", getName(), getAddr(), getTel());
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
		U_Address other = (U_Address) obj;
		return Objects.equals(this.name, other.name);
	}

	
	public static void main(String[] args) {
		U_Address u1 = new U_Address("홍길동", "111", "111");
		U_Address u2 = new U_Address("길동", "222", "222");
		
		System.out.println("각 객체의 갑인 이름이 같은지 다른지 :" + u1.equals(u2));
		System.out.println(u1.hashCode());
	}
	 
}
