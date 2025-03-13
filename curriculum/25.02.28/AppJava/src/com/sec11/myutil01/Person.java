package com.sec11.myutil01;


import java.util.Arrays;
import java.util.Comparator;

public class Person implements Comparable<Person> {

   private int id;
   private int age;
   private String name;

   public int getId() {
       return id;
   }
  

   public int getAge() {
       return age;
   }

   public String getName() {
       return name;
   }

   public Person(int id,  int age, String name) {
       this.id = id;     
       this.age = age;
       this.name = name;
   }

   @Override
   public int compareTo(Person m_p) {      
       return (this.id - m_p.id);
   }

   @Override

   public String toString() {
       return "[id=" + this.id +  ", age=" + this.age + ", name=" +
               this.name + "]";
   }

   
   public static Comparator<Person> IdComparator = new Comparator<Person>() {
       @Override
       public int compare(Person p1, Person p2) {
           return (p1.getId() - p2.getId());
       }
   };
   
   public static Comparator<Person> AgeComparator = new Comparator<Person>() {	  
       @Override
       public int compare(Person p1, Person p2) {
           return p1.getAge() - p2.getAge();
       }
   };

	public static void main(String[] args) {
		
		Person[] perArr = new Person[3];
		perArr[0] = new Person(111, 25, "루세");
		perArr[1] = new Person(333,  22, "루리");
		perArr[2] = new Person(222,  35, "루오");
		
		Arrays.sort(perArr);
        System.out.println("기본 정렬 :\n" + Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.AgeComparator);        
        System.out.println("나이순으로 정렬:\n"+Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.IdComparator);
        System.out.println("Id 순으로 정렬:\n"+Arrays.toString(perArr));

	}

}
