package com.mysqlapp.model;

import java.util.Date;

public record Emp(
    int empno,
    String ename,
    String job,
    int mgr,
    Date hiredate,
    double sal,
    double comm,
    int deptno
){}