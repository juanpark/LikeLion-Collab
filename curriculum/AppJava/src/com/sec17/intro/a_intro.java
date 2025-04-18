package com.sec17.intro;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;

// 웹페이지 요청한 후 페이지를 다운로드 받아서 출력 해보자
// [1] 가상 스레드
// [2] URL 주소 요청 openStream()
// [3] executor.awaitTermination(10, TimeUnit.SECONDS); // 10초후 완전히 종료 요청 
// [4] GZIPInputStream() .gz 확장자 압축 파일을 풀어보자

public class a_intro {
	public static void main(String[] args) throws InterruptedException {

		String urlString = "https://www.python.org";

		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

		executor.submit(() -> { // 실행
			try {
				URL url = URI.create(urlString).toURL();

				// GZIP 압축 해제 후 UTF-8로 읽기
				try (InputStream rawStream = url.openStream();
						InputStream decodedStream = new GZIPInputStream(rawStream);
						BufferedReader reader = new BufferedReader(
								new InputStreamReader(decodedStream, StandardCharsets.UTF_8))) {

					System.out.println("\n [웹 페이지 내용 시작]");
					String line;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}
					System.out.println(" [웹 페이지 내용 끝]");
				}
			} catch (Exception e) {
				System.err.println("오류 발생: " + e.getMessage());
			}
		});

		executor.shutdown(); // 종료요청
		executor.awaitTermination(10, TimeUnit.SECONDS); // 10초후 완전호 종료 해줘
	}
}
