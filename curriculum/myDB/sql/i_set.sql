USE My_Emp;

-- Q1. emp 테이블과 dept 테이블의 부서번호를 합쳐 중복 없이 출력하자. (UNION 사용 예제)
-- SELECT deptno FROM emp;
-- SELECT deptno FROM dept;
SELECT deptno FROM emp
UNION
SELECT deptno FROM dept;

-- Q2. emp 테이블과 dept 테이블의 부서번호를 합쳐 중복 포함하여 출력하자. (UNION ALL 사용 예제)

SELECT deptno FROM emp
UNION ALL
SELECT deptno FROM dept;

-- Q3. emp 테이블과 dept 테이블에서 공통된 부서번호를 출력하자. (INTERSECT 유사 구현: INNER JOIN)

-- MySQL은 INTERSECT를 지원하지 않으므로, INNER JOIN 또는 USING을 사용해 교집합 구현
SELECT e.deptno
FROM emp e
INNER JOIN dept d ON e.deptno = d.deptno;

-- 또는
SELECT deptno
FROM emp  
JOIN dept USING(deptno); 

-- Q4. 사원이 존재하지 않는 부서번호를 출력하자. (MINUS 유사 구현: LEFT JOIN + IS NULL)

-- MySQL은 MINUS를 지원하지 않으므로, LEFT JOIN과 NULL 조건으로 차집합 구현
SELECT d.deptno
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno
WHERE e.deptno IS NULL;

-- Q5. 데이터 유형 불일치 해결 
-- 예제 1: 변환 함수(CAST)를 사용하여 UNION 연산을 수행하자.
-- hiredate와 loc 타입이 서로 다르므로 CAST로 일치시켜야 한다.
SELECT deptno, CAST(NULL AS CHAR) AS loc, hiredate
FROM emp
UNION
SELECT deptno, loc, CAST(NULL AS DATE)
FROM dept;

-- Q6. 데이터 유형 불일치 해결 
-- 예제 2: NULL을 활용하여 데이터 형식을 맞추자.
-- emp에서는 loc 컬럼에 NULL, dept에서는 hiredate에 NULL을 넣어 구조를 맞춤
SELECT deptno, NULL AS loc, hiredate
FROM emp
UNION
SELECT deptno, loc, NULL
FROM dept;

-- Q7. 데이터 유형 불일치 해결 
-- 예제 3: 상수를 활용하여 UNION 구조를 맞추자.

-- emp 테이블에는 empno, sal, comm / dept 테이블에는 deptno, sal과 comm을 0으로 지정
SELECT empno, sal, comm
FROM emp
UNION
SELECT deptno, 0 AS sal, 0 AS comm
FROM dept;


