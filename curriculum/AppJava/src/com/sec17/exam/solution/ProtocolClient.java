package com.sec17.exam.solution;

import java.io.*;
import java.net.*;
import static com.sec17.exam.solution.Protocol.*;

public class ProtocolClient {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 9500);
            BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            System.out.print("이름을 입력하세요: ");
            String name = keyIn.readLine();
            bw.write(ENTER + ":" + name + "\n");
            bw.flush();

            String line;
            while (true) {
            	
            	 String response = br.readLine();
                 System.out.println("서버 응답: " + response);
                 
                System.out.print("메시지 입력: ");
                line = keyIn.readLine();
                if (line.equals("")) line = " ";
                
                if ("exit".equalsIgnoreCase(line)) {
                    bw.write(EXIT + ":" + name + "\n");
                    bw.flush();
                    
                } else {
                    bw.write(SEND_MESSAGE + ":" + name + ":" + line + "\n");
                    bw.flush();
                }
            }
        } catch (IOException e) {
            System.out.println("서버 연결 실패 또는 종료됨.");
        }
    }
}
