package com.sec13.myNio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class c_FileWalk {

	public static void main(String[] args) {
		Path startPath = Paths.get("."); // 현재 디렉토리부터 순회

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
	}
}