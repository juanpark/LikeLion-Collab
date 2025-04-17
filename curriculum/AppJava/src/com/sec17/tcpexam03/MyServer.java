package com.sec17.tcpexam03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.*;
import java.time.LocalDateTime;


public class MyServer {
	
	private static final AtomicInteger clientCounter = new AtomicInteger(0); // 고유 클라이언트 ID를 위한 카운트 체크
	private static final File logFile = new File("client_log.txt");
	
    public static void main(String[] args) {
        
        System.out.println(" 나 서버야  ");

        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            
        	while(true) {
	        	Socket clientSocket = serverSocket.accept(); 	
	        	
	        	int clientId = clientCounter.incrementAndGet();
	        	String clientIp = clientSocket.getInetAddress().getHostAddress();
	        	int clientPort = clientSocket.getPort();
	        	LocalDateTime clientTime = LocalDateTime.now();
	        	
	        	String clientString = String.format("[클라이언트 %d 접속했어] IP: %s PORT: %d TIME: %s\n", 
	        							clientId, clientIp, clientPort, clientTime);
	        	System.out.printf(clientString);
	        	
	        	logFileClient(clientString);
	        	
	        	// 클라이언트 별도 가상 스레드로 처리
	        	Thread.startVirtualThread(()-> handleClient(clientSocket, clientId));
        	}
	        	
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //end main

	private static void logFileClient(String clientString) {
		try(BufferedWriter logWriter = 
				new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream(logFile, true), StandardCharsets.UTF_8))) {
			logWriter.write(clientString);
			logWriter.newLine();
				
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void handleClient(Socket clientSocket, int clientId) {
		// 클라이언트에게 서버가 메시지를 보내보자
		try(clientSocket;
				OutputStream os = clientSocket.getOutputStream();
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))){
			writer.write("[서버 응답] 클라이언트 " + clientId + "님, 안녕하세요!\n");
			writer.flush();
			System.out.printf("[클라이언트 %d] 응답완료... 연결종료...\n", clientId);
		} catch(Exception e) {
			e.printStackTrace();
		}//end try-catch
	}//end handleClient method
}// end 
