package com.mysqlapp.model;

// DB[숫자, 문자, 날짜]  <->Java  datatype 고려점  
//날짜 처리  -> date -> java.util.Date 
//       date -> java.lang.String 
/*
 *   1. java.util.Date  시간정보없이 날짜만 매핑될때 사용권장  ->  java.time  시간, 날짜 모두 사용용도  
 *   2. java.sql.Date   시간정보없이 날짜만 매핑될때 사용권장   db타입의 형식과 동일하게 매핑 
 * 
 */
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