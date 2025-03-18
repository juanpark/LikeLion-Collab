package com.sec13.myio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class b_nio {
    public static void myread() {
        try (FileChannel channel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (channel.read(buffer) > 0) {
                buffer.flip();
                System.out.print(new String(buffer.array(), 0, buffer.limit()));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mywrite(String content) {
        try (FileChannel channel = FileChannel.open(Paths.get("./a.txt"), StandardOpenOption.APPEND)) {
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            channel.write(buffer);
            buffer = ByteBuffer.wrap(System.lineSeparator().getBytes());
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("NIO Read:");
        myread();
        System.out.println("\nNIO Write:");
        mywrite("Appended using NIO.");
        myread();
    }
}