package work.com.workshop4.book;

public class Book {
	
	private String 	bookName;
	private int 	bookPrice;
	private double 	bookDiscountRate;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, int bookPrice, double bookDiscountRate) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookDiscountRate() {
		return bookDiscountRate;
	}
	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}

	public double getDiscountBookPrice() {
		return getBookPrice() * ((100 - getBookDiscountRate()) * 0.01);
	}
	@Override
	public String toString() {
		
		System.out.printf("%-15s %5s %5s %10s\n", "책 이름", "가격", "할인율", "할인후금액");
	    System.out.println("--------------------------------------------");
	    
		return String.format(
				"%-15s %6d원 %5.1f%% \t%10.1f원\n",
				getBookName(), getBookPrice(), getBookDiscountRate(),getDiscountBookPrice());
	}
	
}
