package com.person.controller;

import com.person.model.*;
import com.person.service.*;
import com.person.view.*;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// view -> controller -> model (service(biz, dao)) -> db
@Controller
public class PersonController {
	private final PersonService service;
	private final PersonConsoleView view;
	private final Scanner sc = new Scanner(System.in);
	
	@Autowired
	public PersonController(PersonService service, PersonConsoleView view) {
		this.service = service;
		this.view = view;
	}
	
	public void run() {
		// 메뉴 생성 = 페이지 이동
		while(true) {
			System.out.println(" 1. 전체 출력  | 2. 추가 | 3. 삭제  | 4. 수정 | 5. 찾기 | 6. 저장 | 7. 페이징 | 0. 종료 ");
			System.out.print("입력: ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1" : // 서비스 컴포넌트가 받은 dao의 결과를 view에게 전달
						view.showAllList(service.selectAllPerson());
						break;
			case "2" : 
						// 1. input view에서 데이터 입력
						System.out.print("이름 : ");
						String name = sc.nextLine();
						System.out.print("주소 : ");
						String address = sc.nextLine();
						System.out.print("전화 : ");
						String phone = sc.nextLine();
						
						// 2. Person 객체 생성해서 데이터 저장
						Person p = new Person(name, address, phone);
						
						// 3. controller person객체 값을 service dao 전달 
						int res = service.insertPerson(p);
						view.showMessage(res > 0 ? "입력 성공" : "입력 실패");
						break;
			case "3" : 
						// input view에서 데이터 입력
						System.out.print("삭제 할 이름 : ");
						String delete_name = sc.nextLine();
						Person p0 = new Person();
						p0.setName(delete_name);
						view.showMessage(service.deletePerson(p0) > 0 ? "삭제 성공" : "삭제 실패");
						break;
			case "4" : 
						// 1. input view에서 데이터 입력
						System.out.print("이름 : ");
						String uname = sc.nextLine();
						System.out.print("수정 할 주소 : ");
						String uaddress = sc.nextLine();
						System.out.print("수정 할 전화 : ");
						String uphone = sc.nextLine();
						
						// 2. Person 객체 생성해서 데이터 저장
						Person p02 = new Person(uname, uaddress, uphone);
						
						// 3. controller person객체 값을 service dao 전달 
						int res02 = service.updatePerson(p02);
						view.showMessage(res02 > 0 ? "입력 성공" : "입력 실패");
						break;
			case "5" : 
						System.out.print("검색할 이름: ");
						String find_name = sc.nextLine();
						Person p03 = new Person();
						p03.setName(find_name);
						
						Person found = service.searchByName(p03);
						
						if (found != null) {
							view.showAllList(List.of(found));
						} else {
							view.showMessage("검색된 이름의 결과가 없어!");
						}
						break;
			case "6" :	// 파일 저장
						System.out.print("저장할 파일을 입력하세요 : ");
						String file_name = sc.nextLine();
						view.saveToFile(service.selectAllPerson(), file_name);
						break;
			case "7" :	// 페이징 처리 -> 페이지 번호와 크기를 입력해서 해당 범위의 목록을 리탄 받자.
						// select * from person LIMIT ? OFFSET ?;
						// page = (page - 1) * size 페이징 공식
						// 만일 page = 2, size = 10
						System.out.print("페이지 번호");
						int page = Integer.parseInt(sc.nextLine());
						System.out.print("페이지 크기");
						int size = Integer.parseInt(sc.nextLine());
						
						List<Person> pageList = service.getPersonByPage(page, size);
						view.showAllList(pageList);
						break;
			case "0" : 
						view.showMessage("종료합니다.");
						return;
			default : 
						view.showMessage("입력 잘못했어");
			} // switch end
			
			
		}//while end
		
	}//method end
}//class end
