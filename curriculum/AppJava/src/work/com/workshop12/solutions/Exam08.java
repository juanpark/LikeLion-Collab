package work.com.workshop12.solutions;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exam08 {
    public static void main(String[] args) {
        // 1. 초기 데이터
        List<String> data = List.of(
                "홍길동,5000000",
                "이순신,6500000",
                "유관순,4800000",
                "강감찬,7000000",
                "신사임당,5500000"
        );

        // 2. Stream으로 필터링 (급여 500만 이상), Map으로 변환 (이름 -> 급여)
        Map<String, Integer> salaryMap = data.stream()
                .map(s -> s.split(","))
                .filter(arr -> Integer.parseInt(arr[1]) >= 5000000)
                .collect(Collectors.toMap(
                        arr -> arr[0],               // key: 이름
                        arr -> Integer.parseInt(arr[1]) // value: 급여
                ));

        // 3. 이름 순 정렬 (TreeMap 사용)
        Map<String, Integer> sortedMap = new TreeMap<>(salaryMap);

        // 4. 화면 출력
        sortedMap.forEach((name, salary) -> 
                System.out.println(name + ": " + salary));

        // 5. NIO.2로 파일 저장
        Path filePath = Paths.get("employee_salary.txt");
        String fileContent = sortedMap.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining("\n"));

        try {
            Files.writeString(filePath, fileContent, 
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("\n=== 파일 저장 완료 ===");
        } catch (IOException e) {
            System.out.println("파일 저장 오류: " + e.getMessage());
        }

        // 6. 파일 읽어서 출력
        try {
            System.out.println("\n=== 파일 내용 ===");
            System.out.println(Files.readString(filePath));
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}
