package work.com.workshop4.book;

public class BookTest {

	public static void main(String[] args) {
		
		Book bk1 = new Book("SQL Plus", 50000, 5.0);
		Book bk2 = new Book("Java 2.0", 40000, 3.0);
		Book bk3 = new Book("JSP Servlet", 60000, 6.0);
		
		System.out.printf("%-15s %5s %5s %10s\n", "책 이름", "가격", "할인율", "할인후금액");
        System.out.println("--------------------------------------------");

        System.out.printf("%-15s %6d원 %5.1f%% \t%10.1f원\n", bk1.getBookName(), bk1.getBookPrice(), 
        		bk1.getBookDiscountRate(), bk1.getDiscountBookPrice());
        System.out.printf("%-15s %6d원 %5.1f%% \t%10.1f원\n", bk2.getBookName(), bk2.getBookPrice(), 
        		bk2.getBookDiscountRate(), bk2.getDiscountBookPrice());
        System.out.printf("%-15s %6d원 %5.1f%% \t%10.1f원\n", bk3.getBookName(), bk3.getBookPrice(), 
        		bk3.getBookDiscountRate(), bk3.getDiscountBookPrice());
        
        // toString() override 적용:
        // System.out.println(bk1);
		
	}

}
