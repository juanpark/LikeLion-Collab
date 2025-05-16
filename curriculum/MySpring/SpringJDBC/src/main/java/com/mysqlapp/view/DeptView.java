package com.mysqlapp.view;

import com.mysqlapp.model.Dept;
import java.util.List;

public class DeptView {
    public void display(List<Dept> list) {
        System.out.println("\n=== 부서 목록 ===");
        for (Dept d : list) {
            System.out.printf("부서번호: %d | 부서명: %s | 위치: %s%n",
                d.deptno(), d.dname(), d.loc());
        }
    }
}
