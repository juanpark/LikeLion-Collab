package com.sec17.intro;
//압축된 .gz → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

public class a_GzipDecompression {
    public static void main(String[] args) {
        File gzipFile = new File("output.txt.gz");

        try (FileInputStream fis = new FileInputStream(gzipFile);
             GZIPInputStream gzipIn = new GZIPInputStream(fis);
             InputStreamReader reader = new InputStreamReader(gzipIn, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {

            System.out.println(" 압축 해제된 내용:");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

