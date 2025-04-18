package com.sec17.exam.solution;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;
import static com.sec17.exam.solution.Protocol.*;

public class ProtocolServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9500);
        System.out.println("서버 시작 (Virtual Thread 기반)");

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        while (true) {
            Socket socket = serverSocket.accept();
            executor.submit(() -> handleClient(socket));
        }
    }

    private static void handleClient(Socket socket) {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(":");
                Protocol select = Protocol.valueOf(words[0]);
                switch (select) {
                    case ENTER -> {
                        bw.write(words[1] + "님이 입장하였습니다.\n");
                    }
                    case EXIT -> {
                        bw.write(words[1] + "님이 퇴장하였습니다.\n");
                        return;
                    }
                    case SEND_MESSAGE -> {
                        bw.write("[" + words[1] + "]" + words[2] + "\n");
                    }
                    case SECRET_MESSAGE -> {
                        bw.write("<" + words[1] + ">" + words[3] + "\n");
                    }
                    default -> bw.write("잘못된 요청입니다.\n");
                }
                bw.flush();
            }

        } catch (IOException e) {
            System.out.println("클라이언트 연결 종료됨");
        }
    }
}
