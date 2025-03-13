package com.sec10.myreflect.custom;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToCalcHelper {

	public static String toString(Object obj) {
		StringBuffer buffer = new StringBuffer();  // 문자열을 담겠다.
		try {
			Class clazz = obj.getClass(); // Calc.class
			int[] num = new int[clazz.getDeclaredFields().length];  // int[] num = new int[2];
			int i = 0;
			
			// field get method로 만들어서 실행 하곘다. 
			for (Field field : clazz.getDeclaredFields()){ // 필드들을 배열로 리턴 
				String fieldName = field.getName().toString();  // 필드의 이름 리턴 
				fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1); // getA
				Method method = clazz.getMethod(fieldName); // getA()
				Object value = method.invoke(obj);
				num[i] = (int) value;
				i++;
			}
			// 해당 어노테이션이 선언되어 있는 메서드를 찾아서 실행 유무를 판단하는 곳  
			for (Method method : clazz.getDeclaredMethods()) {
				NotMyNo nmn = method.getAnnotation(NotMyNo.class); // 해당 어노테이션 객체로 리턴 
				if (nmn == null) {
					if(method.getName().length() == 6){
						Object value = method.invoke(obj, num[0], num[1]);
						buffer.append(method.getName().substring(3)).append(" = ").append(value).append("\n");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

}
