package work.com.workshop9.maxvalue;

import java.lang.reflect.*;

public class MaxValueProcessor {

	public static void main(String[] args) throws Exception {
		
		NumberClass obj = new NumberClass(120); // 100을 초과하는 값
			
		for (Field field : obj.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(MaxValue.class)) {
				MaxValue annotation = field.getAnnotation(MaxValue.class);
				int maxValue = annotation.value();
				int fieldValue = field.getInt(obj);
				
				if (fieldValue > maxValue) {
					System.out.println(field.getName() + " 값이 최대값을 초과했습니다! (최대: " + maxValue + ")");
				}
			}
		}
		

	}

}
