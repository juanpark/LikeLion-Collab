package com.test02;

import org.springframework.stereotype.Component;

// 4. @Component 애노테이션을 사용하여 Spring Bean으로 등록

@Component
public class Nic_Name {

    @Override
    public String toString() {
        return "Nic_Name [중간이름]";
    }
}
