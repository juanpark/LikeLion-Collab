package com.sec17.tcpexam;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServerVirtual {
    public static void main(String[] args) {
        System.out.println("🌐 VirtualThread 서버 시작");

        try (ServerSocket serverSocket = new ServerSocket(9999);
             ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            while (true) {
                Socket client = serverSocket.accept(); // 여전히 블로킹
                executor.submit(() -> handleClient(client));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (socket;
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8))) {

            writer.write("서버가 클라이언트에게\n");
            writer.flush();
            System.out.println("응답 완료 (VirtualThread)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
