package com.sec13.myio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class c_nio2 {
    public static void myread() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./a.txt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mywrite(String content) {
        try {
            Files.write(Paths.get("a.txt"), (content + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("NIO.2 Read:");
        myread();
        System.out.println("\nNIO.2 Write:");
        mywrite("Appended using NIO.2.");
        myread();
    }
}