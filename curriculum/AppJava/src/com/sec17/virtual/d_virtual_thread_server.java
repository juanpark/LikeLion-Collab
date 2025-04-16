package com.sec17.virtual;

import java.io.*;
import java.net.*;

public class d_virtual_thread_server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("[VirtualThread] 서버 시작됨...");

        while (true) {
            Socket client = serverSocket.accept();
            Thread.startVirtualThread(() -> handle(client));
        }
    }

    private static void handle(Socket client) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("[가상스레드] 수신: " + msg);
                out.println("[가상스레드 응답]: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}