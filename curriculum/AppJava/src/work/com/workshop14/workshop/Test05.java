package work.com.workshop14.workshop;

import work.com.workshop14.controller.ProductController;

public class Test05 {
	// 메뉴에서 [5: 문제4-5] 선택하기 
   	public static void main(String[] args) {
    	new ProductController().run(); 
    }
}
/*
[문제 4]에서 폐기된 제품을 PRODUCT 테이블에서 모두 삭제 한다. 단, 트랜잭션 처리를 반드시 한다.
 */

/*
SET SQL_SAFE_UPDATES = 0;

DELETE FROM DISCARDED_PRODUCT
WHERE FACTNO = 98712;

SET SQL_SAFE_UPDATES = 1;
*/