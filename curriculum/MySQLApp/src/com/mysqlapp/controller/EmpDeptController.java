package com.mysqlapp.controller;

import com.mysqlapp.model.Emp;
import com.mysqlapp.model.Dept;
import com.mysqlapp.service.EmpService;
import com.mysqlapp.service.EmpServiceImpl;
import com.mysqlapp.service.DeptService;
import com.mysqlapp.service.DeptServiceImpl;
import com.mysqlapp.view.EmpView;
import com.mysqlapp.view.DeptView;

import java.util.*;

public class EmpDeptController {
    private final EmpService empService = new EmpServiceImpl();
    private final DeptService deptService = new DeptServiceImpl();
    private final EmpView empView = new EmpView();
    private final DeptView deptView = new DeptView();
    private final Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n[ 메뉴 ] 1.사원조회 | 2.부서조회 | 3.부서등록 | 4.사원등록 | 5.사원-부서 | 6.eq결과 | 0.종료");
            System.out.print("선택 > ");
            String input = sc.nextLine();

            switch (input) {
                case "1" -> empView.display(empService.getAllEmps());
                case "2" -> deptView.display(deptService.getAllDepts());
                case "3" -> registerDept();
                case "4" -> registerEmp();
                case "5" -> empView.printEmpWithDept(empService.getEmpWithDept());
                case "6" -> empView.printEmpWithSalGrade(empService.getEmpWithSalgrade());
                case "0" -> {
                    System.out.println("종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void registerDept() {
        System.out.print("부서명: ");
        String dname = sc.nextLine();
        System.out.print("부서위치: ");
        String loc = sc.nextLine();

        Dept d = new Dept(0, dname, loc);
        int res = deptService.insertDept(d);
        System.out.println(res > 0 ? " 부서 등록 성공" : " 부서 등록 실패");
    }

    private void registerEmp() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("직무: ");
        String job = sc.nextLine();
        System.out.print("상사번호: ");
        int mgr = Integer.parseInt(sc.nextLine());
        System.out.print("급여: ");
        double sal = Double.parseDouble(sc.nextLine());
        System.out.print("보너스: ");
        double comm = Double.parseDouble(sc.nextLine());
        System.out.print("부서번호: ");
        int deptno = Integer.parseInt(sc.nextLine());

        if (deptService.findDeptByNo(deptno) == null) {
            System.out.println(" 해당 부서번호는 존재하지 않습니다.");
            return;
        }

        Emp emp = new Emp(0, name, job, mgr, new Date(), sal, comm, deptno);
        int res = empService.insertEmp(emp);
        System.out.println(res > 0 ? " 사원 등록 성공" : " 사원 등록 실패");
    }
}
