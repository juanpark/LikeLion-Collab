package com.mysqlapp.controller;

import com.mysqlapp.dao.EmpDAO;
import com.mysqlapp.dao.EmpDAOImpl;
import com.mysqlapp.model.Emp;
import com.mysqlapp.model.EmpDeptDTO;
import com.mysqlapp.view.EmpView;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpController {
    private final EmpDAO dao = new EmpDAOImpl();
    private final Scanner sc = new Scanner(System.in);

    public void printAllEmps() {
        List<Emp> list = dao.findAll();
        System.out.println("\n=== [사원 목록] ===");
        for (Emp e : list) {
            System.out.printf("사번: %d | 이름: %s | 직무: %s | 급여: %.2f | 부서번호: %d%n",
                e.empno(), e.ename(), e.job(), e.sal(), e.deptno());
        }
    }

    public void insertEmp(DeptController deptController) {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("직무: ");
        String job = sc.nextLine();
        System.out.print("상사 번호: ");
        int mgr = Integer.parseInt(sc.nextLine());
        System.out.print("급여: ");
        double sal = Double.parseDouble(sc.nextLine());
        System.out.print("보너스: ");
        double comm = Double.parseDouble(sc.nextLine());
        System.out.print("부서번호: ");
        int deptno = Integer.parseInt(sc.nextLine());

        if (!deptController.isValidDeptno(deptno)) {
            System.out.println("⚠ 존재하지 않는 부서번호입니다. 사원 등록 실패.");
            return;
        }

        Emp emp = new Emp(0, name, job, mgr, new Date(), sal, comm, deptno);
        int res = dao.insert(emp);
        System.out.println(res > 0 ? "사원 등록 성공" : "사원 등록 실패");
    }
    public void printEmpWithDept() {
        List<EmpDeptDTO> list = dao.findEmpWithDept();
        EmpView view = new EmpView();
        view.printEmpWithDept(list);
    }
}
