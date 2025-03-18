package com.sec13.myio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Object 단위로 읽고 쓰자
public class h_MyObject {

	public static void main(String[] args) {
		String filename = "/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/h.txt"; // 
		

		try {
			MyWrite(filename);
			MyReader(filename);
			
		} catch (Exception e) {
			System.out.println(e);
		} // try end

	} // main end

	private static void MyWrite(String filename) throws IOException {
		ObjectOutputStream bo = new ObjectOutputStream(new FileOutputStream(filename));
		for (byte i = 'A'; i <= 'Z'; i++){
			bo.writeByte(i); // IOException
		}
		bo.close();
		System.out.println("파일에 A~Z 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException {
		ObjectInputStream bi = new ObjectInputStream(new FileInputStream(filename));
		int data = 0;
		System.out.println(" 파일에서 읽은 데이터 ");
		while ( (data = bi.readByte()) != -1){    // 
			System.out.print((char)data + " ");
		}
		bi.close();
	}
	

} // class end
