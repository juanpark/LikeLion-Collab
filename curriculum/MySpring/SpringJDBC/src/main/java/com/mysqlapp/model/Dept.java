package com.mysqlapp.model;
//기본생성자 X , setter X   = vo, dto 
public record Dept(
    int deptno,
    String dname,
    String loc
) {}
