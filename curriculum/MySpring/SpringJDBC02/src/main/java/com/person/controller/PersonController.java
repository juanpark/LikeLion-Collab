package com.person.controller;

import com.person.model.*;
import com.person.service.*;
import com.person.view.*;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//view   -> controller -> model (service(biz, dao))  -> db
@Controller
public class PersonController {

	private final PersonService service;
	private final PersonConsolView view;
	private final Scanner sc = new Scanner(System.in);


	public PersonController(PersonService service, PersonConsolView view) {
		this.service = service;
		this.view = view;
	}

	public void run() {
		// 메뉴 생성 = 페이지 이동
		while (true) {
			System.out.println(" 1.전체 출력   |  2.추가  | 3.삭제 | 4. 수정 | 5. 찾기| 6.파일저장 |7.페이징  | 0. 종료");
			String menu = sc.nextLine();
			switch (menu) {
			case "1": // 서비스 컴포넌트가 받은 dao의 결과를 view에게 전달
				view.showAllList(service.selectAllPerson());
				break;
			case "2":
				// 1. input view에서 데이터 입력
				System.out.print("이름 :");
				String name = sc.nextLine();

				System.out.print("주소 :");
				String address = sc.nextLine();

				System.out.print("전화번호 :");
				String phone = sc.nextLine();

				// 2. Person 객체 생성해서 데이터 저장
				Person p = new Person(name, address, phone);

				// 3. controller person객체 값을 service dao 전달
				// if(service.searchByName(p) != null )  {  입력한 이름이 존재하면 차단하겠다 코드....}   
				int res = service.insertPerson(p);
				view.showMessage(res > 0 ? "입력성공" : "실패");
				break;

			case "3": // 삭제
				System.out.print("삭제 할 이름 :");
				String delete_name = sc.nextLine();
				Person p0 = new Person();
				p0.setName(delete_name);
				view.showMessage(service.deletePerson(p0) > 0 ? "삭제성공" : "실패");

				break;
			case "4": // update
				// 1. input view에서 데이터 입력
				System.out.print("이름 :");
				String uname = sc.nextLine();

				System.out.print("수정 주소 :");
				String uaddress = sc.nextLine();

				System.out.print("수정 전화번호 :");
				String uphone = sc.nextLine();

				// 2. Person 객체 생성해서 데이터 저장
				Person p02 = new Person(uname, uaddress, uphone);

				// 3. controller person객체 값을 service dao 전달
				int res02 = service.updatePerson(p02);
				view.showMessage(res02 > 0 ? "수정성공" : "실패");
				break;
			case "5":
				System.out.print("검색할 이름:");
				String find_name = sc.nextLine();
				Person p03 = new Person();
				p03.setName(find_name);

				Person found = service.searchByName(p03);
				
				if (found != null) 	view.showAllList(List.of(found));
				else view.showMessage("검색된 이름의 결과가 없어!!!");			
				
				break;
			case "6"://파일 저장
				System.out.print("저장할 파일을 입력하세요 :"); 
				String file_name = sc.nextLine();
				view.saveToFile(service.selectAllPerson(),file_name);
				break;
				
			case "7"://페이징 처리   -> 페이지번호와 크기를 입력해서 해당 범위의 목록을 리턴받자. 
				// select  * from person LIMIT  ?  OFFSET ? ; 
				System.out.print("페이지 번호" );
				int page  =Integer.parseInt(sc.nextLine());
				System.out.print("페이지 크기:"); 
				int size  = Integer.parseInt(sc.nextLine());
				
				List<Person> pageList = service.getPersonByPage(page, size);
				view.showAllList(pageList);
				break;				
				
			case "0":
				view.showMessage("종료합니다.");
				return;
			default:
				view.showMessage("입력 잘못했어");
			}// switch
		} // while end
	}// mothod end
}// class end
