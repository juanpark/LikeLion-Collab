package com.sec13.myio;

import java.io.*;

public class a_io {
    public static void myread() {
        try (BufferedReader reader = new BufferedReader(new FileReader("./a.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mywrite(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("a.txt", true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("IO Read:");
        myread();
        System.out.println("\nIO Write:");
        mywrite("Appended using IO.");
        myread();
    }
}