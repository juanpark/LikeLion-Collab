package work.com.workshop6.account;

public class Account {
	private String 	account;
	private int 	balance;
	private double	interestRate;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		return this.balance * (this.interestRate) * 0.01;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) {
		if ((this.balance - money) < 0) {
			System.out.println("출금 할 수 없습니다.");
		} else {
			this.balance -= money;
		}
	}
	
	public void accountInfo() {
		System.out.printf("계좌번호: %s 잔액: %d원  이자율: %.1f%%\n", this.getAccount(), this.getBalance(), this.interestRate);
	}
	
	

}
