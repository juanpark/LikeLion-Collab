package work.com.workshop14.workshop;

import work.com.workshop14.controller.ProductController;

public class Test03 {
	// 메뉴에서 [4: 문제4-3] 선택하기 
   	public static void main(String[] args) {
    	new ProductController().run(); 
    }
}
/*
[ 문제 3,4,5 ] 문제에서 요구하는 쿼리문장 및 프로그램을 작성 하시오.
공장 위치가 ‘CHANGWON’에서 생산된 제품들에 결함이 발견되어 생산된 모든 제품을
폐기 하고자 한다.
[ 문제 3 ] 아래 요구사항에 맞는 테이블을 생성하는 쿼리문장을 작성 하시오.
 */

/*
CREATE TABLE DISCARDED_PRODUCT (
PDNO INT PRIMARY KEY,                    -- 제품번호 (기본키)
PDNAME VARCHAR(10),                      -- 제품카테고리
PDSUBNAME VARCHAR(10),                   -- 제품명
FACTNO VARCHAR(5),                       -- 공장번호 (외래키)
PDDATE DATE,                             -- 제품생산일
PDCOST INT,                              -- 제품원가
PDPRICE INT,                             -- 제품가격
PDAMOUNT INT,                            -- 재고수량
DISCARDED_DATE DATE,                     -- 폐기날짜

CONSTRAINT FK_DISCARDED_PRODUCT_FACTORY
    FOREIGN KEY (FACTNO)
    REFERENCES FACTORY(FACTNO)
);
*/