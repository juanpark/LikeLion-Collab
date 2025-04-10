package com.mysqlapp.controller;

import com.mysqlapp.dao.DeptDAO;
import com.mysqlapp.dao.DeptDAOImpl;
import com.mysqlapp.model.Dept;

import java.util.List;
import java.util.Scanner;

public class DeptController {
    private final DeptDAO dao = new DeptDAOImpl();
    private final Scanner sc = new Scanner(System.in);

    public void printAllDepts() {
        List<Dept> list = dao.findAll();
        System.out.println("\n=== [부서 목록] ===");
        for (Dept d : list) {
            System.out.printf("부서번호: %d | 부서명: %s | 위치: %s%n", d.deptno(), d.dname(), d.loc());
        }
    }

    public void insertDept() {
        System.out.print("부서명: ");
        String dname = sc.nextLine();
        System.out.print("위치: ");
        String loc = sc.nextLine();

        int res = dao.insert(new Dept(0, dname, loc)); // deptno는 auto_increment
        System.out.println(res > 0 ? "부서 등록 성공" : "부서 등록 실패");
    }

    public boolean isValidDeptno(int deptno) {
        return dao.findByDeptno(deptno) != null;
    }
}
