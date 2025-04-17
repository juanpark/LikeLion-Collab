package com.sec17.tcpexam02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        // 1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
        System.out.println(" 나 서버야  ");

        try (ServerSocket serverSocket = new ServerSocket(9999)) { // 1. 포트 9999에서 대기
            
        	while(true) {
	        	Socket clientSocket = serverSocket.accept(); 	// 2. 클라이언트의 접속 요청 대기
	        	System.out.println("클라이언트 접속했어");	// 3. 클라이언트가 접속하면 Socket 객체 생성됨
	        	// 4. 클라이언트 별도 가상 스레드로 처리
	        	Thread.startVirtualThread(()-> handleClient(clientSocket));
        	}
	        	
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //end main

	private static void handleClient(Socket clientSocket) {
		// 클라이언트에게 서버가 메시지를 보내보자
		try(clientSocket;
				OutputStream os = clientSocket.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))){
			writer.write("가상 스레드 서버에서 응답한다\n");
			writer.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		}//end try-catch
	}//end handleClient method
}// end 
