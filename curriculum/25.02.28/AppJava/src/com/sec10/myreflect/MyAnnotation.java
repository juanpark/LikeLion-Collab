package com.sec10.myreflect;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 런타임에도 유지됨
@Target(ElementType.METHOD) // 메서드에 적용 가능
public @interface MyAnnotation {
}
