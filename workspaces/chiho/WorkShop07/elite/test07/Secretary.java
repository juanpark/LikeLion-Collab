package Work.WorkShop07.elite.test07;

public class Secretary extends Employee implements Bonus{
    public Secretary() {
    }
    public Secretary(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
    }

    @Override
    public String getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setDepartment(String department) {
        super.setDepartment(department);
    }

    @Override
    public int getSalary() {
        return super.getSalary();
    }

    @Override
    public void setSalary(int salary) {
        super.setSalary(salary);
    }

    @Override
    public double tax() {
        return super.tax()*0.1;
    }

    @Override
    public void incentive(int pay) {
        this.setSalary((int) (this.getSalary() + pay*0.8));
    }


}



