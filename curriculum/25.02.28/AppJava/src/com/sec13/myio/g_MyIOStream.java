package com.sec13.myio;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

// char 단위를 BufferedReader, BufferedWriter로 읽고 쓰자
public class g_MyIOStream {

	public static void main(String[] args) {
		String filename = "/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/g.txt";  
		
//		  File filename = new
//		  File("/Users/juanpark/Library/Mobile Documents/com~apple~CloudDocs/CS_iCloud/computer.lab/멋사/LikeLion-Collab/curriculum/25.02.28/AppJava/src/com/sec13/myio/d.txt"); 
//		  System.out.println(filename.getPath());
//		  System.out.println(filename.getAbsolutePath());
		 
		try {
			// MyWrite(filename);
			MyReader02(filename);
			
		} catch (Exception e) {
			System.out.println(e);
		} // try end

	} // main end

	private static void MyWrite(String filename) throws IOException {
		BufferedWriter bo = new BufferedWriter(new FileWriter(filename));
		for (char i = 'A'; i <= 'Z'; i++){
			// bo.write(i); // IOException
			bo.append(i); // IOException
		}
		bo.close();
		System.out.println("파일에 A~Z 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException {
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		int data = 0;
		System.out.println(" 파일에서 읽은 데이터 ");
		while ( (data = bi.read()) != -1){    // 0 ~ 65535 코드 값으로 읽어서 data에 대입하자 -1 될 때까지 
			System.out.print((char)data + " ");
		}
		bi.close();
	}
	
	private static void MyReader02(String filename) throws IOException {
		// 라인 단위로 읽겠다 = String
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		String data = null;  // 한줄씩 읽어서 대입한 객체 변수 null로 지역변수 초기화 
		System.out.println(" 파일에서 읽은 데이터 ");
		while ( (data = bi.readLine()) != null){    // 줄 단위로 읽어서 data에 대입하자 null 될 때까지 
			System.out.println(data);
		}
		bi.close();
	}
	

} // class end
