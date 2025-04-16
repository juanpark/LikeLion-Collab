package work.com.workshop14.workshop;

import work.com.workshop14.controller.ProductController;

public class Test02 {
	// 메뉴에서 [3: 문제4-2] 선택하기 
   	public static void main(String[] args) {
    	new ProductController().run(); 
    }
}
/*
제품카테고리가 “TV”인 제품 중 가장 싼 것보다 비싼 모든 제품과,
제품카테고리가 “CELLPHONE”인 제품 중 가장 비싼 제품보다 싼 모든 제품을 출력한다.
조건:
1) UNION을 사용하지 않고 하나의 쿼리 문장으로 작성 한다.
2) 제품원가를 기준으로 한다.
 */
