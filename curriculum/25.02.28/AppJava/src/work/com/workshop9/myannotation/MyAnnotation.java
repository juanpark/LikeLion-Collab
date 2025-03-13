package work.com.workshop9.myannotation;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // 런타임까지 유지
@interface MyAnnotation {
	String value() default "기본값";	// 기본값을 설정할 수 있는 속성
}

