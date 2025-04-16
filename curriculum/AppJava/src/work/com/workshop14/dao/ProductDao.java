package work.com.workshop14.dao;

import java.util.List;
import java.util.Map;

import work.com.workshop14.model.Product;

public interface ProductDao {

	// SELECT * FROM Product
	List<Map<String, Object>> selectAllProducts();
	
	// 4-1번 문제
	/*
	SELECT P.PDNAME, P.PDSUBNAME, F.FACNAME, S.STONAME, S.STAMOUNT
	FROM PRODUCT P
	JOIN FACTORY F ON P.FACTNO = F.FACTNO
	JOIN STORE S ON P.PDNO = S.PDNO
	WHERE F.FACLOC = 'SEOUL' AND (S.STAMOUNT = 0 OR S.STAMOUNT IS NULL);
	*/
	List<Map<String, Object>> problem4_1();
	
	// 4-2번 문제
	/*
	SELECT PDSUBNAME, PDCOST, PDPRICE
	FROM PRODUCT
	WHERE (PDNAME = 'TV' 
	AND PDCOST > (
		SELECT MIN(PDCOST)
	    FROM PRODUCT
	    WHERE PDNAME = 'TV'))
	OR
	(PDNAME = 'CELLPHONE' 
	AND PDCOST < (
	SELECT MAX(PDCOST)
    FROM PRODUCT
    WHERE PDNAME = 'CELLPHONE')
	);
	 */
	List<Map<String, Object>> problem4_2();
	
	// 4-3번 문제
	// 테이블 생성
	String problem4_3();
	
	// 4-4번 문제
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
	String problem4_4();
	
	// 4-5번 문제
	/*
	[문제 4]에서 폐기된 제품을 PRODUCT 테이블에서 모두 삭제 한다. 단, 트랜잭션 처리를 반드시 한다.
	 */

	/*
	SET SQL_SAFE_UPDATES = 0;

	DELETE FROM DISCARDED_PRODUCT
	WHERE FACTNO = 98712;

	SET SQL_SAFE_UPDATES = 1;
	*/
	String problem4_5();
	
	// 7
	String dropDiscarded();
	
	// 8
	List<Map<String, Object>> selectAllDiscarded();


}
