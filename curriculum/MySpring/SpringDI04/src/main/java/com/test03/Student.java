package com.test03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("${myname}")
    private String name;

    @Value("${myaddr}")
    private String address;

    @Value("${myage}")
    private int age;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
    }
}
