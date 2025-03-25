package work.com.workshop9.com.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentTest_Stream {

	public static void main(String[] args) {
		
		Student s1 = new Student("홍길동", 15, 170, 80);
		Student s2 = new Student("한사람", 13, 180, 70);
		Student s3 = new Student("이순신", 16, 175, 65);
		
		List<Student> students = new ArrayList<>();
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		System.out.printf("%-5s %-2s %-2s  %-3s\n", "이름", "나이", "신장", "몸무게");
		students.stream().forEach(e -> System.out.println(e.studentInfo()));
		
		System.out.println();
		// student.stream() : List students streams a list of <Student> objects
		// .mapToInt(Student::getAge): which is converted to IntStream (primitive int values)
		// Student::getAge is a method reference, which is shorthand for a lambda expression
		// equivalent to: mapToInt(e -> e.getAge()
		System.out.printf("나이 평균: %.3f\n신장 평균: %.3f\n몸무게 평균: %.3f\n",
				students.stream().mapToInt(Student::getAge).average().orElse(0.0),
				students.stream().mapToInt(Student::getHeight).average().orElse(0.0),
				students.stream().mapToInt(Student::getWeight).average().orElse(0.0)
		);
		
		// .mapToInt(...).max()를 활용하면 <Student> 객체가 더 이상 접근 불가라서
		// .max(Comparator.comparing(Student::getHeight))은 객체를 다 불러온다
		// getHeight()로 비교하교 연결된 getName()을 호출할 수 있다.
		System.out.println();
		 
		students.stream()
	    	.max(Comparator.comparing(Student::getAge))
	    	.ifPresent(e -> System.out.println("나이가 가장 많은 학생: " + e.getName()));
		students.stream()
	    	.min(Comparator.comparing(Student::getAge))
	    	.ifPresent(e -> System.out.println("나이가 가장 적은 학생: " + e.getName()));
		students.stream()
	    	.max(Comparator.comparing(Student::getHeight))
	    	.ifPresent(e -> System.out.println("신장이 가장 큰 학생: " + e.getName()));
		students.stream()
	    	.min(Comparator.comparing(Student::getHeight))
	    	.ifPresent(e -> System.out.println("신장이 가장 작은 학생: " + e.getName()));
		students.stream()
	    	.max(Comparator.comparing(Student::getWeight))
	    	.ifPresent(e -> System.out.println("몸무게가 가장 많이 나가는 학생: " + e.getName()));
		students.stream()
	    	.min(Comparator.comparing(Student::getWeight))
	    	.ifPresent(e -> System.out.println("몸무게가 가장 적게 나가는 학생: " + e.getName()));
						
	}

}
