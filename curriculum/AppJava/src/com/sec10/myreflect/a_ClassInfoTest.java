package com.sec10.myreflect;
import java.lang.reflect.Field;

// 클래스 객첼를 리플렉트 하고 조작 실행 해보자 
class My {
	private String name = "홍길동";
	private int a = 10;
}


public class a_ClassInfoTest {
		
	public static void main(String[] args) throws Exception { // not recommended throwing error but for studying purposes
		
		My m1 = new My();

		Class<?> clazz = m1.getClass();
		
		// 필드 정보 가져오기
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true); // private member accessible now
		
		// 필드 값 변경 
		field.set(m1, "정길동");
		
		System.out.println("변경된 값 : " + field.get(m1));
		
		System.out.println("===================");
		
		// 필드 정보 가져오기
		field = clazz.getDeclaredField("a");
		field.setAccessible(true); // private member accessible now
		
		// 필드 값 변경 
		field.setInt(m1, 20);	// for int
		
		System.out.println("변경된 값 : " + field.get(m1));

		

	}

}
