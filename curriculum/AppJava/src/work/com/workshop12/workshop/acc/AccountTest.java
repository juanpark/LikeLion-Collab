package work.com.workshop12.workshop.acc;

import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class AccountTest {

	public static void main(String[] args) {
		
		// account 객체 생성
		Account my = new Account("441-0290-1203", 500000, 7.3);
		
		// account 기본 정보 출력
		System.out.println(my);

		// account에 -10원 입금 > Exception 처리
		// my.deposit(-10);
		
		// account에 600000원 출금 > Exception 처리
		// my.withdraw(600000);
		
		System.out.println("이자: " + my.calculateInterest());
		
		// 저장할 내용 생성
		String toFile = String.format("계좌번호: %s\n현재잔고: %.1f\n이자: %.1f", 
									my.getAccount(), my.getBalance(), my.calculateInterest());
		
		
		// NIO2 파일생성 후 account_output.txt 저장
		Path fp = Path.of("account_output.txt");
		try {
			Files.write(
					fp, 
					toFile.getBytes(),
					StandardOpenOption.CREATE
			);
			System.out.println("계좌정보 " + fp + "에 저장되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
