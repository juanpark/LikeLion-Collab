USE WORLD;
-- Q1)  create  like로  테이블을 복사해서 구조를 확인 해보자.  
CREATE TABLE exam_my LIKE city; -- 구조만 복사 : LIKE CITY
DESC exam_my;
SELECT COUNT(*)  FROM  exam_my;
SELECT * FROM EXAM_MY;

-- Q2) 테이블 파티셔닝 준비: city_partitioned 테이블 생성 및 기본 키 변경
-- Q2-1) city 테이블의 모든 컬럼과 데이터를 포함하는 새로운 테이블 city_partitioned를 생성하시오.
CREATE TABLE city_partitioned AS SELECT * FROM city; 	-- 데이터도 복사 : AS SELECT * FROM CITY
SELECT COUNT(*)  FROM  city_partitioned;				-- 단 PK, 인덱스, 자동증가 세팅, 외부키 등은 복사 안함.
SELECT * FROM city_partitioned;

-- Q2-2) 생성된 city_partitioned 테이블의 구조를 DESCRIBE 명령어를 사용하여 확인하시오.
DESC city_partitioned;									

-- Q2-3) city_partitioned 테이블에 설정되어 있는 기본 키(PRIMARY KEY)를 삭제하시오.
--   테이블 파티셔닝을 위해서는 기본 키를 변경해야 할 수 있으며, 파티셔닝 키가 기본 키의 일부가 되는 것이 일반적이다
ALTER TABLE city_partitioned
DROP PRIMARY KEY;
-- Error Code: 1091. Can't DROP 'PRIMARY'; check that column/key exists

-- Q2-4) city_partitioned 테이블에 (ID, Population) 컬럼을 묶어 새로운 복합 기본 키(PRIMARY KEY)를 추가하시오.
--   파티셔닝을 수행할 때, 분할 기준이 되는 컬럼(여기서는 Population)이
--   고유성을 보장하기 위해 기본 키의 일부가 되는 것이 일반적인 이유이다.
--   ID 컬럼은 기존부터 고유성을 가지는 기본 키였으므로 함께 묶어 복합 키로 만든다.
-- 	ID → 기존에 기본 키로 사용되던 컬럼 (고유한 값)
-- 	Population → 파티셔닝 기준이 될 컬럼 → 기본 키의 일부로 포함되어야 파티셔닝이 가능
-- 	(MySQL의 규칙 중 하나: 파티셔닝 키는 반드시 PRIMARY KEY 또는 UNIQUE KEY의 일부여야 함)
ALTER TABLE city_partitioned
ADD PRIMARY KEY (ID, POPULATION);

DESC city_partitioned;	

-- Q3)  테이블 복사 방식 비교
-- Q3-1) CREATE TABLE LIKE 구문을 사용하여 city 테이블과 동일한 구조를 가지는 새로운 테이블 city_like를 생성하시오.
-- (제약 조건은 복사 O, 데이터는 복사 X) 생성 후 테이블 구조를 확인하시오.
CREATE TABLE city_like LIKE city;
DESC city_like;

-- Q3-2) CREATE TABLE AS SELECT 구문을 사용하여 city 테이블과 동일한 구조와 데이터를 가지는 새로운 테이블 city_as를 생성하시오. (제약 조건은 복사 X, 데이터는 복사 O) 생성 후 테이블 구조를 확인하시오.
CREATE TABLE city_as AS SELECT * FROM city;

DESC city;
DESC city_as;

-- Q4)  city_partitioned 테이블에 Population 컬럼을 기준으로 범위 파티션을 생성하시오.
--   - p0 파티션: Population이 1,000,000 미만인 행
--   - p1 파티션: Population이 1,000,000 이상 2,000,000 미만인 행
--   - p2 파티션: Population이 2,000,000 이상인 행
DROP TABLE IF EXISTS city_partitioned;
DESC city;

