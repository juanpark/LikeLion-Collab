/*
DELIMITER 
$$
CREATE PROCEDURE 프로시저명 ( [매개변수 목록] )
BEGIN
    -- SQL 문들
END
$$
DELIMITER ;

매개변수 
IN : 입력값 전달
OUT : 출력값 반환
INOUT : 입력도 하고 수정된 값도 반환


CRUD 문법 (프로시저 안에서도 동일하게 사용 가능)

ex)
CREATE PROCEDURE sample_proc(IN param1 INT, OUT result INT)
BEGIN
   SELECT param1 * 2 INTO result;
END;
*/

-- 01. sample_proc를 호출해 보자.
SET @OUTPUT = 0; -- OUT result INT 파라미터 저장할 변수
CALL sample_proc(5, @OUTPUT);
SELECT @OUTPUT AS RESULT;

-- 02. 두 수를 입력 받아 4칙연산 프로시저를 호출해 보자.
/*
SET @a = 10;
SET @b = 5;
SET @hap = 0;
SET @sub = 0;
SET @mul = 0;
SET @r_div = 0;
*/
SET @a = 10, @b = 5, @hap = 0, @sub = 0, @mul = 0, @r_div = 0;

-- 2-1 프로시저 호출
CALL my_calc(@a, @b, @hap, @sub, @mul, @r_div);

-- 2-2 결과 
SELECT @hap AS '+', @sub AS '-', @mul AS '*', @r_div AS '/';

-- 3. doiterate 호출해 보자
call my_emp.doiterate(6);
SELECT @x;

-- 4. doreat 호출해 보자
call my_emp.dorepeat(10);
SELECT *
FROM temp_numbers;

use my_emp;
SELECT  * 
FROM EMP;

DROP TABLE EMP_TEST;
-- Q1) 제약 조건이 없는 사원 테이블 `EMP_TEST`를 생성해보자.
CREATE TABLE EMP_TEST
AS
SELECT *
FROM EMP;

SELECT *
FROM EMP_TEST;

-- Q2) `PRO01_INSERT`() 프로시저를 작성하여, `EMP_TEST`에 사원의 번호, 이름, 부서번호를 여러 건 입력하자.

INSERT INTO EMP_TEST (EMPNO, ENAME, DEPTNO)
	VALUES(1, '1111', 10), (2, '2222', 20), (3, '3333', 30);

CALL PRO01_INSERT();

SELECT * FROM EMP_TEST;

-- Q3) `PRO02_DELETE`(IN E_NO INT) 프로시저를 작성하여, 사원 번호를 입력받아 해당 사원을 삭제해보자.
-- DELETE FROM EMP_TEST WHERE EMPNO = 1;
SET SQL_SAFE_UPDATES = 0;
CALL `PRO02_DELETE`(1);
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM EMP_TEST;


-- Q4) `PRO03_UPDATE`(IN E_NO INT, IN E_NAME VARCHAR(50)) 프로시저를 작성하여, 사번에 해당하는 사원의 이름을 수정하자.
UPDATE EMP_TEST
SET ENAME = E_NAME
WHERE EMPNO = E_NO;

SET SQL_SAFE_UPDATES = 0;
CALL `PRO03_UPDATE`(2, '홍길동');
SET SQL_SAFE_UPDATES = 1;
SELECT * FROM EMP_TEST;

-- Q5) `PRO04_SELECT`(IN EMP_NAME VARCHAR(50)) 프로시저를 작성하여, 사원 이름으로 해당 사원의 정보를 조회하자.
SET @NAME = 'KING';
SELECT *
FROM EMP_TEST
WHERE ENAME = EMP_NAME;

CALL PRO04_SELECT(@NAME);

-- 5-1 프로시저 전체 확인 해보자:
SHOW PROCEDURE STATUS WHERE DB='MY_EMP';

-- 5-2 특정 프로시저 내용을 확인 해보자:
SHOW CREATE PROCEDURE MY_EMP.PRO01_INSERT;

-- Q6) `PRO05_COUNT`(OUT CNT INT) 프로시저를 작성하여, EMP_TEST 테이블의 총 사원 수를 반환하자.
SELECT COUNT(*) AS '총 사원 수'
FROM EMP_TEST;

CALL PRO05_COUNT(@RES); -- 프로시저 호출 시 OUT으로 리턴되는 값을 받을 변수를 선언
SELECT @RES AS '총 사원 수'; -- 개수 출력

-- Q7) `PRO06_SELECTALL`() 프로시저를 작성하여, EMP_TEST 테이블의 모든 데이터를 조회하자.
SELECT * FROM EMP_TEST;

CALL PRO06_SELECTALL();

-- Q8) `PRO07_IF`(IN ENO INT) 프로시저를 작성하여,
--      사원이 존재하면 해당 사원의 월급을 2배로 인상하고, 
--      존재하지 않으면 메시지를 출력하자.
SET @ENO = 7934;
CALL PRO07_IF(@ENO);

SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

ROLLBACK;


-- Q9) `PRO08_IF`(IN IN_SAL DECIMAL) 프로시저를 작성하여,
--      입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 
--      존재하지 않으면 메시지를 출력하자.
CALL PRO08_IF(5000);


-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)

-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.

-- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 
 
 
 
 
 
 
 
 
 


