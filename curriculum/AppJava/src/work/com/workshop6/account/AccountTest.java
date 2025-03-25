package work.com.workshop6.account;

public class AccountTest {

	public static void main(String[] args) {
		
		Account accnt1 = new Account("441-0290-1203", 500000, 7.3);
		
		System.out.printf("계좌정보:%s 현재잔액: %d\n", accnt1.getAccount(), accnt1.getBalance());
		
		accnt1.withdraw(600000);
		
		accnt1.deposit(20000);
		
		System.out.printf("계좌정보:%s 현재잔액: %d\n", accnt1.getAccount(), accnt1.getBalance());

		System.out.printf("이자: %.1f\n", accnt1.calculateInterest());
		
	}

}