-- GPT가 계속 새로 MySQL은 파티셔닝을 위해 테이블을 새로 만들어된다고 노래 해서 만들려다가
-- CREATE TABLE city_partitioned (
-- 	ID int,
--     Name char(35),
--     CountryCode char(3),
--     District char(20),
--     Population int
-- )

-- 혹시나 해서 아래처럼 해보니 된다...
-- 새로 테이블 만들 필요 없이 기존 테이블에 Alter Table ... Partition by ... 가능
-- https://dev.mysql.com/doc/refman/8.4/en/alter-table-partition-operations.html
ALTER TABLE city_partitioned
PARTITION BY RANGE (Population) (
    PARTITION p0 VALUES LESS THAN (1000000),
    PARTITION p1 VALUES LESS THAN (2000000),
    PARTITION p2 VALUES LESS THAN MAXVALUE
);


-- Q5)  파티셔닝된 테이블 (city_partitioned)의 파티션 정보를 information_schema.PARTITIONS 테이블을 사용하여 조회하시오.
SELECT TABLE_SCHEMA, TABLE_NAME
FROM information_schema.tables
WHERE TABLE_NAME = 'city_partitioned';
            
SELECT * FROM information_schema.PARTITIONS 
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world'; 

SELECT * FROM city_partitioned PARTITION (p0);
SELECT * FROM city_partitioned PARTITION (p1);
SELECT * FROM city_partitioned PARTITION (p2);

-- Q6) city 테이블의 모든 행을 city_partitioned 테이블로 복사하시오. 복사 후 information_schema.PARTITIONS 테이블을 조회하여 각 파티션별 table_rows와 avg_row_length를 확인하시오.
SELECT * FROM city;
SELECT * FROM city_partitioned;

INSERT INTO city_partitioned SELECT * FROM city;
-- Error Code: 1062. Duplicate entry '1-1780000' for key 'city_partitioned.PRIMARY'

SELECT * 
FROM city
WHERE (ID, Population) NOT IN (
  SELECT ID, Population FROM city_partitioned
);
-- 완전 동일함
-- 3-2 파티셔닝을 빈 테이블에서 진행하는 것을 생각?
-- 아니면 여기에서 기존 데이터를 truncate하고 다시 입력 연습?
-- 아니면 내가 생각 못한 다른 이유?

SELECT table_rows, avg_row_length FROM information_schema.PARTITIONS 
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world'; 


-- Q7)  쿼리 성능 비교해 보자.
-- Q7-1) 파티션 적용 전 (city 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.
SELECT * FROM city WHERE Population < 1000000;
-- 0.0072 sec / 0.000013 sec
-- 0.0021 sec / 0.0018 sec



-- Q7-2) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 성능을 분석하시오.
EXPLAIN ANALYZE SELECT * FROM city WHERE Population < 1000000;
-- # EXPLAIN
-- '-> Filter: (city.Population < 1000000)  (cost=410 rows=1345) (actual time=0.401..2.74 rows=3841 loops=1)\n    
-- -> Table scan on city  (cost=410 rows=4035) (actual time=0.396..2.37 rows=4079 loops=1)\n'

-- Q7-3) 파티션 적용 후 (city_partitioned 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.
SELECT * FROM city_partitioned WHERE Population < 1000000;
-- 0.0011 sec / 0.0015 sec
-- 0.0011 sec / 0.0015 sec


-- Q7-4) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 파티션 적용 전과의 성능 차이를 분석하시오.
EXPLAIN ANALYZE SELECT * FROM city_partitioned WHERE Population < 1000000;
-- # EXPLAIN
-- '-> Filter: (city_partitioned.Population < 1000000)  (cost=390 rows=1280) (actual time=0.37..2.78 rows=3841 loops=1)\n    
-- -> Table scan on city_partitioned  (cost=390 rows=3841) (actual time=0.368..2.41 rows=3841 loops=1)\n'


