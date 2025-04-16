package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.*;

//문자열 → ZIP 압축 → 파일 저장 
public class a_ZipCompression{
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java ZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;

        File gzipFile = new File("output.txt.zip");

        try (FileOutputStream fos = new FileOutputStream(gzipFile);
             ZipOutputStream zipOut = new ZipOutputStream(fos);
             OutputStreamWriter writer = new OutputStreamWriter(zipOut, StandardCharsets.UTF_8)) {

            // ✅ Add a ZipEntry before writing
            ZipEntry entry = new ZipEntry("output.txt");
            zipOut.putNextEntry(entry);
        	
            writer.write(data);
            writer.flush();
            zipOut.closeEntry();
            System.out.println(" 압축 완료: " + gzipFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
