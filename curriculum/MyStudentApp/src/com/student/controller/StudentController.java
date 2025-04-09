package com.student.controller;

import com.student.model.*;
import com.student.service.*;
import com.student.view.*;

import java.util.List;
import java.util.Scanner;

public class StudentController {
	private final StudentService service = new StudentServiceImpl();
	private final StudentConsoleView view = new StudentConsoleView();
	private final Scanner sc = new Scanner(System.in);
	
	public void run() {
		while(true) {
			System.out.println("[1: 전체 출력] [2: 추가] [3: 삭제] [4: 수정] [5: 찾기] [6: 저장] [7: 페이징] [0: 종료]");
			System.out.print("[입력]: ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1" :	view.showAllList(service.selectAllStudent());
						break;
			case "2" :	// input view에서 데이터 입력
						System.out.print("이름 : ");
						String name = sc.nextLine();
						System.out.print("전공 : ");
						String major = sc.nextLine();
						System.out.print("성적 : ");
						int grade = Integer.parseInt(sc.nextLine());
						// Student 객체 생성해서 데이터 저장
						Student s = new Student(name, major, grade);
						// controller student 객체 값을 service dao 전달
						int res = service.insertStudent(s);
						view.showMessage(res < 0 ? "입력 성공" : "입력 실패");
						break;
			case "3" :	// input view에서 데이터 입력
						System.out.print("삭제 할 이름 : ");
						String deleteName = sc.nextLine();
						Student sDelete = new Student();
						sDelete.setName(deleteName);
						view.showMessage(service.deleteStudent(sDelete) > 0 ?
								"삭제 성공" : "삭제 실패");
						break;
			case "4" : 	// input view에서 데이터 입력
						System.out.print("이름 : ");
						String upName = sc.nextLine();
						System.out.print("수정 할 전공 : ");
						String upMajor = sc.nextLine();
						System.out.print("수정 할 점수 : ");
						int upGrade = Integer.parseInt(sc.nextLine());
						// Student 객체 생성해서 데이터 저장
						Student sUpdate = new Student(upName, upMajor, upGrade);
						// controller student 객체 값을 service dao 전달
						int resUpdate = service.updateStudent(sUpdate);
						view.showMessage(resUpdate > 0 ? "수정 성공" : "수정 실패");
						break;
			case "5" :	System.out.print("검색할 이름 : ");
						String findName = sc.nextLine();
						Student sFind = new Student();
						sFind.setName(findName);
						
						Student found = service.searchByName(sFind);
						if (found != null) {
							view.showAllList(List.of(found));
						} else {
							view.showMessage("검색된 이름이 없습니다");
						}
						break;
			case "6" :	System.out.print("저장할 파일 이름을 입력하세요 : ");
						String fileName = sc.nextLine();
						view.saveToFile(service.selectAllStudent(), fileName);
						break;
			case "7" :	System.out.print("페이지 번호 : ");
						int page = Integer.parseInt(sc.nextLine());
						System.out.print("페이지 크기 : ");
						int size = Integer.parseInt(sc.nextLine());
						
						List<Student> pageList = service.getStudentByPage(page, size);
						view.showAllList(pageList);
						break;
						
			case "0" :	view.showMessage("종료합니다");
						return;
			default:	view.showMessage("유효한 선택이 아닙니다");
			}// switch end
		}// while end
	}// method end
}// class end
