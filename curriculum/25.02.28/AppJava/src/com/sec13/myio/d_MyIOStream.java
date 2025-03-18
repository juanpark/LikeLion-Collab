package com.sec13.myio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class d_MyIOStream {

	public static void main(String[] args) {
		String filename = "/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/d.txt"; // 
		
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
		FileOutputStream fo = new FileOutputStream(filename);
		fo.write(100);
		fo.close();
	}
	private static void MyReader(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		System.out.println(fi.read());
		fi.close();
	}
	

} // class end
