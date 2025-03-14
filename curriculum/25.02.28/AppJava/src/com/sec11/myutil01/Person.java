package com.sec11.myutil01;

// Person 객체 배열을 Comparable 인터페이스와 Comparator 인터페이스를 활용하여 다양한 기준으로 정렬해보자.

import java.util.Arrays;
import java.util.Comparator;

//public class Person implements Comparable<Person> {
//public class Person implements Comparable {
public class Person implements Comparable<Person> {    // 제네릭스 타입을 명시 Comparable<T>

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

	
	  // this.id - m_p.id의 결과가 양수이면 this가 더 크고 음수이면 this가 더 작다
   	  // 음수(-) -> this 앞에 배치된다.
   	  // 양수(+) -> this 뒤에 배치된다.
      // 0 -> 순서 변동이 없다.
   	  // compareTo(루세, 루리) = 111 - 333 = -222 -> 유지
   	  // compareTo(루리,루오) = 333 - 222 = 111 -> 루오와 루리가 교환
   	  // compareTo(루세, 루리) = 111 - 222 = -111 -> 유지 
	  @Override 
	  public int compareTo(Person m_p) { // Dual-Pivot QuickSort 
		  return (this.id - m_p.id); // 현재 객체 this와 비교 대상 m_p의 id값을 비교 }
	  }
	  
	 
   
	/*
	 * @Override public int compareTo(Object o) { 
	 * 		return this.id = ((Person)o).id; 
	 * }
	 */
	

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
		
		System.out.println("정렬 전 ");
		
		for (Person res : perArr) {
			System.out.print( res + ", " );
		}
		System.out.println();
		
		Arrays.sort(perArr); // sort(Object[] a)  // compareTo()를 호출 
        System.out.println("기본 정렬 :\n" + Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.AgeComparator);        
        System.out.println("나이순으로 정렬:\n"+Arrays.toString(perArr));
         
   
        Arrays.sort(perArr, Person.IdComparator);
        System.out.println("Id 순으로 정렬:\n"+Arrays.toString(perArr));

	}







}
