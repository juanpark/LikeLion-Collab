package work.com.workshop7.com.elite.test07;

public class Sales extends Employee implements Bonus {

	public Sales() {
		// TODO Auto-generated constructor stub
	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void incentive(int pay) {
        this.setSalary((int) (this.getSalary() + (pay * 1.2)));

	}

	@Override
	public double tax() {
		
		return this.getSalary() * 0.13;
		
	}

}
