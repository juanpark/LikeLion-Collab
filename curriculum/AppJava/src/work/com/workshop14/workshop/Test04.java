package work.com.workshop14.workshop;

import work.com.workshop14.controller.ProductController;

public class Test04 {
	// 메뉴에서 [4: 문제4-4] 선택하기 
   	public static void main(String[] args) {
    	new ProductController().run(); 
    }
}
/*
PRODUCT 테이블에서 폐기 되는 제품정보들을 모두 조회 하여 DISCARDED_PRODUCT 테이블로 INSERT
한다. 단, 트랜잭션 처리를 반드시 한다.
조건:
1) 폐기 날짜는 현재 시스템 날짜로 한다.
 */

/*
INSERT INTO DISCARDED_PRODUCT (
PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE,
PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE
)
SELECT
PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE,
PDCOST, PDPRICE, PDAMOUNT, CURDATE()
FROM PRODUCT
WHERE FACTNO IN (
SELECT FACTNO
FROM FACTORY
WHERE FACLOC = 'CHANGWON');
*/