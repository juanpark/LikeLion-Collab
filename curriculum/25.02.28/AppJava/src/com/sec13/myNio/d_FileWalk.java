package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class d_FileWalk implements FileVisitor<Path> {

    private int depth = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        printIndent(depth);
        System.out.println("+ " + dir.getFileName());
        depth++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        printIndent(depth);
        System.out.println("- " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        printIndent(depth);
        System.err.println("! " + file.getFileName() + " (Failed)");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        depth--;
        return FileVisitResult.CONTINUE;
    }

    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
    }

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("d://test/");
        Files.walkFileTree(start, new d_FileWalk());
    }
}