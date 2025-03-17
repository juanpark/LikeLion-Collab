package work.com.workshop.annotation.maxvalue;

public class NumberClass {

	@MaxValue(100)
	int number;
	
	public NumberClass(int number) {
		this.number = number;
	}
}
