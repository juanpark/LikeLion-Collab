package com.sec08;

abstract class BaseTest {
    private final String name;
    private final int salary;

    public BaseTest(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public abstract void getDisplay();
}

class DrivedTest extends BaseTest {
    private String department;

    public DrivedTest(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void getDisplay() {
        System.out.println("이름 : " + getName());
        System.out.println("연봉 : " + getSalary());
        System.out.println("부서 : " + department);
    }
}

public class AbsTest01 {
    public static void main(String[] args) {
        BaseTest employee = new DrivedTest("Dominico", 4000000, "책임");
        employee.getDisplay();

        System.out.println("\n== 직급을 변경 후 출력 ==");
        
        if (employee instanceof DrivedTest drived) {
            drived.setDepartment("상무");
            drived.getDisplay();
        }
    }
}