-- Q8)  city_partitioned 테이블의 파티션 정보를 다시 한번 확인하시오.
SELECT PARTITION_NAME, TABLE_ROWS, AVG_ROW_LENGTH
FROM information_schema.PARTITIONS
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';

SELECT *
FROM information_schema.PARTITIONS
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';


-- Q9)  p0 파티션 (POPULATION < 1,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT * FROM city_partitioned;
SELECT Name, Population FROM city_partitioned PARTITION (p0);

-- Q10) p1 파티션 (1,000,000 <= POPULATION < 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT Name, Population FROM city_partitioned PARTITION (p1);

-- Q11) p2 파티션 (POPULATION >= 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT Name, Population FROM city_partitioned PARTITION (p2);

-- Q12) 각 파티션 (p0, p1, p2) 별로 인구가 가장 많은 도시의 이름과 인구를 각각 조회하시오.
SELECT Name, Population
FROM city_partitioned PARTITION (p0)
ORDER BY Population DESC
LIMIT 1;

SELECT Name, Population
FROM city_partitioned PARTITION (p1)
ORDER BY Population DESC
LIMIT 1;

SELECT Name, Population
FROM city_partitioned PARTITION (p2)
ORDER BY Population DESC
LIMIT 1;


-- Q13)  각 파티션 별로 포함된 도시의 총 개수를 조회하시오. (PARTITION 절 활용)
SELECT 'P0' AS 'PARTITION', COUNT(*) AS CITY_CNT
FROM city_partitioned PARTITION (p0)
UNION ALL
SELECT 'P1' AS 'PARTITION', COUNT(*) AS CITY_CNT
FROM city_partitioned PARTITION (p1)
UNION ALL
SELECT 'P2' AS 'PARTITION', COUNT(*) AS CITY_CNT
FROM city_partitioned PARTITION (p2);

-- Q14)  파티션 범위를 기준으로 각 그룹별 최대 인구를 가진 도시의 이름과 해당 파티션 이름을 함께 조회하시오. (Window 함수 활용)
SELECT 'p0' AS 'PARTITION', NAME
FROM ( 
	SELECT 
		NAME, 
		RANK() OVER (ORDER BY Population DESC) AS r
	FROM city_partitioned PARTITION(p0)
    LIMIT 1
    ) AS ranked
WHERE r = 1
UNION ALL
SELECT 'p1' AS 'PARTITION', NAME
FROM ( 
	SELECT 
		NAME, 
		RANK() OVER (ORDER BY Population DESC) AS r
	FROM city_partitioned PARTITION(p1)
    LIMIT 1
    ) AS ranked
WHERE r = 1
UNION ALL
SELECT 'p2' AS 'PARTITION', NAME
FROM ( 
	SELECT 
		NAME, 
		RANK() OVER (ORDER BY Population DESC) AS r
	FROM city_partitioned PARTITION(p2)
    LIMIT 1
    ) AS ranked
WHERE r = 1;

-- Q15)  city 테이블에서 p1 파티션을 삭제하시오. (주의: 해당 파티션의 모든 데이터가 제거됩니다.)
ALTER TABLE city_partitioned DROP PARTITION p1;

SELECT PARTITION_NAME, TABLE_ROWS, AVG_ROW_LENGTH
FROM information_schema.PARTITIONS
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';

SELECT *
FROM information_schema.PARTITIONS
WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';

-- Q16)  city 테이블의 파티셔닝을 제거하고 기존의 모든 데이터를 유지하는 테이블로 변환하시오.
-- 파티셔닝된 테이블은 city_partitioned 테이블이었는데, 왜 city 테이블? 
-- 그리고 위에서 이미 p1 파티션을 삭제했는데, 어떻게 기존의 모든 데이터를 유지하라는건지? 

-- Q17) 파티셔닝이 제거된 city 테이블의 정보를 확인하시오.
-- 16번이 해결되어야 해결 가능한 문제