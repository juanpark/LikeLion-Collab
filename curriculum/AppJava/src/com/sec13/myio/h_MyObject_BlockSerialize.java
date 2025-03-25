package com.sec13.myio;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Object 단위로 읽고 쓰자. Student_BlockSerialize.class를 읽고 쓰겠다.
public class h_MyObject_BlockSerialize {

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
		bo.writeObject(new Student_BlockSerialize("111",1,1,1));
		bo.writeObject(new Student_BlockSerialize("222",2,2,2));
		bo.writeObject(new Student_BlockSerialize("333",3,3,3));
		
		bo.close();
		System.out.println("파일에 객체 저장했어 !!");
	}
	private static void MyReader(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream bi = new ObjectInputStream(new FileInputStream(filename));
		Student_BlockSerialize s1 = (Student_BlockSerialize)bi.readObject();
		Student_BlockSerialize s2 = (Student_BlockSerialize)bi.readObject();
		Student_BlockSerialize s3 = (Student_BlockSerialize)bi.readObject();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println(" 파일에서 읽은 데이터 ");
		System.out.println("static : " + Student_BlockSerialize.age);
		System.out.println("s1 transient : " + s1.getWeight());
	
		bi.close();
	}
	

} // class end
