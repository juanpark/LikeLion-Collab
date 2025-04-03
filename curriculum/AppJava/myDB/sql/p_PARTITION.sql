USE MY_EMP;
/*
PARTITION  : 인덱스 또는 테이블에서 논리적 분할하며 테이블의 컬럼 값을 기준으로 데이터를 나누는 방식 
 - 날짜 , 범위, 값을 기준으로 분할 작업  
 - 파티션 키를 설정  -> 파티션 유형[범위, 특정기준_list, hash, key_mysql결정] 
 -> CREATE TABLE [ALTER TABLE]   
 
 - 파티션  유형  
1) RANGE 파티셔닝: 특정 컬럼의 값 범위를 기준 
                -날짜, 숫자 등의 연속적인 데이터에 적합. (ex: 연도별, 월별 데이터 분리)
                
2) LIST 파티셔닝: 특정 컬럼의 값 목록을 기준
                -특정 카테고리나 상태 값 등에 적합합니다. (ex: 지역별, 제품 유형별 데이터 분리)
                
3) HASH 파티셔닝: 파티션 키 컬럼의 해시 값을 이용하여 데이터를 분산, 데이터 분포를 균등하게 하고 싶을 때 유용

4)KEY 파티셔닝: HASH 파티셔닝과 유사하지만, 해시 함수를 사용자가 직접 지정하는 대신 MySQL 서버가 내부적 관리
                -주로 기본 키(Primary Key)나 고유 키(Unique Key)를 기준으로 사용
5)COLUMNS 파티셔닝 (RANGE COLUMNS, LIST COLUMNS): 여러 개의 컬럼 값을 조합하여 파티셔닝 기준으로 사용
                 - 복합적인 조건으로 데이터를 분리해야 할 때 유용 
 
*/
DROP TABLE t1;
################## 인덱스 없이 RANGE 파티션 선언 후 데이터 입력, 파티션확인, COST 비용확인, 파티션 목록확인
-- 인덱스 추가 -> 파티션확인, COST 비용확인, 파티션 목록확인
-- 1. year_col 기준으로 범위 파티션을 적용해 보자. 
CREATE TABLE t1 (
    id INT,
    year_col INT
)
PARTITION BY RANGE (year_col) (
    PARTITION p0 VALUES LESS THAN (1991),
    PARTITION p1 VALUES LESS THAN (1995),
    PARTITION p2 VALUES LESS THAN (1999),
    PARTITION p3 VALUES LESS THAN (2003),
    PARTITION p4 VALUES LESS THAN (2007)
);

DESC T1;
SELECT COUNT(*)
FROM T1; -- 데이터 개수 확인 

-- 2  파티션 정보를 확인 해보자. 
SELECT * FROM information_schema.PARTITIONS 
            WHERE TABLE_NAME = 'T1' AND TABLE_SCHEMA = 'MY_EMP';           
            
            
-- 3. 테이블에 파티션을 추가 해보자.  
ALTER TABLE t1 
 ADD PARTITION (PARTITION p5 VALUES LESS THAN (2012));

-- 4. 데이터를 추가 해보자 . 
INSERT INTO T1 VALUES (1, 1990); 
INSERT INTO T1 VALUES (2, 1993); 
INSERT INTO T1 VALUES (3, 1996); 
INSERT INTO T1 VALUES (4, 2000); 
INSERT INTO T1 VALUES (5, 2005); 

SELECT *
FROM T1;

-- 5. 실행 비용을 계산 해보자.  워크 밴치 에서 확인 cmd 접속해서 확인 해보자.  
EXPLAIN SELECT * FROM T1;
--  [실행시  오류 또는 경고가 날 경우  성능이 비효율 적이다.]
--  ? possible_keys = 쿼리실행시 최적화 사용가능한 인덱스, key (= 실제 인덱스 키값 ) 가 null이다.
--  전체 테이블의 레코드를 스캔하고 있다.       

-- 6. 실제 데이터 실행 시간과 함께 확인  
EXPLAIN ANALYZE SELECT 	* FROM T1 WHERE year_col < 1990;
-- '-> Index range scan on T1 using IDX_YEAR_COL over (NULL < year_col < 1990), with index condition: (t1.year_col < 1990)  (cost=0.71 rows=1) (actual time=0.0235..0.0235 rows=0 loops=1)\n'

