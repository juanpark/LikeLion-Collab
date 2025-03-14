package com.sec11.myutil01;

import java.util.Arrays;
import java.util.Comparator;

// 나이 기준 정렬을 위한 Comparator 클래스
class MyAgeComparator implements Comparator<Person02> {
    @Override
    public int compare(Person02 o1, Person02 o2) {
        return o1.getAge()- o2.getAge(); 
    }
}

// Person02 클래스 정의
public class Person02{
    private int id;
    private int age;
    private String name;

    public int getId() { return id; }
    public int getAge() { return age; }
    public String getName() { return name; }

    public Person02(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", age=" + this.age + ", name=" + this.name + "]";
    }

    // 
    //public static Comparator<Person> AgeComparator = (p1, p2) -> p1.getAge()- p2.getAge();

    public static void main(String[] args) {
        Person02[] perArr = {
            new Person02(111, 25, "루세"),
            new Person02(333, 22, "루리"),
            new Person02(222, 35, "루오")
        };
        // 정렬 전 출력
        System.out.println("정렬 전:");
        for (Person02 res : perArr) {
            System.out.println(res);
        }
        // 나이 기준 정렬
        Arrays.sort(perArr, new MyAgeComparator());
        System.out.println("\n나이순 정렬 후:");
        for (Person02 res : perArr) {
            System.out.println(res);
        }
    }
}
