#https://dev.mysql.com/doc/refman/8.4/en/bit-value-literals.html
USE MY_EXAM;
CREATE TABLE t (b BIT(8)); # 8BIT를 사용하겠다 / 부울 값(TRUE,FALSE) /플래그 
#MYSQL 
INSERT INTO t SET b = b'11111111';  #255 
INSERT INTO t SET b = b'1010';  #10 
INSERT INTO t SET b = b'0101'; # 5b

#SQL  
INSERT INTO T VALUES(b'11'); ## 

-- Q1 전체 구조확인확인
DESC T;

-- Q2 테이블 내용확인 
SELECT  *
FROM  T;
-- Q3 도움말 확인 
HELP BIT;

-- Q4 각 비트별로 값을 변환 후 출력 해보자.  
SELECT b+0, BIN(b), OCT(b), HEX(b) FROM t;
SELECT b FROM t;

-- Q5  CAST함수를 이용해보자.   정수로 변환해보자.   
HELP CAST;
SELECT CAST(B AS UNSIGNED) FROM T;


# SET SQL_SAFE_UPDATES = 0;  # 수정 권한 풀기  
-- update 테이블명 set 컬럼  = 변경할 값 ,,,, where  조건문  ;  -> 조건 수정 
-- Q6. b'11111111' 을 b'0101'로 수정하자.  
UPDATE T
SET   b=b'0101'
WHERE  b=b'11111111';

SELECT b FROM t;

-- delete from 테이블명 where  조건문 ;  -> 조건 삭제  
-- 07. b'11'를 찾아 삭제 해보자  
SET SQL_SAFE_UPDATES = 0; 
DELETE FROM T
WHERE B=b'11';

-- 08. 고유값만 출력 해보자  
SELECT DISTINCT B 
FROM T;

-- 09.새로운 열을 추가해보자 . -> 테이블이 새로운 컬럼이 추가되면서 수정이 된다.  
 ALTER TABLE T
 ADD C VARCHAR(20), 
 ADD D VARCHAR(20), ADD E VARCHAR(20) ;

 DESC T;

SELECT  *
FROM T;

-- 10. c 컬럼을 삭제 해보자.  
 ALTER TABLE T
 DROP D;


-- insert into 테이블명 values(값,,,); insert into 테이블명(컬럼명) values(값);

-- update 테이블명 set 컬럼  = 변경할 값 ,,,, where  조건문  ;  -> 조건 수정 
-- update 테이블명 set 컬럼  = 변경할 값 ,,,,;  ->컬럼 전체 수정  

-- delete from 테이블명  ;  -> 전제 삭제  

SELECT TRUE, true, FALSE, false;

SELECT _binary'hello';#이진 문자열은 접두어를 사용한 구문을 함께 지정해서 저장한다.  
SELECT  POINT(10,20);# 공간좌표 데이터  
SELECT  ST_AsText(POINT(10,20));  #문자열로 변환 후 출력 
# 문자리터럴 , 숫자 리터럴 , 16진수리터럴 'Ox', 'X' 접두사, 비트필드 BIT(8) , 부울리터럴, 
#_binary , POINT() :공간 데이터 표현 , 날짜 시간 ,  

/*
DB 스키마란?  Schema 소유자라고 하는 특정 데이터 베이스 사용자 이름과 연결된 데이터 베이스 개체의 컬렉션 
 Schema Object Names  
1. 스키마 개체 유형 : 테이블, 뷰, 인덱스,시퀀스 , 프로시저, 함수, 트리거등 
2. 명명규칙 : 이름의 길이, 사용할 수 있는  문자유형 (일반적으로 영숫자, _ , 대소문자제한) 
    # 132   -> 스토리지 엔진에서 64자정도    
    
    lower_case_table_names    / 서버시작시 설정값       
    서버시작시 설정값 :  일관성, 복제(환경설정) , 크로스플랫폼  
    
3. 고유성  : 단일 스키마 내에서의 이름은 고유 
4. 적격스키마  : 스키마 객체를 참조하려면 스키마 명을 명시해야 한다. MY_EMP.EMP  SHEMA_NAME.TABLE_TABLE
5. 키워드 : 예약어 목록 
6. 네임스페이스   : Schema  
7. 데이터 베이스 호환성 : 데이터 베이스 명세서                                                  
*/
/*https://dev.mysql.com/doc/refman/8.4/en/show-tables.html
SHOW [EXTENDED] [FULL] TABLES
    [{FROM | IN} db_name]
    [LIKE 'pattern' | WHERE expr]*
SHOW {DATABASES | SCHEMAS}
    [LIKE 'pattern' | WHERE expr]
 */

