package work.com.workshop9.com.test;

import java.util.Optional;

public class CharTest_Stream {

	public static void main(String[] args) {
		
		Optional.ofNullable(args[0])
		    .map(str -> new StringBuilder(str).reverse().toString().toUpperCase())  // Reverse the string using StringBuilder
		    .ifPresent(reversed -> System.out.print(reversed));  // Print the reversed string

	}

}
