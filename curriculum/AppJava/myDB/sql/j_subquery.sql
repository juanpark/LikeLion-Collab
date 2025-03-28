/*
서브쿼리의 특징  15.2.15 Subqueries

1) 서브쿼리는 내부 쿼리(Subqueries)와 외부 쿼리(Main query)로 구성된다. 
	
2) 서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서 WHERE, HAVING, FROM, SELECT절 등 
            위치에 사용
           - WHERE	조건절로 사용	WHERE SAL > (SELECT ...)
           -SELECT	출력 컬럼으로 사용	SELECT ENAME, (SELECT COUNT(*) ...) AS CNT
           - FROM	임시 테이블로 사용	FROM (SELECT ... ) AS TEMP
            

3) 단일 행 또는 다중 행 결과를 반환할 수 있고, 사용되는 연산자가 달라진다.
     - 단일 행     :  서브쿼리 결과가 1개의 행만 리턴
                       연산자: =, >, <, >=, <=, != 등 일반 비교 연산자
	 - 다중행    : 서브쿼리 결과가 여러 개의 행을 리턴
                연산자: IN, NOT IN, ANY, ALL, EXISTS, NOT EXISTS 등
                
    - 서브쿼리 연산자  
        IN	:서브쿼리 결과 목록 중 포함된 값이면 참
		NOT IN	:서브쿼리 결과 목록 중 포함되지 않으면 참
		> ANY	:서브쿼리 결과 중 하나라도 초과하면 참
		< ALL	:서브쿼리 결과 모두보다 작으면 참
		EXISTS	:서브쿼리 결과가 존재하면 참
		NOT EXISTS:	서브쿼리 결과가 없으면 참

4) 일반적으로 서브쿼리는 주 쿼리의 실행에 의존적이며, 외부 쿼리의 컬럼을 참조할 수 있다.

5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다.

6) Correlated subqueries: 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
   서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다.

7)서브쿼리 내에서 LIMIT 절의 사용이 제한될 수 있다.
*/

USE MY_EMP;
SELECT * FROM EMP;

-- 단일 행     :  서브쿼리 결과가 1개의 행만 리턴
-- 연산자: =, >, <, >=, <=, != 등 일반 비교 연산자
-- Q1. JONES의 월급보다 / 더 많은 월급을 받는 사원의 이름과 봉급을 출력하시오.
-- JONES 월급
SELECT SAL
FROM EMP
WHERE ENAME = 'JONES'; -- 2975

-- 더 많은 월급을 받는 사원의 이름과 봉급
SELECT ENAME, SAL
FROM EMP
WHERE SAL > 2975;

-- 쿼리 중첩 = 결합, 단일
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (	SELECT SAL
				FROM EMP
				WHERE ENAME = 'JONES');

-- 다중행 서브쿼리    : 서브쿼리 결과가 여러 개의 행을 리턴
-- 연산자: IN, NOT IN, ANY, ALL, EXISTS, NOT EXISTS 등
-- Q2. 직업이 'SALESMAN'인 사원과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.
SELECT ENAME, SAL
FROM EMP
WHERE SAL IN ( 	SELECT SAL
				FROM EMP
				WHERE JOB = 'SALESMAN');
                
SELECT ENAME, SAL
FROM EMP
WHERE JOB = 'SALESMAN';

-- Q3. 부서번호가 10번인 사원들과 같은 월급을 받는 사원의 이름과 월급을 출력하시오.
SELECT ENAME, SAL
FROM EMP
WHERE SAL IN ( 	SELECT SAL
				FROM EMP
				WHERE DEPTNO = 10);

-- Q4. 직업이 'CLERK'인 사원과 같은 부서에서 근무하는 사원의 이름, 월급, 부서번호를 출력하시오.
SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE DEPTNO IN (	SELECT DEPTNO
					FROM EMP
                    WHERE JOB = 'CLERK');


-- Q5. 'CHICAGO'에서 근무하는 사원들과 같은 부서에서 근무하는 사원의 이름과 월급을 출력하시오.
SELECT ENAME, SAL
FROM EMP
WHERE DEPTNO IN (	SELECT DEPTNO
					FROM DEPT
					WHERE LOC = 'CHICAGO');
                    
-- Q5-1. 'CHICAGO'에서 근무하는 사원들과 같은 부서에서 근무하는 사원의 이름과 월급을 출력하시오.
-- CNT를 출력 해보자. -> 결과는 행마다 CNT를 반복적으로 계산후 출력
-- 해결하고자 한다면 JOIN + GROUP BY로 리팩토링을 할 수 있다.
SELECT ENAME, SAL, (SELECT COUNT(*) 
					FROM EMP 
                    WHERE DEPTNO IN (SELECT DEPTNO 
									FROM DEPT 
                                    WHERE LOC = 'CHICAGO'
                                    )) AS CNT
FROM EMP
WHERE DEPTNO IN (	SELECT DEPTNO
					FROM DEPT
					WHERE LOC = 'CHICAGO'
				);