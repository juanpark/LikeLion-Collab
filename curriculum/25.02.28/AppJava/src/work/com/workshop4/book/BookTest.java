package work.com.workshop4.book;

public class BookTest {

	public static void main(String[] args) {
		
		Book bk1 = new Book("SQL Plus", 50000, 5.0);
		Book bk2 = new Book("Java 2.0", 40000, 3.0);
		Book bk3 = new Book("JSP Servlet", 60000, 6.0);
		
		System.out.println("책이름        가격         할인율        할인후금액");
		System.out.println("-----------------------------------------------");
		
		System.out.printf("%10s   %10d원       %10.1f%%          %10.1f원\n", bk1.getBookName(), bk1.getBookPrice(),
				bk1.getBookDiscountRate(), bk1.getDiscountBookPrice());
		System.out.printf("%s   %d원       %.1f%%          %.1f원\n", bk2.getBookName(), bk2.getBookPrice(),
				bk2.getBookDiscountRate(), bk1.getDiscountBookPrice());
		System.out.printf("%s   %d원       %.1f%%          %.1f원\n", bk3.getBookName(), bk3.getBookPrice(),
				bk3.getBookDiscountRate(), bk3.getDiscountBookPrice());
		
	}

}
