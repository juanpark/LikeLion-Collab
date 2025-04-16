package com.sec17.chat;

import java.io.*;
import java.net.*;

public class f_chat_client {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 7777);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("[클라이언트] 서버에 연결됨. 채팅 시작!");

            // 서버로부터 메시지 수신 스레드
            new Thread(() -> {
                String line;
                try {
                    while ((line = in.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("[알림] 서버와의 연결 종료");
                }
            }).start();

            // 사용자 입력 송신 루프
            String input;
            while ((input = keyboard.readLine()) != null) {
                out.println(input);
            }

        } catch (IOException e) {
            System.out.println("[에러] 서버에 연결할 수 없습니다.");
            e.printStackTrace();
        }
    }
}
