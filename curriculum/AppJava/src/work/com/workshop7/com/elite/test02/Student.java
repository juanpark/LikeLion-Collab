package work.com.workshop7.com.elite.test02;

public class Student extends Human {

	private String number;
	private String major;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

    public Student(String name, int age, int height, int weight, String number, String major) {
        super(name, age, height, weight);  // Calls the superclass constructor
        this.number = number;
        this.major = major;
    }

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String printInformation() {
		// String.format 활용 해서 super에서의 스트링도 활용
		return String.format("%s  %s  %s", super.printInformation(), this.getNumber(), this.getMajor());
				
	}
	
}
