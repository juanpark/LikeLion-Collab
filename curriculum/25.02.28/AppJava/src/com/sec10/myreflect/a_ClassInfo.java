package com.sec10.myreflect;

import java.lang.reflect.Field;

public class a_ClassInfo {
	public static void main(String[] args) {
		Integer number = 42;
		printClassInfo(number);
	}

	public static void printClassInfo(Object obj) {
		Class<?> clazz = obj.getClass(); // 객체의 클래스 정보
		System.out.println("클래스 이름: " + clazz.getName());

		// 필드 정보 출력
		System.out.println("\n[필드 정보]");
		for (Field field : clazz.getDeclaredFields()) {
			System.out.println(" - " + field);
		}
	}
}
