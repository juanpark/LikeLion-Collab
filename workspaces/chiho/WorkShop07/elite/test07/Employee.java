package Work.WorkShop07.elite.test07;

abstract class Employee {
    private String name;
    private int number;
    private String department;
    private int salary;

    public Employee()
    {}

    public Employee(String name, int number, String department, int salary) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double tax() {
        //세금을 리턴한다.
        return (double)salary;
    }
    public void incentive(int pay)
    {
        salary += pay;
    }
    //이거 없으면 예쁘게 출력이 안돼요! 보시고 아이디어 주세요!
    public void printInfoWithoutTax() {
        System.out.printf("%-10s %-10s %10d\n", name, department, salary);
    }
    // 직원 정보 + 세금 출력
    public void printInfoWithTax() {
        System.out.printf("%-10s %-10s %10d %10.1f\n", name, department, salary, tax());
    }


}
