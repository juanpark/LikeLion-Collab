package work.com.workshop12.workshop.exam02;

import java.util.List;
import java.util.stream.Stream;

public class StreamAnswer1 {

	public static void main(String[] args) {
		
		List<String> names = List.of("Tom", "Jerry", "Mike", "James", "Anna", "Sue");
		
		Stream<String> stream = names.stream();
		
		names.stream()
			.sorted()
			.filter(e -> e.compareTo("N") < 0)
			.forEach(System.out::println);
	}

}

