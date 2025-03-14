package work.com.workshop9.printmessage;

import java.lang.reflect.Method;

public class AnnotationProcessor {
	
	public static void main(String[] args) throws Exception {
		TestClass obj = new TestClass();
		for (Method method : obj.getClass().getDeclaredMethods()) {
			if (method.isAnnotationPresent(PrintMessage.class)) {
				method.invoke(obj); // 에노테이션이 붙은 메서드만 실행
			}
			
		}
	}
	
}