EXPLAIN SELECT  * FROM T1 WHERE year_col < 2004;
EXPLAIN SELECT  * FROM T1 WHERE year_col < 2023;

commit;
SELECT  * FROM T1 WHERE year_col < 2023;
SELECT  * FROM T1 WHERE year_col < 1990;

-- 7. 파티션 객체 이름으로 데이터 추출
SELECT * FROM t1 PARTITION (p0);
SELECT * FROM t1 PARTITION (p1);
SELECT * FROM t1 PARTITION (p4);

EXPLAIN FORMAT=JSON SELECT * FROM t1 PARTITION (p0);
-- '{\n  \"query_block\": {\n    \"select_id\": 1,\n    \"cost_info\": {\n      \"query_cost\": \"0.35\"\n    },\n    \"table\": {\n      \"table_name\": \"t1\",\n      \"partitions\": [\n        \"p0\"\n      ],\n      \"access_type\": \"ALL\",\n      \"rows_examined_per_scan\": 1,\n      \"rows_produced_per_join\": 1,\n      \"filtered\": \"100.00\",\n      \"cost_info\": {\n        \"read_cost\": \"0.25\",\n        \"eval_cost\": \"0.10\",\n        \"prefix_cost\": \"0.35\",\n        \"data_read_per_join\": \"16\"\n      },\n      \"used_columns\": [\n        \"id\",\n        \"year_col\"\n      ]\n    }\n  }\n}'

EXPLAIN ANALYZE SELECT * FROM t1 PARTITION (p1);
-- '-> Table scan on t1  (cost=0.35 rows=1) (actual time=0.034..0.0394 rows=1 loops=1)\n'

EXPLAIN SELECT * FROM t1 PARTITION (p4);


-- 8. 각 파티션 객체와 데이터 수 체크 
SELECT PARTITION_NAME , TABLE_ROWS  FROM information_schema.PARTITIONS 
            WHERE TABLE_NAME = 'T1' AND TABLE_SCHEMA = 'MY_EMP';
            
-- 9.  t1에 year_col  인덱스을 추가해보자.  
ALTER TABLE  T1
ADD  INDEX IDX_YEAR_COL(year_col);

-- 9-1 범위에 없는 데이터를 추가 해보자.
INSERT INTO T1 VALUES (6, 2025); -- Error Code: 1526. Table has no partition for value 2025
INSERT INTO T1 VALUES (7, 1888); -- 성공
INSERT INTO T1 VALUES (8, NULL); -- 성공 

SELECT * FROM T1;

##############################

-- 10. List Partition  :특정값을 기준으로 데이터 분할  = 특정값들의 집합정의 / DEFAULT 파티션 x 
DROP TABLE T2;
CREATE TABLE t2 (
    id INT,
    year_col INT
)
PARTITION BY LIST (year_col) (
    PARTITION p0 VALUES IN (1990, 1991, 1992),
    PARTITION p1 VALUES IN (1993, 1994, 1995),
    PARTITION p2 VALUES IN (1996, 1997, 1998)
);

SELECT PARTITION_NAME , TABLE_ROWS  FROM information_schema.PARTITIONS 
            WHERE TABLE_NAME = 'T2' AND TABLE_SCHEMA = 'MY_EMP';

ALTER TABLE t2
 ADD PARTITION (PARTITION p3 VALUES IN (2000, 2005));
 
INSERT INTO T2 VALUES (1, 1990); 
INSERT INTO T2 VALUES (2, 1993); 
INSERT INTO T2 VALUES (3, 1996); 
INSERT INTO T2 VALUES (4, 2000); 
INSERT INTO T2 VALUES (5, 2005); 

SELECT * FROM t2 PARTITION (p0);
SELECT * FROM t2 PARTITION (p1);
SELECT * FROM t2 PARTITION (p2);
SELECT * FROM t2 PARTITION (p3);

EXPLAIN SELECT * FROM t2 PARTITION (p0);
EXPLAIN SELECT * FROM t2 PARTITION (p1);
EXPLAIN SELECT * FROM t2 PARTITION (p2);
EXPLAIN SELECT * FROM t2 PARTITION (p3);


