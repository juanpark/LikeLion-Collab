package work.com.workshop10.cafe;

public class Coffee {
	private String 	name;
	private int		price;
	
	public Coffee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void setPrice (int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	@Override
	public String toString() {
		return String.format("%-10s\t%4d", name, price);
	}
	
	
}
