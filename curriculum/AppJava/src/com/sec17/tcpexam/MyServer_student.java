package com.sec17.tcpexam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer_student {
	public static void main(String[] args) {
//		1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
		System.out.println("나 서버!");
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9999);
			
//			2.ServerSocket의 accept() 메서드를 이용하여 클라이언트의 접속을 기다린다.
			socket = serverSocket.accept();
			System.out.println("클라이언트 접속");
			
			OutputStream os = socket.getOutputStream();
			os.write("서버가 클리언트에게".getBytes());
			os.close();
			
//			3.클라이언트의 접속 요청이 들어오면 accept() 메서드가 실행되어 클라이언트와의 통신을 위한 Socket 객체를 생성한다.
			
			
		} catch (Exception e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
//		4.생성된 Socket 객체로부터 통신을 위한 InputStream, OutputStream을 얻는다.
		
		
//		5.InputStream, OutputStream을 이용하여 클라이언트와 통신한다.
		
		
//		6.통신에 사용된 IO스트림과 Socket 객체를 close()한다
	}
}
