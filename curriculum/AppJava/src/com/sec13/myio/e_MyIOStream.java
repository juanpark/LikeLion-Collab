package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class e_MyIOStream {

	public static void main(String[] args) {
		String filename = "/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/e.txt"; // 
		
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
		//FileOutputStream fo = new FileOutputStream(filename);
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(filename));
		for (byte i = 'A'; i <= 'Z'; i++){
			bo.write(i); // IOException
		}
		bo.close();
		System.out.println("파일에 A~Z 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException {
//		FileInputStream fi = new FileInputStream(filename);
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(filename));
		int data = 0;
		System.out.println(" 파일에서 읽은 데이터 ");
		while ( (data = bi.read()) != -1){    // 한 바이트씩 읽어서 data에 대입하자 -1 될 때까지 
			System.out.print((char)data + " ");
		}
		bi.close();
	}
	

} // class end
