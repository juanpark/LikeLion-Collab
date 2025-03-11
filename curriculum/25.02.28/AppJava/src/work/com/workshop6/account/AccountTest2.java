package work.com.workshop6.account;

public class AccountTest2 {

	public static void main(String[] args) {
		
		Account[] accnt = new Account[5];
		
		for (int i = 0; i < accnt.length; i++) {
			accnt[i] = new Account("221-0101-211" + (i + 1), 100000, 4.5);
		}
		
		
		for (Account rows : accnt) {
			rows.accountInfo();
			System.out.println();
		}

		for (Account rows : accnt) {
			rows.setInterestRate(3.7);
		}
		
		for (Account rows : accnt) {
			rows.accountInfo();
			System.out.printf("  이자: %.0f원\n", rows.calculateInterest());
		}
		

	}

}
