package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {

	public static void main(String[] args) {
		// Q1. create int 1 ~ 10 as a stream and then print 
		Stream<String> streamFromValues = Stream.of("1","2","3","4","5","6","7","8","9","10");
		StreamTest.printStream("TITLE", streamFromValues);
		
		// Q2. Create stream of ints 10 ~ 1 and then print -> iterate
		Stream<String> streamFromValues03 = IntStream.iterate(10, i->i-1).limit(10).mapToObj(String::valueOf);
		StreamTest.printStream("Stream ints 10 ~ 1 then print", streamFromValues03);
		
		// Q3. Create stream of ints 10 ~ 1 and then print -> rangeClosed
		
		
		// StreamTest.printStream("Stream ints 10 ~ 1 then print", null);
		
		
		// Q4. Stream<Integer> boxed() + sorted(Comparator.reverseOrder())
		
	}

}
