package com.mysqlapp.model;

//record의 경우 기본생성자 X, setter X = vo, dto 최적화 
public record Dept(
    int deptno,
    String dname,
    String loc
) {}
