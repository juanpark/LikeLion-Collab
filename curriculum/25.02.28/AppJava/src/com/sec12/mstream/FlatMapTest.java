package com.sec12.mstream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;	// study
import java.nio.file.Paths; // study
import java.util.stream.Stream;

public class FlatMapTest {
	public static void test_flatMap() {
		Path path = Paths.get("/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec12/mstream/a.txt");
		try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
			// return words on lines of file based on space
			// Steam<Stream<T>> -> Flattens to a single stream
			Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +")));
		
			words.forEach(System.out::println);
			
		}catch(IOException e ) {
			System.out.println("File error: " + e. getMessage());
		}
	}
	
	public static void main(String[] args) {
		
		Path path = Paths.get("/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec12/mstream/a.txt");
		try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){
			// return words on lines of file based on space
			
			Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split(" +")));
		
			// words.forEach(System.out::println);
			words.forEach(innerStream -> innerStream.forEach(System.out::println));
			
		}catch(IOException e ) {
			System.out.println("File error: " + e. getMessage());
		}
		
		

	}

}
