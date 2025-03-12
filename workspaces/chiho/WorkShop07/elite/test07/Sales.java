package Work.WorkShop07.elite.test07;

public class Sales extends Employee implements Bonus{



    public Sales() {
    }

    public Sales(String name, int number, String department, int salary) {
        super(name, number, department, salary);
    }


    @Override
    public void incentive(int pay) {
        this.setSalary((int) (this.getSalary() + pay*1.2));
    }


    @Override
    public double tax() {
        return super.tax()*0.13;
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
    public String getDepartment() {
        return super.getDepartment();
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
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



}
