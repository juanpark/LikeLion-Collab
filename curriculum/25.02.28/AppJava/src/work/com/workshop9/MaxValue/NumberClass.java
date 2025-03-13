package work.com.workshop9.MaxValue;

public class NumberClass {

	@MaxValue(100)
	int number;
	
	public NumberClass(int number) {
		this.number = number;
	}
}
