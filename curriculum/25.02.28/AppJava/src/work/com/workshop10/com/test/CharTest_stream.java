package work.com.workshop10.com.test;

import java.util.Optional;

public class CharTest_stream {

	public static void main(String[] args) {
		
		Optional.ofNullable(args[0])
		    .map(str -> new StringBuilder(str).reverse().toString().toUpperCase())  // Reverse the string using StringBuilder
		    .ifPresent(reversed -> System.out.print(reversed));  // Print the reversed string

	}

}
