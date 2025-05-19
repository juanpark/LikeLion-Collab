package com.test01;

public class G7_Class {
	public void classWork() {
		System.out.println("[강사] 멋쟁이사자에서 스프링 강의를 위해 줌 로그인합니다.");
		try {
			// 스레드 생성
			System.out.println("[강사] 스레드를 만들어 실습 환경을 구성합니다.");
			System.out.println("[강사] 비대면 스프링 강의를 시작합니다.");
		} catch (Exception e) {
			System.out.println("[강사] 강의 중 오류가 발생했습니다.");
		} finally {
			System.out.println("[강사] 강의종료후 퇴실을 확인합니다.");
		}
		System.out.println("[강사] 줌 로그아웃합니다.");
	}
}
