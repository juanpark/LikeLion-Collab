package work.com.workshop.annotation.printmessage;


public class TestClass {
	
	@PrintMessage
	public void hello() {
		System.out.println("Hello World!");
	}
	
	public void bye() {
		System.out.println("Goodbye!");
	}
	
	@PrintMessage
	public void annotMessage() {
		System.out.println("This is annotated!");
	}
}
