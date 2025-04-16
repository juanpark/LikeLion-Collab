package com.sec17.intro;
//압축된 .zip → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class a_ZipDecompression2 {
    public static void main(String[] args) {
        File gzipFile = new File("output.txt.zip");

        try (FileInputStream fis = new FileInputStream(gzipFile);
             ZipInputStream zipIn = new ZipInputStream(fis);
        		
             InputStreamReader reader = new InputStreamReader(zipIn, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {
        	
        	// Read a ZipEntry before reading (압축항목 확인)
        	ZipEntry entry = zipIn.getNextEntry();
        	
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

