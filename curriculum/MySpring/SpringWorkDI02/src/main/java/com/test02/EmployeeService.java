package com.test02;

import java.util.List;
import java.util.Map;

public class EmployeeService {
    private   Map<String, List<Employee>> departmentMap;

    public void setDepartmentMap(Map<String, List<Employee>> departmentMap) {
        this.departmentMap = departmentMap;
    }

    public void printAllEmployees() {
        for (String dept : departmentMap.keySet()) {
            System.out.println("[" + dept + " 부서]");
            for (Employee emp : departmentMap.get(dept)) {
                System.out.println("- " + emp.toString());
            }
            System.out.println();
        }
    }
}
