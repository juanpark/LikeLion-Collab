package com.sec17.tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class c_tcp_client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        Scanner scanner = new Scanner(System.in);
        System.out.println("서버에 메시지를 입력하세요 (exit 입력 시 종료):");

        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) break;
            out.println(input);
            String response = in.readLine();
            System.out.println("응답: " + response);
        }

        socket.close();
    }
}