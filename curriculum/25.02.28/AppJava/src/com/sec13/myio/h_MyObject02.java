package com.sec13.myio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Object 단위로 읽고 쓰자. Student.class를 읽고 쓰겠다.
public class h_MyObject02 {

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
		bo.writeObject(new Student("111",1,1,1));
		bo.writeObject(new Student("222",2,2,2));
		bo.writeObject(new Student("333",3,3,3));
		
		bo.close();
		System.out.println("파일에 객체 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream bi = new ObjectInputStream(new FileInputStream(filename));
		Student s1 = (Student)bi.readObject();
		Student s2 = (Student)bi.readObject();
		Student s3 = (Student)bi.readObject();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println(" 파일에서 읽은 데이터 ");
	
		bi.close();
	}
	

} // class end
