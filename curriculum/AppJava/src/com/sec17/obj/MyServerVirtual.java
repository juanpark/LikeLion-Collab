package com.sec17.obj;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.*;

public class MyServerVirtual {

	public static void main(String[] args) {
		try(	ServerSocket server = new ServerSocket(7777);
				ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()	) 
		{	
			System.out.println("서버 대기 중...");
		
			while(true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속");
				executor.submit(()-> handleClient(client));
				
				
			}//end while
		} catch(Exception e) {
			System.out.println(e.toString());
		}//end try-catch

	}//end main
	
	public static void handleClient(Socket client) {
		try(	client; // 명시 + 종료 시 try(resources)가 null로 초기화함
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream())	) {
		
			SendData response = (SendData)ois.readObject();
			double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOp());
			response.setResult(res);
			
			// 클라이언트로 계산된 결과를 보내자
			oos.writeObject(response);
			oos.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}//end inner try-catch
	}
	
	
	
	private static double MyCalculate(double a, double b, String op) {

		return switch(op) {
		case "+" -> a + b;
		case "-" -> a - b;
		case "*" -> a * b;
		case "/" -> b != 0 ? a / b : Double.NaN;
		default -> 0;
		};
	}
}
