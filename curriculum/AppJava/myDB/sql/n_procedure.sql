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

##############################################################################################################
/*  <<예외>> https://dev.mysql.com/doc/refman/8.4/en/declare-condition.html

DECLARE condition_name CONDITION FOR condition_value

condition_value: {
    mysql_error_code
  | SQLSTATE [VALUE] sqlstate_value
}

1) DECLARE ... HANDLER : CONTINUE, EXIT, UNDO 핸들러를 통해 오류 발생 후의 흐름 제어
         -DECLARE CONTINUE HANDLER FOR condition action: 지정된 조건이 발생하면 현재 실행 중인 구문을 완료하고 다음 구문을 계속 실행
         -DECLARE EXIT HANDLER FOR condition action: 지정된 조건이 발생하면 현재 블록(BEGIN ... END)을 즉시 종료
         -DECLARE UNDO HANDLER FOR condition action: (트랜잭션 스토리지 엔진에서) 지정된 조건이 발생하면 현재 트랜잭션을 롤백
         - condition 부분 지정  옵션 
			= SQLSTATE value: 특정 SQLSTATE 값 (5자리 문자열, 예를 들어 '45000').
            = SQLEXCEPTION: 모든 SQLSTATE 값 중에서 일반적인 오류를 나타내는 클래스
            = SQLWARNING: 모든 SQLSTATE 값 중에서 경고를 나타내는 클래스
            = NOT FOUND: 커서 작업에서 더 이상 행이 없을 때 발생하는 조건 (SQLSTATE '02000').
            = specific_error_code: 특정 MySQL 오류 코드 (정수).
            
2) SIGNAL SQLSTATE :SQL 예외 발생
3) GET DIAGNOSTICS:발생한 오류에 대한 자세한 정보(SQLSTATE, 오류 코드, 메시지 등)확인

*/
-- Q10) 모든 사원의 급여를 입력받은 비율만큼 인상하는 프로시저를 작성하자. (예: 비율 1.1 → 10% 인상)
-- `PRO09_IF`(IN RATE DECIMAL(5,2)
CALL PRO09_IF(0);
ROLLBACK;
CALL PRO06_SELECTALL();

-- 10-1) Docs에 있는 코드를 테스트 하자.
-- 테이블 생성
DROP TABLE T;
SET @x = null;
CREATE TABLE T (
	s1 INT, 
    PRIMARY KEY (s1)
);

DESC T;
SELECT * FROM T;
SELECT @x;

CALL handlerdemo(); -- CONTINUE
CALL handlerdemo02(); -- EXIT

SELECT * FROM T;
SELECT @x;

-- 10-1) Docs에 있는 코드를 테스트 하자.
CALL P();

-- 10-2) 예외가 발생된 정보를 리턴 받아서 출력 해보자
/*
mysql> DROP TABLE test.no_such_table;
ERROR 1051 (42S02): Unknown table 'test.no_such_table'
mysql> GET DIAGNOSTICS CONDITION 1
         @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
mysql> SELECT @p1, @p2;
+-------+------------------------------------+
| @p1   | @p2                                |
+-------+------------------------------------+
| 42S02 | Unknown table 'test.no_such_table' |
+-------+------------------------------------+
*/

DROP TABLE NO_SUCH_TABLE;
-- Error Code: 1051. Unknown table 'my_emp.no_such_table'
GET DIAGNOSTICS CONDITION 1
         @p1 = RETURNED_SQLSTATE, @p2 = MESSAGE_TEXT;
SELECT @P1, @P2;

-- 10-3) 예외 처리를 포함한 진단 정보(GET DIAGNOSTICS)를 출력하자.
CALL do_insert(5);

-- 10-4) PRO10_DO_INSERT(1); 실행했을 경우 트랜젝션 현코드를 추가해서 결과를 출력 해보자.
CALL PRO10_DO_INSERT(1);


##########################################################################################



-- Q11) `DO` 문을 활용하여 반복 또는 조건문 기반 로직을 실습해보자.
-- 이름, 전화번호, 가입일을 저장하는 테이블을 생성하고,프로시저를 통해 난수 기반으로 100명의 데이터를 자동 입력 해보자.
CREATE TABLE IF NOT EXISTS random_members (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(20),
    join_date DATE
);

SELECT DATEDIFF('2024-12-31', '2020-01-01');  -- 1826일
CALL PRO11_Insert_random_members();

SELECT * FROM RANDOM_MEMBERS;

-- 위 테이블에 WED컬럼 추가 후 {요일계산 프로시저}를 작성해 보자.

USE MY_EMP;
-- Q12) `CURSOR`(커서)를 이용한 프로시저를 작성하여 TEST_EMP의 사원의 이름과 봉급을 출력 해보자.
CALL PRO12_CURSOR_SELECT01();



-- Q12-1) `CURSOR`(커서)를 이용한 프로시저를 작성하여 TEST_EMP의 사원의 이름과 봉급을 출력 해보자.
CALL PRO12_CURSOR_SELECT02();

-- Q13) `CURSOR`(커서)를 이용한 프로시저를 작성하여, 부서번호가 10번인 사원들을 순차적으로 출력하자.



 
 
 
 
 
 
 
 
 
 


