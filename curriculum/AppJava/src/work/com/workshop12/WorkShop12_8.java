package work.com.workshop12;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkShop12_8 {

	public static void main(String[] args) {
		
		List<String> data = List.of(
				"홍길동,5000000",
				"이순신,6500000",
				"유관순,4800000",
				"강감찬,7000000",
				"신사임당,5500000"
				);
		
		Map<String, Integer> mapData = new HashMap<>();
		mapData = data.stream()
					.map(e -> e.split(","))
					.filter(e -> Integer.parseInt(e[1]) >= 5000000)
					.collect(Collectors.toMap(
							e -> e[0],
							e -> Integer.parseInt(e[1])
					));
	
		mapData.forEach((key,value) -> {
			System.out.println(key+": " + value);
		});
		
		List<String> textLines = 
			mapData.entrySet().stream()
				.map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
				.toList();
		
				
		// NIO2 파일생성 후 employee_salary.txt 저장
		Path fp = Path.of("employee_salary.txt");
		try {
			Files.write(
					fp, 
					textLines,
					StandardOpenOption.CREATE
			);
			System.out.println("계좌정보 " + fp + "에 저장되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read all lines from a text to a List
		try {
			List<String> readFile = Files.readAllLines(fp);
			System.out.println();
			System.out.println("=== 파일 내용 ===");
			for (String line : readFile) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read file as a single String
		try {
			String readFile2 = Files.readString(fp);
			System.out.println();
			System.out.println("=== 파일 내용2 ===");
			System.out.println(readFile2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read file using a BufferedReader
		try (BufferedReader reader = Files.newBufferedReader(fp)){
			String readFile3;
			System.out.println();
			System.out.println("=== 파일 내용3 ===");
			while ((readFile3 = reader.readLine()) != null) {
				System.out.println(readFile3);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
