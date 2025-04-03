/*
1. 트랜잭션의 4대 특성 (ACID)
2. 사용자 및 권한 관리 (CREATE USER, GRANT, REVOKE, SHOW GRANTS 등)
3. MySQL 시스템 테이블 구조 (mysql.user, mysql.db 등)
4. 역할(Role) 기반 권한 제어 및 기본 역할 설정
5. 사용자 권한 회수 및 재부여

===================================================================
단계 1: 트랜잭션의 대표적인 4가지 특성
===================================================================

-- 트랜잭션의 4가지 대표적인 특성에 대한 설명:
-- 1. 원자성 (Atomicity)    : 전부 성공적으로 수행되거나 수행되지 않아야 한다.  
    -- 트랙잭션이 성공하면 모든 변경사항이 커밋되어 데이터베이스에 반영하고, 실패하면 트랜잭션이 시작된 시점 이전 상태로 돌아간다.  
-- 2. 일관성 (Consistency)  : 데이터베이스에 무결성 제약조건(외래키, 고유키등)이 트랜잭션 후에도 여전히 유효하다   
-- 3. 고립성 (Isolation)  :  독립적으로 수행= 격리(고립)수준 + 동시성 제어   
-- 4. 지속성 (Durability)  : 트랜잭션이 완료된 이후  외부에 의해서 예외가 발생될 경우라도 데이터 손실되지 않는다. 
*/
  -- 테스트 해보자. 
desc emp_test;
SET AUTOCOMMIT = 0;   
--  삭제 후 저장 및 취소

SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;

DELETE FROM EMP_TEST 
WHERE DEPTNO=10;
SELECT  COUNT(*) FROM EMP_TEST;
COMMIT;  -- 11개  

INSERT INTO EMP_TEST(EMPNO) VALUES(1);
INSERT INTO EMP_TEST(EMPNO) VALUES(1);
INSERT INTO EMP_TEST(EMPNO) VALUES(1);  -- 14개
ROLLBACK;  -- 11개 

INSERT INTO EMP_TEST(EMPNO) VALUES(1);
INSERT INTO EMP_TEST(EMPNO) VALUES(1);
INSERT INTO EMP_TEST(EMPNO) VALUES(1);
COMMIT; -- 14개  
 
SELECT * FROM EMP_TEST;

 /*
===================================================================
단계 2: MySQL의 권한 및 사용자 관리 개요  : https://dev.mysql.com/doc/refman/8.4/en/mysqladmin.html
===================================================================
*/       
-- 1) MySQL에서는 데이터베이스, 호스트, 사용자, 테이블, 필드별로 권한을 설정할 수 있음.    
-- 2) mysql 데이터베이스에 유저/패스워드/호스트명을 등록하여 관리함.
-- 3) 관리용 테이블: db _INSERT,DELETE , host_호스트제한, 
--     user_ 사용자 테이블   , tables_priv[SELECT,INSERT,DELETE,UPDATE] , columns_priv.

/*
1) MySQL 권한 관리 범위
데이터베이스:	특정 DB 전체에 대한 권한 설정 (mydb.*)
테이블 :	특정 테이블에 대한 권한 설정 (mydb.table1)
필드(컬럼):	테이블의 특정 컬럼에 대한 권한 설정 (columns_priv)
사용자	:사용자 계정별로 권한 설정 ('user'@'host')
호스트	: 어떤 클라이언트(호스트)에서 접속 가능한지 설정

2)사용자 정보 :  mysql 시스템 데이터베이스(MySQL 서버의 계정, 권한, 인증정보)에 저장됨.  
user:	사용자 계정 정보 (이름, 호스트, 비밀번호, 글로벌 권한 등)
db	:특정 DB에 대한 권한 설정 정보
host:	호스트별로 DB 접속 제어 가능
tables_priv:	테이블 수준의 세부 권한 (SELECT, INSERT, UPDATE, DELETE)
columns_priv:	열(컬럼) 단위의 권한 제어
procs_priv	:저장 프로시저, 함수에 대한 권한

3) 관리자권한 DCL  구문
GRANT: 권한 부여
REVOKE: 권한 회수
SHOW GRANTS FOR 'user'@'host': 권한 확인
FLUSH PRIVILEGES : 변경된 권한을 즉시 반영
 */
 -- 사용자 권한 보기
