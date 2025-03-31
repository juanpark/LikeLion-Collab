-- students 테이블
-- 1) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정
-- 3) CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정
-- 4) CREATE TABLE에서 검사 (CHECK) 제약 조건 지정
-- 5) CREATE TABLE에서 열에 기본값 지정  DEFAULT 
-- 6) CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정

--  << 학생 정보를 유지하기 위한 students 테이블 생성 >>- 

CREATE DATABASE  STUDENTS;
USE STUDENTS;
DROP TABLE STUDENTS;
-- Q1) CREATE TABLE로 새 테이블 만들기
create table students(
	student_id int,
    student_number varchar(10),
    first_name varchar(50),
    last_name varchar(50),
    middle_name varchar(50),
    birthday date,
    gender enum('M','F'),
    paid_flag bool
);

desc students;
-- Q1-1. 데이터 입력
insert into students
values
(1, '1', '1', '1', '1', now(), 'M', true),
(2, '1', '1', '1', '1', now(), 'F', 0),
(3, '1', '1', '1', '1', now(), 'F', false),
(4, '1', '1', '1', '1', now(), 'M', true);

-- Q1-2. 전체 내용 확인
select * 
from students;

#################################################
-- Q2) CREATE TABLE로 새 테이블 만들기
-- 2) CREATE TABLE에서 기본 키 (PRIMARY KEY) 제약 조건 지정 _ 식별키
-- 테이블당 하나만 지정할 수 있다. (단일키, 복합키) = u+nn
create table students02(
	student_id		int,
    student_number	varchar(10),
    first_name 		varchar(50),
    last_name 		varchar(50),
    middle_name 	varchar(50),
    birthday 		date,
    gender 			enum('M','F'),
    paid_flag 		bool,
    primary key(student_id)
);

DESC STUDENTS02;
-- Q2-1 데이터 입력
-- 중복데이터 X + NOT NULL = PK

INSERT INTO students
values
(1, '1', '1', '1', '1', NOW(), 'M', TRUE),
(2, '1', '1', '1', '1', NOW(), 'F', 0),
(3, '1', '1', '1', '1', NOW(), 'F', FALSE),
(4, '1', '1', '1', '1', NOW(), 'M', TRUE);

-- Q2-2 전체 내용 확인
SELECT *
FROM STUDENTS02;

-- Q2-3 PK 확인
INSERT INTO STUDENTS02
VALUES(1, '1', '1', '1', '1', NOW(), 'M', TRUE);
-- SHOULD PRODUCE A DUPLICATE ERROR

INSERT INTO STUDENTS02
VALUES(NULL, '1', '1', '1', '1', NOW(), 'M', TRUE);
-- SHOULD PRODUCE A NULL ERROR

-- Q2-4 
SHOW CREATE TABLE STUDENTS;

SELECT CONSTRAINT_NAME, CONTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'STUDENTS';

SHOW CREATE TABLE STUDENTS02;

SELECT CONSTRAINT_NAME, CONTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS02' AND TABLE_NAME = 'STUDENTS02';

-- Q3 PK 복합키를 확인해보자

CREATE TABLE students03(
	student_id		INT,
    student_number	VARCHAR(10),
    PRIMARY KEY (student_id, student_number)
);
DESC STUDENTS03;

-- Q3-1 데이터를 입력해보자.
INSERT INTO students03
VALUES (1, 1), (1, 2), (1, 3), (1, 4); -- SHOULD HAVE BEEN CASTED

-- TEST
INSERT INTO students03
VALUES (2, 1), (2, 2), (2, 3), (2, 4);

-- TEST
INSERT INTO students03
VALUES (3, 1), (3, 2), (3, 3), (3, NULL); -- ERROR CODE : 1048

-- TEST
INSERT INTO students03
VALUES (1, '1'), (1, '2'), (1, '3'), (1, '4'); -- ERROR CODE : 1062 DUPLICATE ENTRY
SELECT *
FROM STUDENTS03;

-- Q3-2 제약조건을 확인하자
SELECT CONTRAINT_NAME, CONTRAINT_TYPE
FROM information_schema.TABLE_CONTRAINTS
WHERE TABLE_SCHEMA = 'STUDENTS' AND TABLE_NAME = 'STUDENTS03';

