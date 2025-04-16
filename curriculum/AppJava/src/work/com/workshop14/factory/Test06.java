package work.com.workshop14.factory;

public class Test06 {
	public static void main(String[] args) {
		
		FactoryBiz fb = new FactoryBiz(
							"com.mysql.cj.jdbc.Driver",
							"jdbc:mysql://127.0.0.1:3306/my_emp",
							"mydb",
							"admin1234"
						);
		
		fb.getFactoryall();
		
	}
}