SELECT host, user FROM mysql.user;

-- 사용자별 권한 확인
-- SHOW GRANTS FOR 'mydb'@'%';
SHOW GRANTS FOR 'juanpark'@'%';

-- 시스템 테이블 구조 보기
DESC mysql.user;
DESC mysql.db;
 
 /*
===================================================================
단계 3: MySQL 데이터베이스 및 사용자 정보 확인
===================================================================
*/
-- mysql 데이터베이스 선택
USE mysql; -- 시스템 데이터베이스

-- mysql에 있는 모든 테이블 확인
SHOW TABLES;

-- db 테이블 구조 확인
SHOW FIELDS FROM db;
SELECT * FROM db;

-- 사용자(user) 테이블 구조 확인
SHOW FIELDS FROM user;
SELECT * FROM user;

 /*
===================================================================
단계 4: MySQL의 관리자 명령어 및 권한 제어
===================================================================
*/
-- mysqladmin 명령어를 통해 데이터베이스 및 서버 관리 가능
-- 예: reload, shutdown, process 등.

-- DCL(Data Control Language) 명령어로 데이터베이스 접근 제어
-- 1) GRANT: 권한 부여
-- 2) REVOKE: 권한 회수

 /*
===================================================================
단계 5: 사용자 계정 생성 및 권한 부여
===================================================================
권한(Privileges):  사용자 또는 역할이 어떤 작업(데이터베이스, 테이블, 컬럼, 프로시저)을 할 수 있는지를 제어하는 기능
1. 전역(Global) 권한 :  CREATE USER, SHUTDOWN, FILE, RELOAD, PROCESS, SUPER
    ex)GRANT ALL ON *.* TO 'user'@'host';
    
2. 데이터베이스(DB) 수준 권한 :특정 데이터베이스 전체에 대한 권한
 CREATE, DROP, ALTER, INDEX, SELECT, INSERT, UPDATE, DELETE
ex)GRANT SELECT, INSERT ON mydb.* TO 'user'@'host';

 3. 테이블 수준 권한 : 특정 테이블에 대해 부여하는 권한
  SELECT, INSERT, UPDATE, DELETE, REFERENCES
   ex)GRANT SELECT, UPDATE ON mydb.mytable TO 'user'@'host';

4. 컬럼 수준 권한 :테이블 내의 특정 컬럼에 부여하는 권한 SELECT(col1), UPDATE(col2)
ex )GRANT SELECT (col1), UPDATE (col2) ON mydb.mytable TO 'user'@'host';

5. 루틴(프로시저/함수) 권한
GRANT EXECUTE ON PROCEDURE mydb.myproc TO 'user'@'host';
GRANT EXECUTE ON PROCEDURE mydb.* TO 'user'@'host';
*/
-- 새로운 사용자 계정 생성
CREATE USER 'new_user'@'localhost' IDENTIFIED BY 'new_password';  -- 로컬 호스트 접근 가능 사용자
CREATE USER 'new_user'@'%' IDENTIFIED BY 'new_password';          -- 네트워크 접근 가능 사용자
CREATE USER 'new_TEST'@'%' IDENTIFIED BY 'new_Test'; 

-- 권한 부여
GRANT ALL PRIVILEGES ON my_emp.* TO 'new_user'@'localhost';       -- 특정 데이터베이스에 대한 권한 부여
GRANT ALL PRIVILEGES ON my_emp.* TO 'new_TEST'@'%';

-- 비밀번호 변경
ALTER USER 'new_user'@'localhost' IDENTIFIED BY 'new_password';
ALTER USER 'new_TEST'@'%' IDENTIFIED BY 'new_1234';

