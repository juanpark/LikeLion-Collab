package application;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) {
		try(
		Socket socket = new Socket("localhost",7777);
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		
		Scanner sc = new Scanner(System.in)) {
		System.out.print("첫번째 숫자: ");
		double a = sc.nextDouble();
		
		System.out.print("연산자: ");
		String op = sc.next();
		
		System.out.print("두번째 숫자: ");
		double b = sc.nextDouble();
		
		// 객체에 담기 + 서버 보내기
		SendData sd = new SendData(a, b, op);
		oos.writeObject(sd);
		oos.flush();
		
		// 서버로부터 리턴 받은 결과 값 출력
		SendData response = (SendData)ois.readObject();
		System.out.println("서버로부터 받은 연산 결과: " + response.getResult());
		} catch(Exception e) {
			e.printStackTrace();
		}//end try-catch
	}//end main
}//end MyClient
