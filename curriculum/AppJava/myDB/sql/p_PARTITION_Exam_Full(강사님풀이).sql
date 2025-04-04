##########################################################################
USE WORLD;
-- Q1)  create  like로  테이블을 복사해서 구조를 확인 해보자.  
CREATE TABLE exam_my LIKE city;
DESC exam_my;
SELECT COUNT(*)  FROM  exam_my;


-- Q2) 다음 단계별로 테이블 파티셔닝 준비: city_partitioned 테이블 생성 및 기본 키 변경하시요
-- Q2-1) city 테이블의 모든 컬럼과 데이터를 포함하는 새로운 테이블 city_partitioned를 생성하시오.
CREATE TABLE city_partitioned
AS
SELECT * FROM city;

-- Q2-2) 생성된 city_partitioned 테이블의 구조를 DESCRIBE 명령어를 사용하여 확인하시오.
DESC city_partitioned;

-- Q2-3) city_partitioned 테이블에 설정되어 있는 기본 키(PRIMARY KEY)를 삭제하시오.
--     테이블 파티셔닝을 위해서는 기본 키를 변경해야 할 수 있으며, 파티셔닝 키가 기본 키의 일부가 되는 것이 일반적이다
ALTER TABLE city_partitioned
DROP PRIMARY KEY;

-- Q2-4) city_partitioned 테이블에 (ID, Population) 컬럼을 묶어 새로운 복합 기본 키(PRIMARY KEY)를 추가하시오.
--     파티셔닝을 수행할 때, 분할 기준이 되는 컬럼(여기서는 Population)이
--     고유성을 보장하기 위해 기본 키의 일부가 되는 것이 일반적인 이유이다. 
--     ID 컬럼은 기존부터 고유성을 가지는 기본 키였으므로 함께 묶어 복합 키로 만든다. 
ALTER TABLE city_partitioned
ADD PRIMARY KEY(ID, Population);

-- Q3)  테이블 복사 방식 비교
-- Q3-1) CREATE TABLE LIKE 구문을 사용하여 city 테이블과 동일한 구조를 가지는 새로운 테이블 city_like를 생성하시오.
-- (제약 조건은 복사 O, 데이터는 복사 X) 생성 후 테이블 구조를 확인하시오.
DROP TABLE IF EXISTS city_like;
CREATE TABLE city_like LIKE city;
DESC city_like;

-- Q3-2) CREATE TABLE AS SELECT 구문을 사용하여 city 테이블과 동일한 구조와 데이터를 가지는 새로운 테이블 city_as를 생성하시오. (제약 조건은 복사 X, 데이터는 복사 O) 생성 후 테이블 구조를 확인하시오.
DROP TABLE IF EXISTS city_as;
CREATE TABLE city_as AS SELECT * FROM city;
DESC city_as;
SELECT COUNT(*) FROM city_as;

DROP TABLE city_partitioned;
CREATE TABLE city_partitioned LIKE city;#추가된 제약조건도 city_partitioned 설정되는지 확인
DESC  city_partitioned;


-- Q4)  city_partitioned 테이블에 Population 컬럼을 기준으로 범위 파티션을 생성하시오.
-- #   - p0 파티션: Population이 1,000,000 미만인 행
-- #   - p1 파티션: Population이 1,000,000 이상 2,000,000 미만인 행
-- #   - p2 파티션: Population이 2,000,000 이상인 행
ALTER TABLE city_partitioned
    PARTITION BY RANGE(Population) (
    PARTITION p0 VALUES LESS THAN (1000000),
    PARTITION p1 VALUES LESS THAN (2000000),
    PARTITION p2 VALUES LESS THAN MAXVALUE
);


-- Q5)  파티셔닝된 테이블 (city_partitioned)의 파티션 정보를 information_schema.PARTITIONS 테이블을 사용하여 조회하시오.
SELECT * FROM information_schema.PARTITIONS
                WHERE TABLE_NAME = 'city_partitioned'
                AND TABLE_SCHEMA = 'world';

SELECT COUNT(*) FROM  city;
SELECT COUNT(*) FROM  city_partitioned;

-- Q6) city 테이블의 모든 행을 city_partitioned 테이블로 복사하시오. 복사 후 information_schema.PARTITIONS 테이블을 조회하여 각 파티션별 table_rows와 avg_row_length를 확인하시오.
INSERT INTO city_partitioned
SELECT * FROM city;

SELECT * FROM information_schema.PARTITIONS
                WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';