SELECT PARTITION_NAME , TABLE_ROWS  FROM information_schema.PARTITIONS 
            WHERE TABLE_NAME = 'T2' AND TABLE_SCHEMA = 'MY_EMP';

-- 파티션 범위에 없어 ERROR CODE: 1526
INSERT INTO T2 VALUES (6, 2025);
-- Error Code: 1526. Table has no partition for value 2025
INSERT INTO T2 VALUES (7, 1888);
-- Error Code: 1526. Table has no partition for value 1888



SELECT * FROM T2;


-- 11.Hash Partition  : 균등 자동 분산  
  DROP TABLE T3;
  CREATE TABLE t3 (
    id INT,
    year_col INT
)
PARTITION BY HASH (year_col) 
PARTITIONS 4;

DESC T3;

-- 11-1 ) 데이터의 분포 확인  
SELECT PARTITION_NAME , TABLE_ROWS  
FROM information_schema.PARTITIONS 
WHERE TABLE_NAME = 'T3' AND TABLE_SCHEMA = 'MY_EMP';     
  
#######################################################################
  
CALL T3_INSERT(10000); -- 프로시저 작성 후 확인 

SELECT  * FROM T3;

-- 11-2) 데이터 쿼리 성능 확인   : P2의 2483 데이터중 탐색  
EXPLAIN SELECT * FROM t3  WHERE YEAR_COL  = 1998;

-- 11-3)데이터 추가 햇을 때 HASH 파티션 성능 체크 ,  I/O 관련 파티션 처리 통계  
SHOW SESSION STATUS LIKE  'HANDLER%';   
  
EXPLAIN SELECT * FROM t3 PARTITION (p0);
EXPLAIN SELECT * FROM t3 PARTITION (p1);
EXPLAIN SELECT * FROM t3 PARTITION (p2);
EXPLAIN SELECT * FROM t3 PARTITION (p3); 
  
-- 11-4) 파티션별 데이터 쿼리  
EXPLAIN SELECT * FROM T3  PARTITION (p0) WHERE YEAR_COL  = 1920;  
  
  
SELECT  * FROM  T3 LIMIT 3;

-- 11-5) 데이터가 존재하는 파티션을 확인하자.  
SELECT  *
FROM T3  PARTITION (p0) WHERE YEAR_COL  = 1920
UNION ALL
SELECT  *
FROM T3  PARTITION (p1) WHERE YEAR_COL  = 1920
UNION ALL
SELECT  *
FROM T3  PARTITION (p2) WHERE YEAR_COL  = 1920
UNION ALL
SELECT  *
FROM T3  PARTITION (p3) WHERE YEAR_COL  = 1920;


  
-- 12. Key Partition : MYSQL이 해시함수를 이용해서 해시값을 계산  
CREATE TABLE t4 (
    id INT,
    year_col INT
)
PARTITION BY KEY (year_col) 
PARTITIONS 4;

SELECT PARTITION_NAME , TABLE_ROWS  
FROM information_schema.PARTITIONS 
WHERE TABLE_NAME = 'T4' AND TABLE_SCHEMA = 'MY_EMP';


-- 12-1 데이터 추가 해보자.  
INSERT INTO T4 VALUES (1, 1990); 
INSERT INTO T4 VALUES (2, 1993); 
INSERT INTO T4 VALUES (3, 1996); 
INSERT INTO T4 VALUES (4, 2000); 
INSERT INTO T4 VALUES (5, 2005);  
INSERT INTO T4 VALUES (5, 2005);  

-- 12-2 데이터 추가된 row를  어떤 파티션에서 포함하고 있는지 확인  
SELECT PARTITION_NAME , TABLE_ROWS  
FROM information_schema.PARTITIONS 
WHERE TABLE_NAME = 'T4' AND TABLE_SCHEMA = 'MY_EMP';

-- 12-3 데이터를 추출하자.  
EXPLAIN SELECT * FROM t4 PARTITION (p1);  -- ROWS   6
EXPLAIN SELECT * FROM t4 PARTITION (p0); -- rows 1  확인   -> 최소 1개정도는 있을 거라는 예상통계
EXPLAIN SELECT * FROM t4 PARTITION (p2); -- rows 1  확인  
EXPLAIN SELECT * FROM t4 PARTITION (p3); -- rows 1  확인  
SELECT * FROM t4 PARTITION (p0);

select count(*) from t4;




