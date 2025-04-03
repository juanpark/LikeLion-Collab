USE WORLD;
-- Q1)  create  like로  테이블을 복사해서 구조를 확인 해보자.  
CREATE TABLE exam_my LIKE city;
DESC exam_my;
SELECT COUNT(*)  FROM  exam_my;

-- Q2) 테이블 파티셔닝 준비: city_partitioned 테이블 생성 및 기본 키 변경
-- Q2-1) city 테이블의 모든 컬럼과 데이터를 포함하는 새로운 테이블 city_partitioned를 생성하시오.

-- Q2-2) 생성된 city_partitioned 테이블의 구조를 DESCRIBE 명령어를 사용하여 확인하시오.

-- Q2-3) city_partitioned 테이블에 설정되어 있는 기본 키(PRIMARY KEY)를 삭제하시오.
--   테이블 파티셔닝을 위해서는 기본 키를 변경해야 할 수 있으며, 파티셔닝 키가 기본 키의 일부가 되는 것이 일반적이다

-- Q2-4) city_partitioned 테이블에 (ID, Population) 컬럼을 묶어 새로운 복합 기본 키(PRIMARY KEY)를 추가하시오.
--   파티셔닝을 수행할 때, 분할 기준이 되는 컬럼(여기서는 Population)이
--   고유성을 보장하기 위해 기본 키의 일부가 되는 것이 일반적인 이유이다.
--   ID 컬럼은 기존부터 고유성을 가지는 기본 키였으므로 함께 묶어 복합 키로 만든다.

-- Q3)  테이블 복사 방식 비교
-- Q3-1) CREATE TABLE LIKE 구문을 사용하여 city 테이블과 동일한 구조를 가지는 새로운 테이블 city_like를 생성하시오.
-- (제약 조건은 복사 O, 데이터는 복사 X) 생성 후 테이블 구조를 확인하시오.

-- Q3-2) CREATE TABLE AS SELECT 구문을 사용하여 city 테이블과 동일한 구조와 데이터를 가지는 새로운 테이블 city_as를 생성하시오. (제약 조건은 복사 X, 데이터는 복사 O) 생성 후 테이블 구조를 확인하시오.

-- Q4)  city_partitioned 테이블에 Population 컬럼을 기준으로 범위 파티션을 생성하시오.
--   - p0 파티션: Population이 1,000,000 미만인 행
--   - p1 파티션: Population이 1,000,000 이상 2,000,000 미만인 행
--   - p2 파티션: Population이 2,000,000 이상인 행

-- Q5)  파티셔닝된 테이블 (city_partitioned)의 파티션 정보를 information_schema.PARTITIONS 테이블을 사용하여 조회하시오.

-- Q6) city 테이블의 모든 행을 city_partitioned 테이블로 복사하시오. 복사 후 information_schema.PARTITIONS 테이블을 조회하여 각 파티션별 table_rows와 avg_row_length를 확인하시오.

-- Q7)  쿼리 성능 비교해 보자.
-- Q7-1) 파티션 적용 전 (city 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.

-- Q7-2) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 성능을 분석하시오.

-- Q7-3) 파티션 적용 후 (city_partitioned 테이블) Population이 1,000,000 미만인 도시를 조회하는 쿼리를 SQL 캐시를 사용하지 않고 실행하여 실행 시간을 측정하시오.

-- Q7-4) 위 쿼리의 실행 계획을 EXPLAIN 명령어를 사용하여 확인하고 파티션 적용 전과의 성능 차이를 분석하시오.

-- Q8)  city_partitioned 테이블의 파티션 정보를 다시 한번 확인하시오.

-- Q9)  p0 파티션 (POPULATION < 1,000,000) 에 속한 도시의 이름과 인구를 조회하시오.

-- Q10) p1 파티션 (1,000,000 <= POPULATION < 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.

-- Q11) p2 파티션 (POPULATION >= 2,000,000) 에 속한 도시의 이름과 인구를 조회하시오.

-- Q12) 각 파티션 (p0, p1, p2) 별로 인구가 가장 많은 도시의 이름과 인구를 각각 조회하시오.

-- Q13)  각 파티션 별로 포함된 도시의 총 개수를 조회하시오. (PARTITION 절 활용)

-- Q14)  파티션 범위를 기준으로 각 그룹별 최대 인구를 가진 도시의 이름과 해당 파티션 이름을 함께 조회하시오. (Window 함수 활용)

-- Q15)  city 테이블에서 p1 파티션을 삭제하시오. (주의: 해당 파티션의 모든 데이터가 제거됩니다.)

-- Q16)  city 테이블의 파티셔닝을 제거하고 기존의 모든 데이터를 유지하는 테이블로 변환하시오.

-- Q17) 파티셔닝이 제거된 city 테이블의 정보를 확인하시오.