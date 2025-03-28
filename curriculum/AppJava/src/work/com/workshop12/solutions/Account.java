package work.com.workshop12.solutions;
public class Account {
    private String account;
    private double balance;
    private double interestRate;

    // 기본 생성자
    public Account() {}

    // 3개의 클래스 변수를 받는 생성자
    public Account(String account, double balance, double interestRate) {
        this.account = account;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    // 이자 계산 메서드
    public double calculateInterest() {
        return balance * interestRate;
    }

    // 입금 메서드
    public void deposit(double money) throws Exception {
        if (money <= 0) {
            throw new Exception("입금 금액이 0보다 적습니다.");
        }
        balance += money;
    }

    // 출금 메서드
    public void withdraw(double money) throws Exception {
        if (money <= 0 || money > balance) {
            throw new Exception("출금 금액이 0보다 적거나 현재 잔액보다 많습니다.");
        }
        balance -= money;
    }

    // Getter
    public double getBalance() {
        return balance;
    }

    public String getAccount() {
        return account;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
