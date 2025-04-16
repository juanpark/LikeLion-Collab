package com.sec17.intro;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;

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

		executor.shutdown();
		executor.awaitTermination(10, TimeUnit.SECONDS);
	}
}
