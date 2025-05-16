package com.test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test02.Nic_Name;

@Component("MyTest") // 이 클래스는 Spring Bean으로 등록되며, 이름은 "MyTest"
public class Nic_NamePrn {

    @Autowired // Nic_Name 타입의 Bean을 자동으로 필드 주입 (byType)
    Nic_Name nic_name;

    /* 자동으로 세터 만듦 
     * public void setNic_name(Nic_Name nic_name) {
		this.nic_name = nic_name;
	}
     * */
    
    @Override
    public String toString() {
        return "Nic_NamePrn [nic_name=" + nic_name + "]";
    }
}
