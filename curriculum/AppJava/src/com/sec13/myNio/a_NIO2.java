package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// \Test
//	- AA
//	- BB
//		- a.txt
public class a_NIO2 {

	public static void main(String[] args) throws IOException {
		// Q1: Create Test folder in root
		Path test = Paths.get("/Users/juanpark/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myNio/test");
		Files.createDirectory(test);
		// Q2: test\AA folder 
		Path aadir = test.resolve("AA");
		Files.createDirectories(aadir);
		
		// Q3: test\BB folder 
		Path bbdir = test.resolve("BB");
		Files.createDirectories(bbdir);

		// Q4: test\BB\a.txt 
		Path atxt = bbdir.resolve("a.txt");
		Files.createFile(atxt);
		System.out.println("File Operations Done");
		
		// Q5: delete test\BB\a.txt  
		// rm select directory 	delete(Path path), deleteIfExists(Parth path)
		Files.delete(atxt);
		System.out.println(atxt + " 삭제 했어!!");
		
		

	}

}
