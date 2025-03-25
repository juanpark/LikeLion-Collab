package work.com.workshop9.com.test;

import java.util.Optional;

public class CharTest {

	public static void main(String[] args) {
		
		if (args == null || args.length == 0 || args[0] == null) {
		    System.out.println("Err: args is null or empty!");
		    return;
		} 
		
		int argsL = args[0].length();
		// System.out.println(argsL); // DEBUG
		
		char[] charArray = new char[argsL]; // create char array to hold string in chars
		
		for (char e : args[0].toCharArray()) {
			
		}
		
		for (int i = 0; i < argsL ; i++) {
			char c = args[0].charAt(i);
			charArray[i] = Character.toUpperCase(c); 
		}
		
		// for (char e : charArray) {	// DEBUG
		//	System.out.print(e + " ");
		// }
		
		for (int i = argsL - 1; i >= 0; i--) {
			System.out.print(charArray[i]);
		}
	}

}
