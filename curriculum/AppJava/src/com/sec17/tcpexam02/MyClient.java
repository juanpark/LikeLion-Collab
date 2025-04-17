package com.sec17.tcpexam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

	public static void main(String[] args) {
		// 1. 서버와 통신을 위한 Socket 객체를 생성한다.
		// 이때 접속 요청할 서버의 IP 주소와 Port 번호를 매개변수로 지정한다.
		try (Socket socket = new Socket("localhost", 9999); // 서버와 연결
				// 2. Socket 객체로부터 서버와의 통신을 위한 InputStream을 얻는다.
				BufferedReader br 
				= new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"))) {
			System.out.println("나 클라이언트야 !!");

			// 3. 생성된 InputStream을 이용하여 서버로부터 메시지를 읽는다.
			System.out.println("서버가 준 메시지 : " + br.readLine());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
