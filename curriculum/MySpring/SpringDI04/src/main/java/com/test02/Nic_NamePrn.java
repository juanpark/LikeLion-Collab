package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyTest") // 이 클래스는 Spring Bean으로 등록되며, 이름은 "MyTest"
public class Nic_NamePrn {

    @Autowired(required=true) // Nic_Name 타입의 Bean을 자동으로 주입 (byType)
    Nic_Name nic_name;

    @Override
    public String toString() {
        return "Nic_NamePrn [nic_name=" + nic_name + "]";
    }
}
