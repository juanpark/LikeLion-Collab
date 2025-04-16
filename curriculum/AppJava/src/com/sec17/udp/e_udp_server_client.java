package com.sec17.udp;

import java.net.*;

public class e_udp_server_client {
    public static void main(String[] args) throws Exception {
        Thread server = new Thread(() -> runUdpServer());
        server.start();

        Thread.sleep(1000);
        runUdpClient();
    }

    private static void runUdpServer() {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            System.out.println("[UDP 서버 대기 중]");
            socket.receive(packet);
            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("[UDP 수신] " + msg);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void runUdpClient() throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte[] buf = "안녕하세요 UDP!".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
        socket.send(packet);
        System.out.println("[UDP 클라이언트] 메시지 전송 완료");
        socket.close();
    }
}