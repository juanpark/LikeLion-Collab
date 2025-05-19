package com.test01;

public class Student {
	public void classWork() {
		System.out.println("줌인 합니다. 출석 확인.");
		try {
			//학습중  
			System.out.println("[학생] 큐알입실 완료, 수업 참여 중입니다.");
			System.out.println("[학생] 집중하여 학습합니다.");
		} catch (Exception e) {
			System.out.println("학습 중 오류가 발생했습니다.");
		} finally {
			System.out.println("[학생] 강의종료후 퇴실을 확인합니다."); //@After
		}
		System.out.println("줌로그아웃 합니다."); //@AfterReturning
	}
}
