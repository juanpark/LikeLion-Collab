package com.sec13.myNio;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class g_NIOByte {

	// byte : Files.newOutputStream()	Files.newInputStream()
	public static void main(String[] args) throws IOException{
		Path path = Paths.get("a.txt");
		
		// byte A ~ Z IO
		// var = 지역변수 선언, 컴파일 시 타입이 결정난다. 람다식에는 사용할 수 없다.
		try(var out = Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)    ) {
		// try(BufferedOutputStream out = (BufferedOutputStream) Files.newOutputStream(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE)    ) {
			for (byte i = 'A'; i <= 'Z'; i++) {
				out.write(i);
			}
		}
		System.out.println("Saved!!!");
		
		
		System.out.println("Data Result  ");
		try(var in = Files.newInputStream(path)    ) {
			int data = 0;
			while ( (data = in.read()) != -1) {
				System.out.print((char)data);
			}
		}

	}

}
