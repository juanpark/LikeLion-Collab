package work.com.workshop12.workshop.acc;

public class Account {
	
	private String 	account;
	private double	balance;
	private double	interestRate;
	
	public Account() {}

	public Account(String account, double balance, double interestRate) {
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return this.balance * (this.interestRate * 0.01);
	}
	
	public void deposit(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("입금 금액은 음수일 수 없습니다");
		} else {
			this.balance += money;
		}
	}
	
	public void withdraw(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("출금 금액은 음수일 수 없습니다");
		} else if (this.balance - money < 0){
			throw new IllegalArgumentException("잔액이 0 이하가 될 수 없습니다");
		} else {
			this.balance -= money;
		}
	}

	@Override
	public String toString() {
		return String.format("계좌정보: %s %.1f %.1f", this.account, this.balance, this.interestRate);
	}

	public String getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	
	
}
