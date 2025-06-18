package com.lab10.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    @Id
    private Integer empno;
    private String ename;
    private String job;
    private Integer sal;
    private Integer dept;
}