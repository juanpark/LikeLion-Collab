package Work.WorkShop06.account;

public class AccountTest {
    public static void main(String[] args) {
// account 객체 생성
// account 기본 정보 출력
// account 에서 600000원 출금
// account 에 20000원 입금
// account 변경 정보 출력
// 이자 출력 – 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력 한다

    Account account = new Account("441-0290-1203", 500000,7.3);
    account.prn();
    account.withdraw(600000);
    account.deposit(20000);
    account.prn();
        System.out.println("이자: "+account.calculateInterest());





    }
}
