package work.com.workshop12.solutions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Exam02_FileTest {
    public static void main(String[] args) {
        // 계좌 객체 생성
        Account acc = new Account("441-0290-1203", 500000.0, 0.073);

        // 이자 계산
        double interest = acc.calculateInterest();

        // 저장할 내용 구성
        StringBuilder sb = new StringBuilder();
        sb.append("계좌번호: ").append(acc.getAccount()).append("\n");
        sb.append("현재 잔고: ").append(acc.getBalance()).append("\n");
        sb.append("이자: ").append(interest).append("\n");

        // NIO.2로 파일 저장
        Path filePath = Path.of("account_output.txt");

        try {
            Files.writeString(filePath, sb.toString(), 
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("파일 저장 완료: account_output.txt");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }
}
