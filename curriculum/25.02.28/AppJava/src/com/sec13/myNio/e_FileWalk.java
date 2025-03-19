package com.sec13.myNio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class e_FileWalk extends SimpleFileVisitor<Path> {

    private BufferedWriter writer;

    public e_FileWalk(Path snapshotFile) throws IOException { //생성자
        this.writer = Files.newBufferedWriter(snapshotFile); // "snapshot.csv"로 쓰기 객체 생성
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {//파일 정보 
        String path = file.toString();
        long size = attrs.size();
        FileTime lastModified = attrs.lastModifiedTime();
        writer.write(path + "," + size + "," + lastModified + "\n");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public void close() throws IOException {
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("d://test");
        Path snapshotFile = Paths.get("snapshot.csv");
        e_FileWalk visitor = new e_FileWalk(snapshotFile); //FileVisitor를 implements한 e_FileWalk클래스에 넘겨
        												 // 4개의 메소드 재정의
        Files.walkFileTree(start, visitor); // (Path, FileVisitor)  //fileVisitor실행시킴
        									//visitor가  start(경로)를 알고 있음
        visitor.close();
        System.out.println("Snapshot created: " + snapshotFile);
    }
}