DESC information_schema.TABLE_CONSTRAINTS;

-- Q4) 자동증가 구현하는 제약조건을 확인 해보자. PK도 걸고 자동증가도 걸고..
CREATE TABLE students04(
	student_id		INT AUTO_INCREMENT,
    student_number	VARCHAR(10),
    PRIMARY KEY (student_id)
);
DESC STUDENTS04;

INSERT INTO students04
VALUES (10), (20), (30), (40);

SELECT *
FROM STUDENTS04;

-- Q4-1 테이블 수정하자 자동증가 초기값 100으로 
ALTER TABLE STUDENT04
	AUTO_INCREMENT = 100;
    
DESC STUDENTS04;

INSERT INTO students04
VALUES (10), (20), (30), (40);

SELECT *
FROM STUDENTS04;

-- 번외편 https://dev.mysql.com/doc/refman/8.4/en/innodb-auto-increment-handling.html
CREATE TABLE t1 (
	c1 INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	c2 CHAR(1)
) ENGINE = INNODB;

DESC T1;

INSERT INTO t1 (c1,c2) 	VALUES	(1,'a'),
								(NULL,'b'), 
                                (5,'c'),
                                (NULL,'d');
INSERT INTO t1 (c1,c2) 	VALUES	(11,'a'),
								(NULL,'b'), 
                                (15,'c'),
                                (NULL,'d');                                

SELECT *
FROM T1;


SHOW TABLE STATUS LIKE 't1';
SHOW TABLE STATUS LIKE 'students04';


-- T1 테이블의 DROPT PRIMARY KEY를 이용해서 삭제 해보자
ALTER TABLE T1 DROP PRIMARY KEY;
-- Error Code: 1075. Incorrect table definition; 
-- there can be only one auto column and it must be defined as a key

ALTER TABLE T1 MODIFY COLUMN c1 INT; -- 컬럼 수정 : 자동 증가 속성 해제
ALTER TABLE T1 DROP PRIMARY KEY; -- 삭제

DESC T1;

-- Q5) 자동증가 구현하는 제약조건을 확인 해보자. PK도 걸고 자동증가도 걸고..
CREATE TABLE students05(
	student_id		INT AUTO_INCREMENT,
    student_number	VARCHAR(10) DEFAULT 'ABC',
    PRIMARY KEY (student_id, student_number)
);
DROP TABLE STUDENTS05;
DESC STUDENTS05;

INSERT INTO students05
	VALUES (1, 10), (2, 20),(3, 30),(4, 40);
    
INSERT INTO students05(student_id)
	VALUES (1);

SELECT *
FROM STUDENTS05;


-- Q6) 복합키, 자동증가, 기본값으로 지정하고 각 제약조건을 삭제 해보자
CREATE TABLE students06(
	student_id		INT AUTO_INCREMENT,
    student_number	VARCHAR(10) DEFAULT 'ABC',
    student_name	VARCHAR(50), 
    PRIMARY KEY (student_id, student_number)
);
DESC STUDENTS06;

INSERT INTO students06(student_name)
	VALUES (1);
    
SELECT *
FROM STUDENTS06;

-- Q6-1 기본키 삭제
ALTER TABLE students06
DROP PRIMARY KEY;
-- Error Code: 1075. Incorrect table definition; 
-- there can be only one auto column and it must be defined as a key

ALTER TABLE students06 MODIFY COLUMN student_id INT; -- 자동 증가 속성 해제 = 컬럼 수정한다. 
ALTER TABLE students06
DROP PRIMARY KEY;

-- Q6-2 DEFAULT 삭제 -> 칼럼 레벨
ALTER TABLE students06 DROP DEFAULT;
-- Error Code: 1064. You have an error in your SQL syntax; 
-- check the manual that corresponds to your MySQL server version for the right syntax to use near 'DEFAULT' at line 1

ALTER TABLE students06
ALTER student_number DROP DEFAULT;

DESC STUDENTS06;