-- Q1. 사원테이블에서 입사일에서 입사년도, 입사월, 입사일, 입사요일을  추출해서 별칭으로 출력해보자  
SELECT 
    EXTRACT(YEAR FROM hiredate) AS 입사년도,
    EXTRACT(MONTH FROM hiredate) AS 입사월,
    EXTRACT(DAY FROM hiredate) AS 입사일,
    DAYNAME(hiredate) AS 입사요일
FROM 
    EMP;

-- Q2. 사원테이블에서 입사일에서 입사년도, 입사월, 입사일, 입사요일을  추출해서 별칭으로 출력해보자  
--  CASE~ WHEN~ THEN 선택문을 이용해서 월요일 ~~~ DAYOFWEEK(DATE) 1=일요일 ~~
HELP DAYOFWEEK; 
SELECT 
    EXTRACT(YEAR FROM hiredate) AS 입사년도,
    EXTRACT(MONTH FROM hiredate) AS 입사월,
    EXTRACT(DAY FROM hiredate) AS 입사일,
    CASE DAYOFWEEK(hiredate) 
        WHEN 1 THEN '일요일'
        WHEN 2 THEN '월요일'
        WHEN 3 THEN '화요일'
        WHEN 4 THEN '수요일'
        WHEN 5 THEN '목요일'
        WHEN 6 THEN '금요일'
        WHEN 7 THEN '토요일'         
    END  AS 입사요일
    FROM   EMP;


/*
  Query Attributes  : 쿼리문을 실행할 때 쿼리구조, 수행작업의 유형 , 데이터접근방식 , 스키마상태등 
   데이터 비율/쿼리 실행시 리턴되는 수 = 조인, 인덱싱 
   비용(COST) :  CPU 시간, 메모리사용량 , 디스크 I/O  = 데이터베이스최적화 하기 = 비용추정  (실행계획) 
   투영(Projection)   작업  : 쿼리가 검색하는 열이나 필드의 집합  -> 어떤 데이터가 선택되는지  
   조건  : where절을 사용했을때 특정기준 값   /  집계 (데이터 요약 그룹화)  
   이노디비 스토리지 특성값  (동시성제어  = 데이터 무결성) 트랜젝션 ,  복원, 버퍼  
*/
SHOW VARIABLES LIKE 'character_set_system';

SHOW VARIABLES LIKE 'datadir';

DROP TABLE T1;
CREATE TABLE t1 (
  -- literal defaults
  i INT         DEFAULT 0,
  c VARCHAR(10) DEFAULT 'ABCD',
  -- expression defaults
  f FLOAT       DEFAULT (RAND() * RAND()),
  b BINARY(16)  DEFAULT (UUID_TO_BIN(UUID())),
  d DATE        DEFAULT (CURRENT_DATE + INTERVAL 1 YEAR),
  p POINT       DEFAULT (Point(0,0)),
  j JSON        DEFAULT (JSON_ARRAY())
);

DESC  T1;
INSERT INTO T1(i) VALUES(100); 
INSERT INTO T1(C) VALUES(NULL); 
SELECT  * FROM T1;

SELECT COUNT(C) , COUNT(*) FROM T1;

SELECT COUNT(C)
FROM T1
WHERE C IS NOT NULL;

