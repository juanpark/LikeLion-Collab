package com.sec17.tcpexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient_student {
	public static void main(String[] args) {
//		1. 서버와 통신을 위한 Socket 객체를 생성한다. 이때 접속 요청할 서버의 IP주소와 Port 번호를 매개변수로 지정한다.
		
		try (Socket socket = new Socket("localhost", 9999)) // closeable
		{
			;
			System.out.println("나 클라이언트!");
	
//			2. Socket 객체로부터 서버와의 통신을 위한 InputStream, OutputStream을 얻는다.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			System.out.println("서버가 준 메시지 : " + br.readLine());
			br.close();
			/*
			 * InputStream ios = socket.getInputStream(); int r = 0; while((r = ios.read())
			 * != -1) { System.out.print(r); } ios.close();
			 */
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		
		
//		3. 생성된 InputStream, OutputStream을 이용하여 서버와 통신한다.
//		4. 통신이 완료되면 통신에 사용된 IO스트림과 Socket 객체를 close() 한다.
	}
}
