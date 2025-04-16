package com.sec17.tcp;

import java.io.*;
import java.net.*;

public class b_tcp_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 시작됨. 클라이언트 연결 대기 중...");

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("클라이언트 연결됨: " + client.getInetAddress());
            new Thread(() -> handleClient(client)).start();
        }
    }

    private static void handleClient(Socket client) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("수신: " + line);
                out.println("Echo: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}