package Work.WorkShop06.account;

public class Account {

    private String account;
    private int balance;
    private double interestRate;

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

    public Account()
    {
    }

    public Account( String account,int balance, double interestRate)
    {
        this.account = account;
        this.balance = balance;
        this.interestRate = interestRate;
    }


    public double calculateInterest()
    {
        //현재 잔액을 기준으로 이자를 계산 한다
        double interest = this.balance*this.interestRate/100;
        return interest;

    }

    public void deposit(int money)
    {
        //입금을 통해 잔액정보를 증가 시킨다

        this.balance+=money;
    }

    public void withdraw(int money)
    {
        //출금을 통해 잔액정보를 감소 시킨다
        //단, 출금을 통해 잔액이 0보다 작으면
        //“출금 할 수 없습니다”를 출력한다.

        if(this.balance-money<0)
            System.out.println("출금 할 수 없습니다.\n");
        else
            this.balance-=money;
    }

    public void prn()
    {
        System.out.println("계좌정보: "+this.account);
        System.out.println("현재 잔액: "+this.balance);
        System.out.println();
    }

    public void accountInfo()
    {
        System.out.printf("계좌번호: %s 잔액: %d원 이자율: %.2f\n",account,balance,interestRate);
    }

    public void accountInfo2()
    {
        System.out.printf("계좌번호: %s 잔액: %d원 이자율: %.2f 이자: %.0f\n",account,balance,interestRate, calculateInterest() );

    }






}
