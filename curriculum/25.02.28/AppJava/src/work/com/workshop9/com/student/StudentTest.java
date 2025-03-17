package work.com.workshop9.com.student;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 15, 170, 80);
		Student s2 = new Student("한사람", 13, 180, 70);
		Student s3 = new Student("이순신", 16, 175, 65);
		
		List<Student> students = new ArrayList<>();
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		System.out.printf("%-5s %-2s %-2s  %-3s\n", "이름", "나이", "신장", "몸무게");
		for (Student student : students) {
			System.out.println(student.studentInfo());
		}
		
		int age = 0, height = 0, weight = 0;
		for (Student student : students) {
			age += student.getAge();
			height += student.getHeight();
			weight += student.getWeight();
		}
		
		int listSize = students.size();
		System.out.println();
		System.out.printf("나이 평균: %.3f\n", (double) age / listSize);
		System.out.printf("신장 평균: %.3f\n", (double) height / listSize);
		System.out.printf("몸무게 평균: %.3f\n", (double) weight / listSize);
		
		int ageMin, ageMax; 
		ageMin = ageMax = s1.getAge();
		String ageMinName = s1.getName();
		String ageMaxName = s1.getName();
		
		int heightMin, heightMax;
		heightMin = heightMax = s1.getHeight();
		String heightMinName = s1.getName();
		String heightMaxName = s1.getName();
		
		int weightMin, weightMax;
		weightMin = weightMax = s1.getWeight();
		String weightMinName = s1.getName();
		String weightMaxName = s1.getName();
		
		for (Student student : students) {
			if (student.getAge() < ageMin) { 
				ageMin = student.getAge();
				ageMinName = student.getName();
			}
			if (student.getAge() > ageMax) {
				ageMax = student.getAge();
				ageMaxName = student.getName();
			}
			if (student.getHeight() < heightMin) { 
				heightMin = student.getHeight();
				heightMinName = student.getName();
			}
			if (student.getHeight() > heightMax) {
				heightMax = student.getHeight();
				heightMaxName = student.getName();
			}
			if (student.getWeight() < weightMin) { 
				weightMin = student.getWeight();
				weightMinName = student.getName();
			}
			if (student.getWeight() > weightMax) {
				weightMax = student.getWeight();
				weightMaxName = student.getName();
			}
		}
		
		System.out.println();
		System.out.println("나이가 가장 많은 학생: " + ageMaxName);
		System.out.println("나이가 가장 적은 학생: " + ageMinName);
		System.out.println("신장이 가장 큰 학생: " + heightMaxName);
		System.out.println("신장이 가장 작은 학생: " + heightMinName);
		System.out.println("몸무게가 가장 많이 나가는 학생: " + weightMaxName);
		System.out.println("몸무게가 가장 적게 나가는 학생: " + weightMinName);

	}

}
