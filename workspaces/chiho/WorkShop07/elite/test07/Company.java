package Work.WorkShop07.elite.test07;

import java.util.HashMap;

public class Company {

    public static void main(String[] args) {

        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        // 1번의 데이터를 기반으로 객체를 생성 하여 HashMap에 넣는다.
        // HashMap에 넣을 때 키 값은 각 객체의 Number로 한다.
        // 모든 객체의 기본 정보를 출력한다 (for문을 이용하여 출력한다.)
        // 모든 객체에 인센티브 100씩 지급한다.
        // 모든 객체의 정보 와 세금을 출력한다 (for문을 이용하여 출력한다.)


        Employee hilery = new Secretary("Hilery", 1, "secretary", 800);
        Employee Clinten = new Sales("Clinten", 2, "Sales", 1200);
        map.put(hilery.getNumber(), hilery);
        map.put(Clinten.getNumber(), Clinten);


        System.out.println("\n초기 직원 정보");
        System.out.println(" name       | department       | salary        |");
        System.out.println("+------------+------------+------------+");
        for (Employee e : map.values()) {
            e.printInfoWithoutTax();
        }

        System.out.println();
        System.out.println("인센티브 100 지급");

        for (Employee e : map.values()) {
            e.incentive(100);
        }


        System.out.println("\nname       department  salary     tax");
        System.out.println("--------------------------------------------");

        for (Employee e : map.values()) {
            e.printInfoWithTax();


        }
    }}
