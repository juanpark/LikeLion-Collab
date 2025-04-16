package com.sec17.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class f_chat_server {
    private static final List<PrintWriter> clients = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("[채팅 서버 시작됨]");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("[접속] " + socket.getInetAddress());
            new Thread(() -> handle(socket)).start();
        }
    }

    private static void handle(Socket socket) {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            clients.add(out);
            String msg;
            while ((msg = in.readLine()) != null) {
                broadcast(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clients.removeIf(pw -> pw.checkError());
        }
    }

    private static void broadcast(String msg) {
        synchronized (clients) {
            for (PrintWriter out : clients) {
                out.println("[Broadcast] " + msg);
            }
        }
    }
}