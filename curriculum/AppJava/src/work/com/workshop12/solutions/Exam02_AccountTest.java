package work.com.workshop12.solutions;

public class Exam02_AccountTest {
    public static void main(String[] args) {
        // 계좌 객체 생성 (테스트용 데이터 입력)
        Account acc = new Account("441-0290-1203", 500000.0, 0.073);

        System.out.println("계좌정보: " + acc.getAccount() + " " + acc.getBalance() + " " + acc.getInterestRate());

        // 입금 테스트 - 0보다 작은 금액 예외 발생
        try {
            acc.deposit(-100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 출금 테스트 - 0보다 적거나 잔액보다 많은 경우 예외 발생
        try {
            acc.withdraw(600000); // 현재 잔액보다 많은 금액 출금 시도
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 이자 계산
        double interest = acc.calculateInterest();
        System.out.println("이자: " + interest);
    }
}
