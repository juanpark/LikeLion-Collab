package com.mydb.core;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int deptno;
}
