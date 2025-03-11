package Work.WorkShop06.account;

public class AccountTest2 {
    public static void main(String[] args) {

// 5개의 Account 형 객체 배열 선언
// for문을 이용하여 Account 객체를 생성 후 배열에 저장
// for문을 이용하여 Account 정보 출력
// for문을 이용하여 이자율을 변경하고 Account 정보와 이자를 화면에 출력

        Account[] accounts = new Account[5];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(String.format("221-0101-211%d", i + 1), 100000, 4.5);
            accounts[i].accountInfo();
        }

        for (int i = 0; i < accounts.length; i++) {
            accounts[i].setInterestRate(3.7);
            accounts[i].accountInfo2();
        }



    }
}
