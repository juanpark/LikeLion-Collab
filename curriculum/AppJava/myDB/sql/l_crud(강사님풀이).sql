/*
https://dev.mysql.com/doc/refman/8.4/en/create-table.html
FOREIGN KEY 제약조건 시 선택 옵션

reference_definition:
    REFERENCES tbl_name (key_part,...)
      [MATCH FULL | MATCH PARTIAL | MATCH SIMPLE]
      [ON DELETE reference_option]
      [ON UPDATE reference_option]

reference_option:
    RESTRICT  |		기본값, 부모테이블의 값이 자식 테이블에 의해 참조되고 있으면 {삭제/수정 불가}
    CASCADE   | 	부모테이블의 데이터가 삭제/수정되면 자식테이블의 데이터도 같이 {삭제/수정}
    SET NULL  | 	부모테이블의 데이터가 삭제/수정되면 자식테이블의 컬럼값만 NULL
    NO ACTION |   	RESTRICT와 같다. 즉시 적용되지 않고 트랜잭션이 끝날 때 검사. => 지연된 검사
    SET DEFAULT		부모테이블의 데이터가 삭제/수정되면 자식테이블의 컬럼값은 기본값으로 대체된다.


create table orders(
	order_id 	INT primary key AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date 	DATE NOT NULL
    FOREIGN KEY (customer_id) REFERENCES costomers(customer_id) 
		ON DELETE CASCADE 	ON UPDATE CASCADE
);  -- 고객 정보가 사라지면 그 고객의 주문도 함께 삭제된다. DELETE	CASCADE
	-- 고객의 ID가 변경되면 주문정보의 고객  ID도 함께 변경된다.  UPDATE CASCADE

-- EMP 참조 키, 추가확인
ALTER TABLE emp 
ADD CONSTRAINT fk_emp_dept
				FOREIGN KEY ( deptno ) REFERENCES dept( deptno )
							ON DELETE NO ACTION ON UPDATE NO ACTION;
	- ON DELETE NO ACTION : dept 테이블에서 deptno값을 삭제하려고 할 때, deptno를 사용하는 emp테이블의 데이터가 있으면 삭제를 허용하지 않겠다. 
    - UPDATE NO ACTION : dept 테이블에서 deptno값을 수정하려고 할 때, detpno를 사용하는 emp테이블의 데이터가 있으면 수정을 허용하지 않겠다.

-- 삭제하고 싶다.
alter table emp
drop FOREIGN KEY fk_emp_dept;

*/
--  delete from dept where deptno=10;      -- error~ 

show create table emp;

SELECT 
    CONSTRAINT_NAME, 
    UPDATE_RULE, 
    DELETE_RULE, 
    TABLE_NAME, 
    REFERENCED_TABLE_NAME
FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'my_emp'   AND TABLE_NAME = 'emp';





/*
1)CRUD
Create (삽입)	INSERT INTO 테이블명 (열1, 열2, ...) VALUES (값1, 값2, ...);	
Read (조회)	    SELECT 열1, 열2 FROM 테이블명 [WHERE 조건];	
Update (수정)	UPDATE 테이블명 SET 열1 = 값1, 열2 = 값2 WHERE 조건;	
Delete (삭제)	DELETE FROM 테이블명 WHERE 조건;	

2)트랜잭션 제어 명령어
START TRANSACTION;	트랜잭션 시작 (명시적으로 시작하고 싶을 때 사용)
COMMIT;	트랜잭션 완료 후 변경 사항을 영구 저장
ROLLBACK;	트랜잭션 내의 모든 변경 사항을 취소하고 되돌림
SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백

3) 트랜잭션 특징 (ACID 원칙 요약)
Atomicity (원자성)	: 모든 작업이 모두 수행되거나, 하나도 수행되지 않아야 함
Consistency (일관성)	: 트랜잭션 완료 후에도 데이터의 일관성 유지
Isolation (고립성)	:트랜잭션끼리 서로 간섭하지 않아야 함 
Durability (지속성)	:COMMIT 후 변경 내용은 영구 저장되어야 함

**  트랜잭션   -> 동시성 제어(데이터충돌 주의)  -> 동시에 여러 트랜잭션이 접근을 하게 되면 충돌이 발생할 수 잇으므로 
               서버는 LOCK이나 격리수준관리를 진행한다.  
*/
USE MY_EMP;
CREATE TABLE MY_EMP  -- EMP의 테이블 구조와 데이터로만 테이블 생성   
AS
SELECT  * FROM EMP;   -- 제약 구조는 리턴되지 않음  

