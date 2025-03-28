package work.com.workshop12.workshop.string;

import java.util.Arrays;

public class StringTest01 {

	public static void main(String[] args) {
		
		String str = "I am second to none";
		
		str.chars() // returns IntStream of Unicode code units (characters stored as int)
			.filter(c -> c != ' ')
			.mapToObj(c -> (char) c) // needs to be cast to (char) to print characters properly
			.forEach(c -> System.out.print(c + " "));
		
		long charCount = str.chars()
							.filter(c -> c != ' ')
							.count();
		
		System.out.println();
		System.out.println("문자 개수: " + charCount);
		
		System.out.println(str);
		
		// str.trim().split("\\s+"))로 스트림을 위한 array 생성
		long wordCount = Arrays.stream(str.trim().split("\\s+"))
							.count();
		
		System.out.println("단어 개수: " + wordCount);
			
	}

}
	
/*

        // 1. Print each character (excluding spaces) with spaces between them
        str.chars()
    

        // 4. Count words
        long wordCount = Arrays.stream(str.trim().split("\\s+"))
                               .count();
        System.out.println("단어 개수: " + wordCount);*/
   