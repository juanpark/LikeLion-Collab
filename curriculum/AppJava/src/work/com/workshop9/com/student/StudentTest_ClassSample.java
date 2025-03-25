package work.com.workshop9.com.student;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import static java.util.Comparator.comparingInt;

class StudentSample {
	private String name;
	private int age;
	private int height;
	private int weight;

	public StudentSample(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public void studentInfo() {
		System.out.println(name + "\t" + age + "\t" + height + "\t" + weight);
	}
}

public class StudentTest_ClassSample {
	public static void main(String[] args) {
		List<StudentSample> students = Arrays.asList(new StudentSample("홍길동", 15, 170, 80), new StudentSample("한사람", 13, 180, 70),
				new StudentSample("이순신", 16, 175, 65));

		System.out.println("이름\t나이\t신장\t몸무게");

		for (StudentSample student : students) {
			student.studentInfo();
		}

		////////////////////////////////////////////////////////
		
		OptionalDouble averageAge = students.stream().mapToInt(StudentSample::getAge).average();
		OptionalDouble averageHeight = students.stream().mapToInt(StudentSample::getHeight).average();
		OptionalDouble averageWeight = students.stream().mapToInt(StudentSample::getWeight).average();

		System.out.printf("\n\n나이 평균: %.3f\n", averageAge.orElse(0));
		System.out.printf("신장 평균: %.3f\n", averageHeight.orElse(0));
		System.out.printf("몸무게 평균: %.3f\n", averageWeight.orElse(0));

		//////////////////////////////////////////////////////// 
		StudentSample youngestStudent = students.stream().min(comparingInt(StudentSample::getAge)).orElse(null);
		StudentSample oldestStudent = students.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
				.orElse(null);

		System.out.println("\n\n나이가 가장 많은 학생: " + oldestStudent.getName());
		System.out.println("나이가 가장 적은 학생: " + youngestStudent.getName());

		//////////////////////////////////////////////////////////////////
		StudentSample shortestStudent = students.stream().min(comparingInt(StudentSample::getHeight)).orElse(null);
		StudentSample tallestStudent = students.stream().max(comparingInt(StudentSample::getHeight)).orElse(null);

		System.out.println("신장이 가장 큰 학생: " + tallestStudent.getName());
		System.out.println("신장이 가장 작은 학생: " + shortestStudent.getName());

		//////////////////////////////////////////////////////////////////
		StudentSample lightestStudent = students.stream().min(comparingInt(StudentSample::getWeight)).orElse(null);
		StudentSample heaviestStudent = students.stream().max(comparingInt(StudentSample::getWeight)).orElse(null);

		System.out.println("몸무게가 가장 많이 나가는 학생: " + heaviestStudent.getName());
		System.out.println("몸무게가 가장 적게 나가는 학생: " + lightestStudent.getName());
	}
}