SELECT  * FROM MY_EMP;
DESC MY_EMP;

CREATE TABLE MY_DEPT
AS
SELECT * FROM DEPT;

SELECT  * FROM MY_DEPT;
DESC MY_DEPT;

-- 1(자동 커밋활성화)  ,  0 (자동 커밋 비활성화 )
SET  autocommit= 0;  -- mysql 서버에  변경한다.  _자동커밋 해제  DML 할때 COMMIT 명시전까지 반영되지 않음  
SET  global autocommit= 0;  -- mysql 서버에  변경한다.  
-- SELECT @@autocommit;  -- 세션수준의 변수값 확인    =  세션이란? 클라이언트 객체를 생성해서 서버가 관리하는 인스턴스  
-- SELECT @@global.autocommit;  -- 글로벌 수준의 변수값 확인 

START TRANSACTION;  -- 명시 선언  
-- DML 실행  
COMMIT; 
################################### DML 연습 해보자  ############
start TRANSACTION;  
-- 1) 간단 테이블 생성  
DROP TABLE TEST;
CREATE TABLE TEST( 
ID    INT,
NAME  VARCHAR(20));

-- 2) 입력
INSERT INTO TEST VALUES(1,1);
INSERT INTO TEST VALUES(2,2);
SELECT  * FROM TEST;

commit;  -- 입력된 내용 저장  --- 1번  
INSERT INTO TEST VALUES(3,1);
INSERT INTO TEST VALUES(4,2);
commit;  -- 입력된 내용 저장  --- 2번  
INSERT INTO TEST VALUES(5,1);
INSERT INTO TEST VALUES(6,2);
rollback;    -- 입력된 내용 취소  --- 3번 
SELECT  * FROM TEST;
################################################################
-- SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
-- ROLLBACK TO SAVEPOINT 포인트명;특 정 지점까지 롤백
DROP TABLE TEST;
CREATE TABLE TEST( 
ID    INT,
NAME  VARCHAR(20));

START  TRANSACTION; 
-- 데이터 추가 
INSERT INTO TEST VALUES(1,'A');
INSERT INTO TEST VALUES(2,'B');

-- 중간 저장 지점 설정  
SAVEPOINT  SP01;
INSERT INTO TEST VALUES(3,'C');
INSERT INTO TEST VALUES(4,'D'); 

-- 현재상태 확인 
SELECT  * FROM TEST;

-- ROLLBACK TO를 사용해서 1,2를 찾아서 되돌리자. 3,4는 롤백되었다.  = 책갈피 이후의 작업만 취소 한다.    
ROLLBACK TO  SP01;

SELECT  * FROM TEST;
COMMIT;



###################################################################
-- 1. 기존 테이블이 있다면 삭제
drop table if exists my_emp;
drop table if exists my_dept;

-- 2. create table ... as select  ... 구문은 제약조건 없이 {데이터와 구조 복사}
USE MY_EMP;
CREATE TABLE MY_EMP  -- EMP의 테이블 구조와 데이터로만 테이블 생성   
AS
SELECT  * FROM EMP;   -- 제약 구조는 리턴되지 않음  

CREATE TABLE MY_DEPT
AS
SELECT * FROM DEPT;

SELECT  * FROM MY_EMP;
DESC MY_EMP;

SELECT  * FROM MY_DEPT;
DESC MY_DEPT;


-- Q1) 사원 테이블에서 사원의 번호가 7499인 사원의 월급을 5000으로 변경하자.
START TRANSACTION;
UPDATE MY_EMP
SET  SAL  = 700
WHERE  EMPNO =7499;

SELECT ENAME, SAL
FROM MY_EMP
WHERE EMPNO = 7499;
COMMIT;

-- Q2) 부서 번호가 20번인 사원의 월급을 2000으로 변경하자.
UPDATE MY_EMP  
SET  SAL = 2000  
WHERE  DEPTNO = 20; 
COMMIT;



-- Q3) MY_DEPT 테이블에 데이터를 입력해보자. 50 , RESERCH, BOSTON
INSERT  INTO MY_DEPT 
VALUES (50,'RESERCH','BOSTON');
COMMIT;

