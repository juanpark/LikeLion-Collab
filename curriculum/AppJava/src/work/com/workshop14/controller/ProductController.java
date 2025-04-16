package work.com.workshop14.controller;

import work.com.workshop14.model.*;
import work.com.workshop14.service.*;
import work.com.workshop14.view.*;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	private final ProductService service = new ProductServiceImpl();
	private final ProductConsoleView view = new ProductConsoleView();
	private final Scanner sc = new Scanner(System.in);
	
	public void run() {
		while(true) {
			System.out.println("\n==================== Workshop 14 ====================\n");
			System.out.println(
					"[1: 문제4-1(쿼리)] [2: 문제4-2(쿼리)]\n\n" +
					"[3: 문제4-3(폐기물 테이블 생성)] [7: 폐기물 테이블 드랍]\n\n" +
					"[4: 문제4-4(폐기물 열 삽입)] [5: 문제4-5(폐기물 열 삭제)]\n\n" +
					"[8: 폐기물 테이블 열람] [9: 제품 테이블 전체 출력] [0: 종료]\n");
			System.out.print("[입력]: ");
			String select = sc.nextLine();
			
			switch (select) {
			case "9" ->	view.printTable(service.selectAllProducts());
			
			case "1" -> view.printTable(service.problem4_1());
			
			case "2" -> view.printTable(service.problem4_2());
			
			case "3" -> view.createTable(service.problem4_3());
			
			case "4" -> view.insertRow(service.problem4_4());
			
			case "5" -> view.deleteRow(service.problem4_5());
			
			case "7" -> view.deleteTable(service.dropDiscarded());
			
			case "8" -> view.printTable(service.selectAllDiscarded());
			
			case "0" ->	{
							view.showMessage("종료합니다");
							return;
						}
			default ->	view.showMessage("유효한 선택이 아닙니다");
			}//end switch
		}//end while loop		
	}//end run method
}