-- Q7)  쿼리 성능 비교해 보자. 
-- Q7-1) 파티션 적용 전 (city 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.
SELECT SQL_NO_CACHE * FROM city WHERE Population < 1000000;

-- Q7-2) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 성능을 분석하시오.
EXPLAIN SELECT  * FROM city WHERE Population < 1000000;

-- Q7-3) 파티션 적용 후 (city_partitioned 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.
SELECT SQL_NO_CACHE * FROM city_partitioned WHERE Population < 1000000;

-- Q7-4) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 파티션 적용 전과의 성능 차이를 분석하시오.
EXPLAIN SELECT  * FROM city_partitioned WHERE Population < 1000000;

-- Q8)  city_partitioned 테이블의 파티션 정보를 다시 한번 확인하시오.
SELECT * FROM information_schema.PARTITIONS
                WHERE TABLE_NAME = 'city_partitioned' AND TABLE_SCHEMA = 'world';

DROP TABLE city;
RENAME TABLE city_partitioned TO city;


####테이블 파티션하고 쿼리 성능 최적화
### 원본 테이블 복하 -> 파티션 적용 -> 데이트 분산 -> 파티션데이터 확인  -> 쿼리 성능 비교
###   -> 파티션테이블을 원본 테이블로 대체

################# city 테이블 파티션 데이터 확인
-- Q9)  p0 파티션 (POPULATION < 1,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT NAME, POPULATION
FROM CITY PARTITION (p0);

-- Q10) p1 파티션 (1,000,000 <= POPULATION < 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT NAME, POPULATION
FROM CITY PARTITION (p1);

-- Q11) p2 파티션 (POPULATION >= 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.
SELECT NAME, POPULATION
FROM CITY PARTITION (p2);

-- Q12) 각 파티션 (p0, p1, p2) 별로 인구가 가장 많은 도시의 이름과 인구를 각각 조회하시오.
SELECT NAME, POPULATION
FROM CITY PARTITION (p0)
ORDER BY Population DESC
LIMIT 1;

SELECT NAME, POPULATION
FROM CITY PARTITION (p1)
ORDER BY Population DESC
LIMIT 1;

SELECT NAME, POPULATION
FROM CITY PARTITION (p2)
ORDER BY Population DESC
LIMIT 1;


-- Q13)  각 파티션 별로 포함된 도시의 총 개수를 조회하시오. (PARTITION 절 활용)
SELECT "p0" AS PARTITION_NAME, COUNT(*) AS CITY_COUNT FROM CITY PARTITION (p0)
UNION ALL
SELECT "p1" AS PARTITION_NAME, COUNT(*) AS CITY_COUNT FROM CITY PARTITION (p1)
UNION ALL
SELECT "p2" AS PARTITION_NAME, COUNT(*) AS CITY_COUNT FROM CITY PARTITION (p2);

-- Q14)  파티션 범위를 기준으로 각 그룹별 최대 인구를 가진 도시의 이름과 해당 파티션 이름을 함께 조회하시오. (Window 함수 활용)
SELECT PartitionName, Name, MaxPopulation
FROM (
    SELECT
        CASE
            WHEN Population < 1000000 THEN 'p0'
            WHEN Population >= 1000000 AND Population < 2000000 THEN 'p1'
            WHEN Population >= 2000000 THEN 'p2'
        END AS PartitionName,
        Name,
        Population AS MaxPopulation,
        RANK() OVER (PARTITION BY
            CASE
                WHEN Population < 1000000 THEN 'p0'
                WHEN Population >= 1000000 AND Population < 2000000 THEN 'p1'
                WHEN Population >= 2000000 THEN 'p2'
            END
            ORDER BY Population DESC
        ) AS PopulationRank
    FROM city
) AS PartitionedData
WHERE PopulationRank = 1;

-- Q15)  city 테이블에서 p1 파티션을 삭제하시오. (주의: 해당 파티션의 모든 데이터가 제거됩니다.)
 ALTER TABLE city DROP PARTITION p1;

-- Q16)  city 테이블의 파티셔닝을 제거하고 기존의 모든 데이터를 유지하는 테이블로 변환하시오.
ALTER TABLE city
REMOVE PARTITIONING;

-- Q17) 파티셔닝이 제거된 city 테이블의 정보를 확인하시오.
SELECT * FROM information_schema.PARTITIONS
                WHERE TABLE_NAME = 'city' AND TABLE_SCHEMA = 'world';
                