select * from MY_DEPT;
-- Q4) MY_DEPT에 입력된 50번을 삭제 해보자.
DELETE FROM  MY_DEPT
WHERE  DEPTNO = 50;
COMMIT;

-- Q5) FORD의 월급을 4000으로 변경하고 부서번호를 30으로 변경하자.
UPDATE MY_EMP
SET  SAL  = 4000 , DEPTNO =30 
WHERE ENAME ='FORD' ;
COMMIT;

SELECT   SAL, DEPTNO
FROM MY_EMP
WHERE ENAME ='FORD';

-- Q6) 사원번호가 7698인 사원의 부서번호를 7934 사원의 부서번호로 변경해보자.
SELECT DEPTNO
FROM MY_EMP
WHERE EMPNO=7698; -- 30

SELECT DEPTNO
FROM MY_EMP
WHERE EMPNO=7934;  -- 10 

UPDATE MY_EMP
SET DEPTNO =( SELECT DEPTNO  
             FROM EMP
             WHERE EMPNO = 7934) 
WHERE  EMPNO = 7698;
COMMIT;

-- Q7) 사원번호 0001번으로 홍길동을 세 번 입력 후 수정/삭제 테스트 진행
SELECT  * 
FROM  MY_EMP;

INSERT INTO MY_EMP  VALUES(0001, '홍길동','CLERK',7783, NOW(), 9000, NULL, 10);
INSERT INTO MY_EMP  VALUES(0001, '홍길동','CLERK',7784, NOW(), 9000, NULL, 10);
INSERT INTO MY_EMP  VALUES(0001, '홍길동','CLERK',7785, NOW(), 9000, NULL, 10);

SELECT  * FROM MY_EMP;
ROLLBACK;
-- Q7-1) 사원의 번호 1이고 매니저가 7785인 사원을 삭제하자.
DELETE 
FROM MY_EMP 
WHERE EMPNO = 1 AND MGR = 7785;  

-- Q7-2) 사번 0001에 DEPTNO를 20으로 수정
UPDATE MY_EMP 
SET DEPTNO = 20 
WHERE EMPNO = 1;

-- Q7-3) 홍길동의 직업을 SALESMAN으로 수정
UPDATE MY_EMP 
SET JOB = 'SALESMAN' 
WHERE ENAME = '홍길동';

-- Q7-4) 홍길동의 봉급을 KING과 같게 수정 (에러 해결 방식 포함)
-- CASE 1: 변수 사용 (객체 단위로 entity를 관리하기에 @변수는 주소를 가리킴)
SET @KING_SAL  = (SELECT SAL FROM MY_EMP WHERE ENAME = 'KING'); 
UPDATE MY_EMP 
SET SAL = @KING_SAL
WHERE ENAME = '홍길동';

-- CASE 2: 임시테이블 사용 -- 작은 크기의 테이블일 경우 메모리에 저장되고 클 경우 디스크에 저장됨
CREATE TEMPORARY  TABLE  TEMP_KING AS SELECT SAL FROM MY_EMP WHERE ENAME = 'KING';
UPDATE MY_EMP SET SAL = (SELECT SAL FROM TEMP_KING) WHERE ENAME = '홍길동';
DROP TEMPORARY TABLE TEMP_KING;  -- 임시테이블은 drop으로 삭제해줘야함   


show table status like 'my_emp';

-- Q7-5) 홍길동의 매니저가 7785인 경우 봉급을 0으로 수정
UPDATE MY_EMP 
SET SAL = 0 
WHERE ENAME = '홍길동' AND MGR = 7785; 

-- Q7-6) 홍길동의 매니저가 7784인 경우 커미션을 1000으로 수정
UPDATE MY_EMP 
SET COMM = 1000 
WHERE ENAME = '홍길동' AND MGR = 7784;

-- Q8-1) WARD와 같은 직업을 가진 사원을 삭제하자. WARD포함
DELETE FROM MY_EMP
WHERE job = ( SELECT  M_NEW.JOB FROM (SELECT job FROM MY_EMP WHERE ename = 'WARD') M_NEW );

-- case set 변수로 선언
SET @WARD_JOB = (SELECT job FROM MY_EMP WHERE ename = 'WARD');
DELETE FROM MY_EMP
WHERE JOB = WARD_JOB;

