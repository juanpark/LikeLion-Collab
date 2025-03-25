package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class c_FileWalk {

	public static void main(String[] args) throws IOException {
		Path startPath = Paths.get("."); // 현재 디렉토리(AppJava)부터 순회( ex) D드라이브를 주면 D와 하위 디렉토리 모두 순회)
		
		System.out.println("--- 모든 파일 및 디렉토리 출력 ---");
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- 특정 깊이까지만 순회 (최대 깊이 2) ---");
		try (Stream<Path> stream = Files.walk(startPath, 2)) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n--- 특정 확장자를 가진 파일만 찾기 ---");
		String fileExtension = ".java";
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // 파일만 필터링
					.filter(path -> path.toString().endsWith(fileExtension)) // 특정 확장자 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n--- a_로 시작하는 파일만 찾기 ---");
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // (정규파일)일반 파일만 필터링
					.filter(path -> path.getFileName().toString().startsWith("a_")) // 특정 확장자 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		System.out.println("\n--- a_로 시작하고 .java확장자인 파일만 찾기 ---");
		try (Stream<Path> stream = Files.walk(startPath)) {
			stream.filter(Files::isRegularFile) // (정규파일)일반 파일만 필터링
					.filter(path -> path.getFileName().toString().startsWith("a")) // 특정 확장자 필터링
					.filter(path -> path.getFileName().toString().endsWith(".java")) // 특정 확장자 필터링
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}			
		
		
		
		Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				return super.preVisitDirectory(dir, attrs);
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				return super.visitFile(file, attrs);
			}

			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				// TODO Auto-generated method stub
				return super.visitFileFailed(file, exc);
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				// TODO Auto-generated method stub
				return super.postVisitDirectory(dir, exc);
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}