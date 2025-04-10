package com.mysqlapp.model;

// Emp와 Dept 조인 결과(사원명, 부서번호, 부서명, 부서위치) 
public record EmpDeptDTO(
		    String ename,
		    int deptno,
		    String dname,
		    String loc
		) {}

