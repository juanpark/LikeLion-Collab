package work.com.workshop14.workshop;

import work.com.workshop14.controller.ProductController;

public class Test01 {
	// 메뉴에서 [2: 문제4-1] 선택하기 
   	public static void main(String[] args) {
    	new ProductController().run(); 
    }
}
/*
제품이 생산된 공장위치가 "SEOUL"인 제품 중 판매점에 재고가 없는 상품을 출력한다.
조건:
1) 재고가 없는 조건은 재고 수량이 0이거나 null을 의미한다.
2) null인 경우 “0” 표시 한다. 
 */
