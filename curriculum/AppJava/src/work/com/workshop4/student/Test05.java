package work.com.workshop4.student;

public class Test05 {

	public static void main(String[] args) {
		
		Student person1 = new Student("Kim", 100, 90, 95, 89);
		Student person2 = new Student("Lee", 60, 70, 99, 98);
		Student person3 = new Student("Kim", 68, 86, 60, 40);
		
		System.out.printf("%s  평균: %.2f  학점: %s학점\n", person1.getName(), person1.getAvg(), person1.getGrade());
		System.out.printf("%s  평균: %.2f  학점: %s학점\n", person2.getName(), person2.getAvg(), person2.getGrade());
		System.out.printf("%s  평균: %.2f  학점: %s학점\n", person3.getName(), person3.getAvg(), person3.getGrade());
	}

}

