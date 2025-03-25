package com.sec08;

abstract class BaseTest { 	// new My() 객체 생성 안한다. -> 후손인 클래스 너가 나를 메모리에 할당해줘 
    private final String name;	// 
    private final int salary;

    public BaseTest(String name, int salary) {	// 필드가 파이널이기 때문에 생성자가 생성 시 전달 하는 값 후에는 변경 불가능 
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public abstract void getDisplay();	// {}가 없는 선언만 되어 있는 추상 메소드 (이름만 있고 구현이 없음: 후손이 구현)
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
