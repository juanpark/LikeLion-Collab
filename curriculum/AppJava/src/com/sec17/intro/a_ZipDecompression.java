package com.sec17.intro;
//압축된 .zip → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

public class a_ZipDecompression {
    public static void main(String[] args) {
        File gzipFile = new File("output.txt.zip");

        try (FileInputStream fis = new FileInputStream(gzipFile);
             ZipInputStream gzipIn = new ZipInputStream(fis)) { // 폴더
        		
        	ZipEntry entry = null; // 파일
        	
        	while((entry = gzipIn.getNextEntry()) != null) {
        		System.out.println("압축 헤제 중: " + entry.getName());
        	
        		BufferedReader br = new BufferedReader(new InputStreamReader(gzipIn, StandardCharsets.UTF_8));
             
        		String line = null;
        		
        		while((line = br.readLine()) != null) {
        			System.out.println(line);
        		}
        		gzipIn.closeEntry();
        	}
        		
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

