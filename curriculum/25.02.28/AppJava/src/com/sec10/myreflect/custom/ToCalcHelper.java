package com.sec10.myreflect.custom;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ToCalcHelper {

	public static String toString(Object obj) {
		StringBuffer buffer = new StringBuffer();
		try {
			Class clazz = obj.getClass();
			int[] num = new int[clazz.getDeclaredFields().length];
			int i = 0;
			for (Field field : clazz.getDeclaredFields()){
				String fieldName = field.getName().toString();
				fieldName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				Method method = clazz.getMethod(fieldName);
				Object value = method.invoke(obj);
				num[i] = (int) value;
				i++;
			}
			for (Method method : clazz.getDeclaredMethods()) {
				NotMyNo nmn = method.getAnnotation(NotMyNo.class);
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