-- 기부 코드 설명 CASE 1 : JOIN 기반  WARD포함 전체 삭제
-- 병수님 코드
delete e1 
from my_emp e1 
join my_emp e2 on (e1.job = e2.job) 
where e2.ename = "WARD";

-- 성현님 코드 CASE 2 : JOIN + 조건 WARD 제외 나머지 삭제
delete t 
from test_emp t 
join (select job from test_emp where ename='ward') t2 
where t.job=t2.job and t.ename != 'ward';

-- 은총님 코드 CASE 2 : 서브쿼리 , IN WARD 포함 전체 삭제
delete from my_emp
where job IN (select job from (select job, ename from my_emp) sub
             where sub.ename = 'WARD');


-- 번외) WARD와 같은 직업을 가진 사원을 삭제하자. WARD 제외
SET @WARD_JOB = (SELECT job FROM MY_EMP WHERE  ename = 'WARD');
DELETE FROM MY_EMP
WHERE JOB = @WARD_JOB AND ENAME != 'WARD';

-- Q8-2) WARD의 월급을 SMITH의 월급과 같게 수정하자.
UPDATE MY_EMP
SET sal = ( SELECT MY.SAL FROM 
						( SELECT sal 
						  FROM MY_EMP WHERE ename='SMITH')  MY) 
WHERE ename = 'WARD';

-- Q8-3) KING의 직업을 SMITH와 같게 수정하자.
-- CASE 1: 변수 사용
SET @smith_job = (SELECT JOB FROM MY_EMP WHERE ENAME = 'SMITH');
UPDATE MY_EMP SET JOB = @smith_job WHERE ENAME = 'KING';

-- CASE 2: 임시테이블 사용 
CREATE TEMPORARY TABLE TEMP_SMITH AS SELECT JOB FROM MY_EMP WHERE ENAME = 'SMITH';
UPDATE MY_EMP SET JOB = (SELECT JOB FROM TEMP_SMITH) WHERE ENAME = 'KING';
DROP TEMPORARY TABLE TEMP_SMITH; 

-- CASE 3: INLINE VIEW 사용
UPDATE MY_EMP 
SET JOB = (SELECT JOB FROM (SELECT JOB FROM MY_EMP WHERE ENAME = 'SMITH') AS TEMP_SMITH)
WHERE ENAME = 'KING';

-- Q8-4) 사원번호가 7499번인 사원과 같은 직업을 가진 사원들의 입사일을 오늘 날짜로 변경
UPDATE MY_EMP
SET HIREDATE = CURDATE()
WHERE JOB = (SELECT JOB FROM (SELECT JOB FROM MY_EMP WHERE EMPNO = 7499) AS TEMP);

-- Q9) MY_EMP, MY_DEPT 테이블에 PK 추가
ALTER TABLE  MY_EMP ADD PRIMARY KEY (EMPNO); 
ALTER TABLE  MY_DEPT ADD PRIMARY KEY (DEPTNO);  

-- Q10) MY_EMP, MY_DEPT 외래키 수정 (CASCADE 설정 포함)
ALTER TABLE MY_EMP 
			DROP FOREIGN KEY FK_MYEMP_MYDEPT;

ALTER TABLE MY_EMP
ADD CONSTRAINT FK_MYEMP_MYDEPT
FOREIGN KEY(DEPTNO) REFERENCES MY_DEPT(DEPTNO)
ON DELETE CASCADE ON UPDATE CASCADE;

-- Q11) MY_DEPT에서 DEPTNO 10을 삭제 후 MY_EMP에서 확인
DELETE FROM MY_DEPT WHERE DEPTNO = 10;
SELECT DEPTNO FROM MY_EMP WHERE DEPTNO = 10;

-- Q12) MY_DEPT에서 DEPTNO 20을 200으로 변경 후 MY_EMP에서 확인
UPDATE MY_DEPT SET DEPTNO = 200 WHERE DEPTNO = 20;
SELECT DEPTNO FROM MY_EMP WHERE DEPTNO = 200;

-- Q13) 두 개의 테이블 제약조건을 확인하자.


-- Q14) 두 개의 테이블 제약조건을 삭제 하자.

-- Q15) 두 개의 테이블을 삭제 하자


