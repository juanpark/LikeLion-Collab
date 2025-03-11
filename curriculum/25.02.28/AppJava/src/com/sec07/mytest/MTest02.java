package com.sec07.mytest;

public class MTest02 {

	public static void main(String[] args) {
		
		// 객체를 생성할 때 초기값 전달 후 연산 결과 리턴
		// AA : a, b, getHap(a + b)
		// BB : c, getRes(getHap() - c)					
		// DD : d, @Overriding getRes(super() * d)
		
		DD d1 = new DD(100, 50, 2, 7);
		System.out.println((d1.getRes()));

	}

}
