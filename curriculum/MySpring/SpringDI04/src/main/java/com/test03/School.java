package com.test03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {

    @Autowired
    private Student student;

    public void prnInfo() {
        System.out.println("== Student Info ==");
        System.out.println(student);
    }
}
