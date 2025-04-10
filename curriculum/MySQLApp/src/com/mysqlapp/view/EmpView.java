package com.mysqlapp.view;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;

import java.util.List;

public class EmpView {
    public void display(List<Emp> list) {
        for (Emp e : list) {
            System.out.println(e.empno() + " - " + e.ename() + " - " + e.job());
        }
    }
    
    public void printEmpWithDept(List<EmpDeptDTO> list) {
        System.out.println("\n=== [사원 + 부서 정보 목록] ===");
        for (EmpDeptDTO e : list) {
            System.out.printf("사원: %s | 부서번호: %d | 부서명: %s | 위치: %s%n",
                e.ename(), e.deptno(), e.dname(), e.loc());
        }
    }    
}