-- Q6-3 삭제된 DEFAULT를 추가해 보자.
ALTER TABLE students06
ALTER student_number SET DEFAULT ('XYZ');

DESC STUDENTS06;

-- Q7) 제약조건을 생성해보자.
-- CREATE TABLE에서 고유 키(UNIQUE KEY) 제약 조건 지정: 중복데이터 X + NULL 허용
-- CREATE TABLE에서 검사 (CHECK) 제약 조건 지정 : 범위지정

CREATE TABLE students07(
	student_id		INT UNIQUE,
    student_number	VARCHAR(10),
    birthday	DATE, 
    UNIQUE KEY (student_id),
    CHECK (birthday >= '2000-01-01') -- 범위지정
);
DESC STUDENTS07;

INSERT INTO students07(student_id) VALUES(NULL); -- UNIQUE KEY NULL 값 확인 
INSERT INTO students07(student_id, birthday) VALUES(1, NOW());
INSERT INTO students07(student_id, birthday) VALUES(2, NOW());
INSERT INTO students07(student_id, birthday) VALUES(3, '1999-01-01');
-- Error Code: 3819. Check constraint 'students07_chk_1' is violated.


SELECT *
FROM students07;

SHOW CREATE TABLE students07;

-- 체크 제약조건 확인 
SELECT CONSTRAINT_NAME, CHECK_CLAUSE
FROM information_schema.CHECK_CONSTRAINTS;
-- 'students07_chk_1', '(`birthday` >= _utf8mb4\\\'2000-01-01\\\')'

DESC information_schema.CHECK_CONSTRAINTS;

CREATE TABLE students071(
	student_id		INT UNIQUE,
    student_number	VARCHAR(10),
    birthday	DATE, 
    UNIQUE KEY (student_id),
    CHECK (birthday >= '2000-01-01'), -- 범위지정
    CHECK (student_number >= 10)
);
-- 체크 제약조건 확인 
SELECT CONSTRAINT_NAME, CHECK_CLAUSE
FROM information_schema.CHECK_CONSTRAINTS;
-- # CONSTRAINT_NAME, CHECK_CLAUSE
-- students07_chk_1, (`birthday` >= _utf8mb4\'2000-01-01\')
-- students071_chk_1, (`birthday` >= _utf8mb4\'2000-01-01\')
-- students071_chk_2, (`student_number` >= 10)

-- Q7-1 제약조건을 확인 후 체크제약조건을 삭제 해보자.

-- Q7-2 테이블의 제약조건을 확인 후 남아있는 키값을 삭제하자.
-- DROP INDEX이다.
SELECT CONSRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'students071';

ALTER TABLE students071
DROP INDEX student_id;

SHOW KEYS FROM students05;
SHOW KEYS FROM students06;
SHOW KEYS FROM students07;

-- Q8) 참조형 테이블을 생성해 보자.
-- CREATE TABLE에서 외래 키 (FOREIGN KEY) 제약 조건 지정
DROP TABLE STUDENTS05;
CREATE TABLE STUDENTS05 (
	student_id		INT AUTO_INCREMENT,
    student_number 	VARCHAR(10) DEFAULT 'ABC',
    PRIMARY KEY (student_id)
);
DESC STUDENTS05;

INSERT INTO STUDENTS05 VALUES(1,1);
INSERT INTO STUDENTS05 VALUES(2,2);

SELECT * FROM STUDENTS05;

-- 현재 STUDENT_MY테이블의 student_id를 student05의 student_id로 참조 시키자.
CREATE TABLE student_MY(
	student_id		INT,
    FOREIGN KEY(student_id) REFERENCES students05(student_id) -- student_my_ibfk_1
);
select * from students05;
desc student_my;
SHOW KEYS FROM student_MY;
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'student_MY';

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE, REFERENCED_TABLE_NAME
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE TABLE_NAME = 'student_MY';

DESC information_schema.REFERENTIAL_CONSTRAINTS;

-- 데이터 입력
insert into student_my values(1);
insert into student_my values(null);
insert into student_my values(3); -- Error 1452 참조한 테이블에 없는 값을 넣었기 때문에
insert into student_my values(2);
-- 데이터 확인
select * from student_my;
