package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class f_MyIOStream {

	public static void main(String[] args) {
		String filename = "/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/f.txt"; // 
		
//		  File filename = new
//		  File("/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/d.txt"); 
//		  System.out.println(filename.getPath());
//		  System.out.println(filename.getAbsolutePath());
		 
		try {
			MyWrite(filename);
			MyReader(filename);
			
		} catch (Exception e) {
			System.out.println(e);
		} // try end

	} // main end

	private static void MyWrite(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		for (byte i = 'A'; i <= 'Z'; i++){
			fw.write(i); // IOException
		}
		fw.close();
		System.out.println("파일에 A~Z 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		int data = 0;
		System.out.println(" 파일에서 읽은 데이터 ");
		while ( (data = fr.read()) != -1){    // 한 바이트씩 읽어서 data에 대입하자 -1 될 때까지 
			System.out.print((char)data + " ");
		}
		fr.close();
	}
	

} // class end
