/*
1)CRUD
Create (삽입)	INSERT INTO 테이블명 (열1, 열2, ...) VALUES (값1, 값2, ...);	
Read (조회)	SELECT 열1, 열2 FROM 테이블명 [WHERE 조건];	
Update (수정)	UPDATE 테이블명 SET 열1 = 값1, 열2 = 값2 WHERE 조건;	
Delete (삭제)	DELETE FROM 테이블명 WHERE 조건;	

2)트랜잭션 제어 명령어
START TRANSACTION;	트랜잭션 시작 (명시적으로 시작하고 싶을 때 사용)
COMMIT;	트랜잭션 완료 후 변경 사항을 영구 저장
ROLLBACK;	트랜잭션 내의 모든 변경 사항을 취소하고 되돌림
SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백

3) 트랜잭션 특징 (ACID 원칙 요약) *** 시험 필수
Atomicity (원자성)	: 모든 작업이 모두 수행되거나, 하나도 수행되지 않아야 함
Consistency (일관성)	: 트랜잭션 완료 후에도 데이터의 일관성 유지
Isolation (고립성)	:트랜잭션끼리 서로 간섭하지 않아야 함
Durability (지속성)	:COMMIT 후 변경 내용은 영구 저장되어야 함


트랜잭션?   => 동시성 제어(데이터 충돌 주의) : 동시에 여러 트랜잭션이 접근을 하게 되면 충돌이 발생할 수 있으므로 서버는 LOCK을 걸어 격리수준관리를 진행한다.
같은 게시판에서 클라이언트1가 A를 B로 글수정,  클라이언트2는 A를 읽고 있음
DB서버는 A가 수정될 때 lock을 걸고 commit / rollback할때까지 잠겨있음.
클라이언트2는 commit / rollback할때까지 A만을 보고 있음
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
SET  autocommit= 0;  -- mysql 서버에  변경한다. _자동커밋 해제: DML 할 때 COMMIT 명시 전까지 반영되지 않음 
SET  global autocommit= 0;  -- mysql 서버에  변경한다.  
SELECT @@autocommit;  -- 세션수준의 변수값 확인  
SELECT @@global.autocommit;  -- 글로벌 수준의 변수값 확인 

START TRANSACTION;	-- 명시 선언 
-- DML 실행 
COMMIT;


####################################### DML 연습 ###################################
START TRANSACTION;
-- 1) 간단 테이블 생성
drop table test;
create table test(
	id int,
    name varchar(20));
-- 2) 입력
insert into test values(1,1);
insert into test values(2,2); -- insert하면 lock을 걸음
select * from test;

commit; -- 입력된 내용 저장 -- 1번
insert into test values(3,1);
insert into test values(4,2);
commit; -- 입력된 내용 저장 -- 2번
insert into test values(5,1);
insert into test values(6,2);
ROLLBACK; -- 입력된 내용 취소 이전 커밋으로 돌아감 --- 3번
select * from test;	-- 입력된 내용이 삭제되어있음

SELECT * FROM TEST; -- Terminal session of MySQL shows empty database (not committed)

-- SAVEPOINT 포인트명;	중간 저장점 지정 – ROLLBACK TO SAVEPOINT로 일부 취소 가능
-- ROLLBACK TO SAVEPOINT 포인트명;	특정 지점까지 롤백
drop table test;
CREATE TABLE test (
    id INT,
    name VARCHAR(20)
);

START TRANSACTION;
-- 데이터 추가
INSERT INTO TEST VALUES(1, 'A');
INSERT INTO TEST VALUES(2, 'B');

-- 중간 저장 지점 설정
SAVEPOINT SP01;
INSERT INTO TEST VALUES(3, 'C');
INSERT INTO TEST VALUES(4, 'D');

-- 현재상태 확인
SELECT * FROM TEST;

-- ROLLBACK TO를 사용해서 1,2를 찾아서 되돌리자. 3,4는 롤백되었다. = 책갈피 이후의 작업만 취소한다.
ROLLBACK TO SP01;

SELECT * FROM TEST;
COMMIT;


#################################################################
# MY_EMP와 EMP 비교 후 인덱스 설정하기
SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'EMP';
-- empno = PRIMARY
-- deptno = fk_emp_dept

SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'DEPT';
-- dept = PRIMARY

SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'MY_EMP';
-- 비어 있음

SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'MY_DEPT';
-- 비어 있음

-- MY_EMP PK 추가하기
ALTER TABLE MY_EMP
ADD CONSTRAINT pk_my_emp PRIMARY KEY (empno);

-- MY_DEPT PK 추가하기
ALTER TABLE MY_DEPT
ADD CONSTRAINT pk_my_dept PRIMARY KEY (deptno);

-- FK 추가하기 (먼저 MY_DEPT 설정 후 진행해야 함 - 에러)
ALTER TABLE MY_EMP
ADD CONSTRAINT fk_my_emp_dept FOREIGN KEY (deptno)
REFERENCES MY_DEPT(deptno);

SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'MY_EMP';
-- MY_EMP : empno : PRIMARY
-- MY_EMP : deptno : fk_my_emp_dept

SELECT *
FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'MY_DEPT';
-- MY_DEPT : deptno : PRIMARY


-- Q1) 사원 테이블에서 사원의 번호가 7499인 사원의 월급을 700으로 변경하자.
SELECT *
FROM MY_EMP
WHERE EMPNO = 7499;

UPDATE MY_EMP
SET SAL = 700
WHERE EMPNO = 7499;

SELECT * 
FROM MY_EMP;

-- Q2) 부서 번호가 20번인 사원의 월급을 2000으로 변경하자.
SELECT *
FROM MY_EMP
WHERE DEPTNO = 20;

UPDATE MY_EMP
SET SAL = 2000
WHERE DEPTNO = 20;

SELECT * 
FROM MY_EMP;

-- Q3) MY_DEPT 테이블에 50번, RESEARCH, BOSTON 데이터를 입력하자.
SELECT *
FROM MY_DEPT;

INSERT INTO MY_DEPT (DEPTNO, DNAME, LOC)
VALUES (50, 'RESEARCH', 'BOSTON');

SELECT *
FROM MY_DEPT;


-- Q4) MY_DEPT 테이블에서 부서번호 50번 데이터를 삭제하자.
DELETE FROM MY_DEPT
WHERE DEPTNO = 50;

SELECT *
FROM MY_DEPT;


-- Q5) FORD의 월급을 4000으로, 부서번호를 30으로 변경하자.
SELECT *
FROM MY_EMP
WHERE ENAME = 'FORD';

UPDATE MY_EMP
SET SAL = 4000, DEPTNO = 30
WHERE ENAME = 'FORD';
-- WHERE에서 PK를 사용하지 않기에 에러 

UPDATE MY_EMP
SET SAL = 4000, DEPTNO = 30
WHERE EMPNO = (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = 'FORD'
    LIMIT 1 -- Ename이 여러 개 있을 수 있어서 안전 장치
);
-- Error Code: 1093. 
-- You can't specify target table 'MY_EMP' for update in FROM clause
-- MySQL에서는 같은 테이블을 동시에 수정하면서 그 테이블에서 조건을 조회(SELECT) 하려고 하면 오류(Error 1093) 가 발생.
-- 안정장치. 하지만 PostgreSQL, SQL Server, Oracle 등에서는 가능함.

-- 해결: JOIN을 이용하여 파생 테이블을 활용하여 MySQL이 관련 테이블을 두 개의 별개의 테이블로 인식하게 하여 안전하게 실행

UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = 'FORD' -- Ename이 여러 개 있을 수 있어서 안전 장치
    LIMIT 1 
) AS SUB ON MY_EMP.EMPNO = SUB.EMPNO
SET MY_EMP.SAL = 4000,
	MY_EMP.DEPTNO = 30;

SELECT *
FROM MY_EMP
WHERE ENAME = 'FORD';

-- Q6) 사원번호 7698의 부서번호를 사원번호 7934의 부서번호로 변경하자.
SELECT EMPNO, DEPTNO
FROM MY_EMP
WHERE EMPNO = 7698; -- DEPTNO 30

SELECT EMPNO, DEPTNO
FROM MY_EMP
WHERE EMPNO = 7934; -- DEPTNO 10

UPDATE MY_EMP
JOIN (
	SELECT DEPTNO		-- 서브퀘리에서 7934사번의 부서번호를 얻는다 
    FROM MY_EMP
    WHERE EMPNO = 7934
) AS SUB	-- 행을 맞추는 것이 아니라 값만 얻기 위해 사용하는 JOIN이기 때문에 ON 또는 USING 사용 안함.
SET MY_EMP.DEPTNO = SUB.DEPTNO -- 서브퀘리에서 받은 부서번호를 입력한다.
WHERE MY_EMP.EMPNO = 7698;

SELECT EMPNO, DEPTNO
FROM MY_EMP
WHERE EMPNO = 7698; -- DEPTNO 30

SELECT EMPNO, DEPTNO
FROM MY_EMP
WHERE EMPNO = 7934; -- DEPTNO 10


-- Q7) 사번이 0001인 홍길동 사원 데이터를 여러 개 추가한 후, 다양한 UPDATE 및 DELETE 작업을 수행하자.
SELECT *
FROM MY_EMP;

INSERT INTO MY_EMP (EMPNO, ENAME, MGR)
VALUES 	(1, "홍길동", 7785),
		(2, "홍길동", 7785);

SELECT *
FROM MY_EMP;

-- Q7-1) 사원번호 1이고 매니저가 7785인 홍길동을 삭제하자.
DELETE FROM MY_EMP
WHERE EMPNO = 1 AND MGR = 7785;

SELECT *
FROM MY_EMP;

-- Q7-2) 사번 0001의 부서번호를 20으로 변경하자.
INSERT INTO MY_EMP (EMPNO, ENAME, MGR)
VALUES 	(1, "홍길동", 7785);

SELECT *
FROM MY_EMP;

UPDATE MY_EMP
SET DEPTNO = 20
WHERE EMPNO = 1;

SELECT *
FROM MY_EMP;


-- Q7-3) 홍길동의 직업을 SALESMAN으로 변경하자.
UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = '홍길동'
    LIMIT 1
) AS SUB ON MY_EMP.EMPNO = SUB.EMPNO
SET MY_EMP.JOB = 'SALESMAN';

SELECT *
FROM MY_EMP;

-- Q7-4) 홍길동의 봉급을 KING과 같게 변경하자.
UPDATE MY_EMP
JOIN (
	SELECT SAL
    FROM MY_EMP
    WHERE ENAME = 'KING'
    LIMIT 1
) AS SUB 
SET MY_EMP.SAL = SUB.SAL
WHERE ENAME = '홍길동';
-- Error Code: 1175. 
-- You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.

UPDATE MY_EMP
JOIN (
	SELECT SAL
    FROM MY_EMP
    WHERE ENAME = 'KING'
    LIMIT 1
) AS SUB
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = '홍길동'
    LIMIT 1
) AS NUM
SET MY_EMP.SAL = SUB.SAL
WHERE MY_EMP.EMPNO = NUM.EMPNO; 

SELECT *
FROM MY_EMP;

-- Q7-5) 매니저가 7785인 홍길동의 봉급을 0으로 수정하자.
UPDATE MY_EMP -- 2번 홍길동 MGR 7785 > 7784로 변경
SET MGR = 7784
WHERE EMPNO = 2;

SELECT *
FROM MY_EMP;

UPDATE MY_EMP
JOIN (
	SELECT EMPNO
	FROM MY_EMP
    WHERE ENAME = '홍길동'
    AND MGR = 7785
    LIMIT 1
) AS SUB
SET SAL = 0
WHERE MY_EMP.EMPNO = SUB.EMPNO;

SELECT *
FROM MY_EMP;

-- Q7-6) 매니저가 7784인 홍길동의 커미션을 1000으로 수정하자.
UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = '홍길동'
    AND MGR = 7784
    LIMIT 1
) AS SUB
SET COMM = 1000
WHERE MY_EMP.EMPNO = SUB.EMPNO;

SELECT *
FROM MY_EMP;

-- Q8) 서브쿼리를 이용한 INSERT, DELETE, UPDATE를 활용해보자.
-- Q8-1) WARD와 같은 직업을 가진 사원을 삭제하자.
SELECT ENAME, JOB
FROM MY_EMP
WHERE JOB = (
	SELECT JOB
    FROM MY_EMP
    WHERE ENAME = 'WARD'
    LIMIT 1
);

-- Delete (삭제)	DELETE FROM 테이블명 WHERE 조건;	
DELETE 
FROM MY_EMP
WHERE EMPNO IN (
	SELECT EMPNO
    FROM (
		SELECT EMPNO
		FROM MY_EMP
		WHERE JOB = (
			SELECT JOB
            FROM MY_EMP
            WHERE ENAME = 'WARD'
			LIMIT 1
		)
		AND EMPNO != (
			SELECT EMPNO
            FROM MY_EMP
            WHERE ENAME = 'WARD'
            LIMIT 1
		)
	) AS SUB
);

SELECT ENAME, JOB
FROM MY_EMP
WHERE JOB = (
	SELECT JOB
    FROM MY_EMP
    WHERE ENAME = 'WARD'
    LIMIT 1
);


-- Q8-2) WARD의 월급을 SMITH의 월급과 같게 수정하자.
SELECT 
  W.ENAME,
  W.SAL,
  S.ENAME,
  S.SAL
FROM MY_EMP W
JOIN MY_EMP S
WHERE W.ENAME = 'WARD' AND S.ENAME = 'SMITH';

UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = 'WARD'
    LIMIT 1
) AS W
JOIN (
	SELECT SAL
    FROM MY_EMP
    WHERE ENAME = 'SMITH'
    LIMIT 1
) AS S
SET MY_EMP.SAL = S.SAL
WHERE MY_EMP.EMPNO = W.EMPNO;

SELECT 
  W.ENAME,
  W.SAL,
  S.ENAME,
  S.SAL
FROM MY_EMP W
JOIN MY_EMP S
WHERE W.ENAME = 'WARD' AND S.ENAME = 'SMITH';

-- Q8-3) KING의 직업을 SMITH와 같게 수정하자.
SELECT 
  K.ENAME,
  K.JOB,
  S.ENAME,
  S.JOB
FROM MY_EMP K
JOIN MY_EMP S
WHERE K.ENAME = 'KING' AND S.ENAME = 'SMITH';

UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE ENAME = 'KING'
    LIMIT 1
) AS K
JOIN (
	SELECT JOB
    FROM MY_EMP
    WHERE ENAME = 'SMITH'
    LIMIT 1
) AS S
SET MY_EMP.JOB = S.JOB
WHERE MY_EMP.EMPNO = K.EMPNO;

SELECT 
  K.ENAME,
  K.JOB,
  S.ENAME,
  S.JOB
FROM MY_EMP K
JOIN MY_EMP S
WHERE K.ENAME = 'KING' AND S.ENAME = 'SMITH';

-- Q8-4) 사원번호 7499와 같은 직업을 가진 사원의 입사일을 오늘 날짜로 수정하자.
SELECT EMPNO, ENAME, JOB
FROM MY_EMP
WHERE EMPNO = 7499;

-- 벌서 7499 사원 삭제 된듯? 롤백!!!
ROLLBACK;

SELECT EMPNO, ENAME, JOB, HIREDATE
FROM MY_EMP
WHERE JOB = (
	SELECT JOB
	FROM MY_EMP
	WHERE EMPNO = 7499
);

UPDATE MY_EMP
JOIN (
	SELECT EMPNO
    FROM MY_EMP
    WHERE JOB = (
				SELECT JOB
                FROM MY_EMP
                WHERE EMPNO = 7499
                )
	AND EMPNO != 7499
) AS SUB
ON MY_EMP.EMPNO = SUB.EMPNO
SET MY_EMP.HIREDATE = NOW();
-- ERROR 1093

UPDATE MY_EMP
SET HIREDATE = NOW()
WHERE EMPNO IN (
	SELECT EMPNO FROM (
		SELECT EMPNO
        FROM MY_EMP
        WHERE JOB = (
			SELECT JOB
            FROM MY_EMP
            WHERE EMPNO = 7499
            )
		AND EMPNO != 7499
	) AS SUB
);

SELECT EMPNO, ENAME, JOB, HIREDATE
FROM MY_EMP
WHERE JOB = (
	SELECT JOB
	FROM MY_EMP
	WHERE EMPNO = 7499
);
rollback;
-- Q9) MY_EMP, MY_DEPT 테이블에 PRIMARY KEY를 추가하자.
-- 이미 위에서 했어요 ㅠㅠ

-- Q10) MY_EMP 테이블에 외래키를 설정하고 ON DELETE/UPDATE CASCADE 옵션을 추가하자.
ALTER TABLE MY_EMP
DROP FOREIGN KEY fk_my_emp_dept; -- 설정에서 외래키 빼기 (위에서 기설정 되어 있어서)

SHOW INDEX FROM MY_EMP;

ALTER TABLE MY_EMP
ADD CONSTRAINT fk_my_emp_dept
FOREIGN KEY (DEPTNO)
REFERENCES MY_DEPT(DEPTNO)
ON DELETE CASCADE
ON UPDATE CASCADE;

-- 인덱스 + UPDATE, DELETE ON CASCADE 확인하기
SELECT
  TABLE_NAME,
  CONSTRAINT_NAME,
  UPDATE_RULE,
  DELETE_RULE
FROM
  information_schema.REFERENTIAL_CONSTRAINTS
WHERE
  CONSTRAINT_SCHEMA = DATABASE();

-- Q11) MY_DEPT에서 DEPTNO 10을 삭제한 후, MY_EMP에서 DEPTNO 10을 확인하자.
SELECT *
FROM MY_EMP
WHERE DEPTNO = 10;

DELETE FROM MY_DEPT
WHERE DEPTNO = 10;

SELECT *
FROM MY_EMP;

-- Q12) MY_DEPT에서 DEPTNO 20을 200으로 변경한 후, MY_EMP에서 DEPTNO 200을 확인하자.
SELECT *
FROM MY_EMP
WHERE DEPTNO = 20;

UPDATE MY_DEPT
SET DEPTNO = 200
WHERE DEPTNO = 20;

SELECT *
FROM MY_EMP;