-- 권한 추가
GRANT ALL PRIVILEGES ON my_test.* TO 'existing_user'@'localhost';
GRANT SELECT, INSERT, UPDATE, DELETE ON my_emp.table_name TO 'existing_user'@'localhost';

GRANT ALL PRIVILEGES ON my_emp.* TO 'new_TEST'@'%';

-- 변경사항 즉시 적용
FLUSH PRIVILEGES;

 /*
===================================================================
단계 6: 사용자 및 권한 확인 GRANTS
===================================================================
*/
-- 관리자 권한으로 생성된 사용자 및 호스트 정보 확인
DESC mysql.user;
SELECT host, user FROM mysql.user;

-- 새로운 사용자 계정 생성
CREATE USER 'mysample'@'%' IDENTIFIED BY 'test';
CREATE USER 'mysample'@'localhost' IDENTIFIED BY 'test';
CREATE USER 'mysample07'@'%' IDENTIFIED BY 'test';
CREATE USER 'mysample07'@'localhost' IDENTIFIED BY 'test';

-- 생성된 사용자 확인
SELECT host, user FROM mysql.user;

-- 권한 확인
SHOW GRANTS FOR 'mysample'@'%';
SHOW GRANTS FOR 'mysample'@'localhost';
SHOW GRANTS FOR 'mysample07'@'%';
SHOW GRANTS FOR 'mysample07'@'localhost';

 /*
===================================================================
단계 7: 데이터베이스 및 테이블 권한 설정
===================================================================
*/
-- 특정 데이터베이스 및 테이블에 대한 권한 설정
GRANT ALL PRIVILEGES ON world.* TO 'mysample'@'%';
FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON world.* TO 'mysample07'@'%';
FLUSH PRIVILEGES;

-- 특정 테이블에 대한 권한 설정 (localhost 사용자)
GRANT ALL PRIVILEGES ON world.city TO 'mysample'@'localhost';
GRANT ALL PRIVILEGES ON world.city TO 'mysample07'@'localhost';
FLUSH PRIVILEGES;

-- TERINAL에서 새로 생성한 계정으로 접속해서 테스트
-- mysql -u mysample07 -p
SELECT CURRENT_USER();
USE WORLD;
SELECT * FROM CITY LIMIT 10;
USE MY_EMP;
-- ERROR 1044 (42000): Access denied for user 'mysample07'@'localhost' to database 'my_emp'

 /*
===================================================================
단계 8: ROLE 생성 및 권한 부여
===================================================================
*/
-- ROLE 생성 _ 사용자 이름 생성
CREATE ROLE 'myselect';
CREATE ROLE 'myupdate';

-- ROLE에 권한 부여 _ 작업할 수 있는 목록을 부여 
GRANT SELECT ON *.* TO 'myselect';
GRANT UPDATE ON *.* TO 'myupdate';

-- 사용자 계정 생성
CREATE USER 'my_select'@'%' IDENTIFIED BY '111';
CREATE USER 'my_update'@'%' IDENTIFIED BY '111';

-- ROLE을 사용자에게 부여
GRANT 'myselect' TO 'my_select'@'%';
GRANT 'myupdate' TO 'my_update'@'%';
FLUSH PRIVILEGES;

-- ROLE 권한 설정 및 확인
SET DEFAULT ROLE ALL TO 'my_select'@'%';
SET DEFAULT ROLE ALL TO 'my_update'@'%';

-- 권한 확인
SHOW GRANTS FOR 'my_select'@'%';
SHOW GRANTS FOR 'my_update'@'%';

 /*
===================================================================
단계 9: 권한 해제 및 사용자 생성
===================================================================
*/
-- ROLE 권한 해제
REVOKE 'myselect' FROM 'my_select'@'%';
REVOKE SELECT ON *.* FROM 'my_select'@'%';

-- 새로운 사용자 계정 생성 및 권한 부여
CREATE USER 'patmat'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON MyTest.* TO 'patmat'@'localhost';
FLUSH PRIVILEGES;

-- 사용자 삭제
DROP USER 'my_select'@'%';
DROP USER 'my_update'@'%';