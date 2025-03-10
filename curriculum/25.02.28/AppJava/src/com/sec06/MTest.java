package com.sec06;

// Address (String name, String addr, String tel), getter, toString(), equals(), hashcode()
// record는 불변객체이다 
record Address (String name, String addr, String tel) {}

public class MTest {

	public static void main(String[] args) {
		Address a1 = new Address("홍길","서울","02-000");
		Address a2 = new Address("홍길","서울","02-000");
		System.out.println(a1 + "\n" + a2);
		System.out.println(a1.equals(a2));

	}

}
