package com.mysqlapp;

import com.mysqlapp.controller.EmpController;
import com.mysqlapp.controller.DeptController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmpController empController = new EmpController();
        DeptController deptController = new DeptController();

        while (true) {
            System.out.println("\n===== MySQLApp 메뉴 =====");
            System.out.println("1. 전체 사원 조회");
            System.out.println("2. 전체 부서 조회");
            System.out.println("3. 부서 등록");
            System.out.println("4. 사원 등록");
            System.out.println("5. 사원-부서 조인 정보 보기");
            System.out.println("0. 종료");
            System.out.print("선택 > ");
            String input = sc.nextLine();

            switch (input) {
                case "1" -> empController.printAllEmps();
                case "2" -> deptController.printAllDepts();
                case "3" -> deptController.insertDept();
                case "4" -> empController.insertEmp(deptController);
                case "5" -> empController.printEmpWithDept();
                case "0" -> {
                    System.out.println("종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
