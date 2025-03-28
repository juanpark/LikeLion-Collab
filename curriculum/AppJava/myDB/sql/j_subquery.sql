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
                
-- Q6. 부하직원이 있는 사원의 사원 번호와 이름을 출력하자. -> 자기자신(EMPNO)이 관리자(MGR)이면 된다.
SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO IN (SELECT MGR
				FROM EMP);
                
SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO IN (SELECT MGR 
				FROM EMP 
                WHERE MGR IS NOT NULL);

SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO = ANY (	SELECT IFNULL(MGR,0)
					FROM EMP); 	-- DATA OR DATA OR .... NULL) = ANY

/*
  ANY ( DATA OR DATA OR ....NULL) 
 = ANY      하나라도 만족하는 값이 있으면 결과를 리턴하며 IN과 동일함
ANY      값들 중 최소값 보다 크면 결과를 리턴
 >= ANY  값들 중 최소값 보다 크거나 같으면 결과를 리턴
 < ANY      값들 중 최대값 보다 작으면 결과를 리턴
 <= ANY  값들 중 최대값 보다 작거나 같으면 결과를 리턴
 <> ANY  모든 값들 중 다른 값만 리턴, 값이 하나일 때만 가능함

ALL( DATA  AND DATA AND ....NULL) 
ALL      값들 중 최대값 보다 크면 결과를 리턴
 >= ALL  값들 중 최대값 보다 크거나 같으면 결과를 리턴
 < ALL      값들 중 최소값 보다 작으면 결과를 리턴
 <= ALL  값들 중 최소값 보다 작거나 같으면 결과를 리턴
 = ALL      모든 값들과 같아야 결과를 리턴, 값이 하나일 때만 가능함
 <> ALL  모든 값들과 다르면 결과를 리턴 
 */
 
 -- Q7. 부하직원이 없는 사원의 사원번호와 이름을 출력하자. -> 자기자신이 관리자이면 된다의 반대
 SELECT EMPNO, ENAME
 FROM EMP
 WHERE EMPNO NOT IN (	SELECT IFNULL(MGR,0)
						FROM EMP);  -- (DATA AND DATA AND ,,, NULL) != ALL
      
 SELECT EMPNO, ENAME
 FROM EMP
 WHERE EMPNO NOT IN (	SELECT IFNULL
						FROM EMP
                        WHERE MGR IS NOT NULL);      
      
SELECT EMPNO, ENAME
FROM EMP
WHERE EMPNO != ALL (	SELECT IFNULL(MGR,0)
						FROM EMP);
                        
-- Q8. KING에게 보고하는 사원의 이름과 월급을 출력하자.
-- 직속상관(MGR)이 KING인 사원의 이름과 월급
-- KING의 사원번호(EMPNO)가 MGR(상사번호)인 사원들을 찾아서 리턴
SELECT ENAME, SAL
FROM EMP
WHERE MGR = (	SELECT EMPNO
				FROM EMP
                WHERE ENAME = 'KING');

-- Q9. 20번 부서의 사원 중 가장 많은 월급을 받는 사원들 보다 더 많은 월급의 받는 사원의 이름과 월급을 출력하자
-- 더 많은 월급을 받는
-- 사원의 이름과 월급을 출력하자
-- MAX 사용
SELECT ENAME, SAL
FROM EMP
WHERE SAL > (	SELECT MAX(SAL)
				FROM EMP
				WHERE DEPTNO = 20);
                
SELECT ENAME, SAL,
       (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = 20) AS MAX_SAL_DEPT20
FROM EMP
WHERE SAL > (
    SELECT MAX(SAL)
    FROM EMP
    WHERE DEPTNO = 20
);
			
-- Q9-1. 20번 부서의 사원 중 가장 많은 월급을 받는 사원들 보다 더 많은 월급의 받는 사원의 이름과 월급을 출력하자
-- (ALL, ANY 둘 중 하나 사용하자)
SELECT ENAME, SAL
FROM EMP
WHERE SAL > ALL ( 	-- (DATA AND DATA AND,,, NULL)
	SELECT SAL 
	FROM EMP
	WHERE DEPTNO = 20
);

-- Q10. 20번 부서의 사원 중 가장 적은 월급을 받는 사원들 보다 더 많은 월급의 받는 사원의 이름과 월급을 출력하자
-- (ALL, ANY 둘 중 하나 사용하자. MIN, MAX 사용해서 2개의 쿼리 만들자)
SELECT ENAME,SAL
FROM EMP
WHERE SAL > (
	SELECT MIN(SAL)
    FROM EMP
    WHERE DEPTNO = 20
);

SELECT ENAME, SAL
FROM EMP
WHERE SAL > ANY ( 	-- (DATA OR DATA OR,,, NULL) 
	SELECT SAL 
    FROM EMP
    WHERE DEPTNO = 20
);

-- Q11. 직업이 SALESMAN인 사원 중 가장 많은 월급을 받는 사원보다 더 많은 월급을 받는 사원의 이름과 월급을 출력하자.
-- (MIN, MAX) 사용하지 말자. SALESMAN이 리턴하는 값들보다 크다.
SELECT ENAME, SAL
FROM EMP
WHERE SAL > ALL (
	SELECT SAL
    FROM EMP
    WHERE JOB = 'SALESMAN'
);

-- Q12. 직업이 SALESMAN인 사원 중 가장 적은 월급을 받는 사원보다 더 적은 월급을 받는 사원의 이름과 월급을 출력하자.
-- (MIN, MAX) 사용하지 말자.
SELECT ENAME, SAL
FROM EMP
WHERE SAL < ALL (
	SELECT SAL
    FROM EMP
    WHERE JOB = 'SALESMAN'
);

###############################################################

/*
https://dev.mysql.com/doc/refman/8.4/en/with.html#common-table-expressions-recursive
  Recursive Common Table Expressions [계층 구조를 재귀적으로 탐색할 때 사용]   :  재귀적 CTE
  WITH RECURSIVE -> 자기 자신을 반복 호출하는 쿼리 : 계층구조(트리), 반복구조 확인하는 쿼리 
  
  WITH RECURSIVE cte (n) AS
(
  SELECT 1		-- [1] 시작값
  UNION ALL		
  SELECT n + 1 FROM cte WHERE n < 5		-- [2] 다음값을 생성 
)
SELECT * FROM cte;
  */
  
-- Q13. 1 ~ 5까지 CTE를 활용해서 값을 출력 해보자.
  WITH RECURSIVE cte (n) AS
(
  SELECT 1		-- [1] 시작값
  UNION ALL		
  SELECT n + 1 FROM cte WHERE n < 5		-- [2] 다음값을 생성 
)
SELECT * FROM cte;

-- Q14. CTE를 사용해서, MGR 상관부터 말단까지 구조를 탐색해 보자.
WITH RECURSIVE EMP_RES AS
(
	-- [1] 최상위 정보를 출력 해보자.
	SELECT EMPNO, ENAME, MGR, 1 AS LEVEL
    FROM EMP
    WHERE MGR IS NULL
    UNION ALL
    
    -- [2] 각 사원의 (부하직원)을 재귀적으로 출력하자.
    SELECT E.EMPNO, E.ENAME, E.MGR , ET.LEVEL + 1
    FROM EMP E
		JOIN EMP_RES ET ON E.MGR = ET.EMPNO
)
SELECT * 
FROM EMP_RES;

-- Q14-1. 위 내용을 GetEmp_Res()로 프로시로 만들어 호출 해보자. = Static void Method형
CALL 01_GetEmp_Res();

-- 프로시저 내용을 확인하자.
SHOW CREATE PROCEDURE 01_GetEmp_Res;


-- Q15. CTE구구단 중에 3단을 출력해보자.
WITH RECURSIVE GuGuDan AS (
-- [1] 초기값 지정 3 * 1
SELECT 3 AS DAN, 1 AS NUM, 3*1 AS RESULT

UNION ALL
-- [2] 재귀적으로 NUM을 1씩 증가 시키면서 9까지 반복한다.
SELECT DAN, NUM+1, DAN * (NUM + 1)
FROM GuGuDan
WHERE NUM < 9
)
-- [3] 전체 출력
SELECT CONCAT(DAN, " * ", NUM, " = ", RESULT) AS GuGuDan_PRN
FROM GuGuDan;

call 02_GuGuDan();
call 03_GuGuDan(4);
call 03_GuGuDan(5);

-- Q16. CTE를 활용해서 피보나치 수열 계산해보자: 두 숫자를 더해서 다음 숫자를 만드는 수혈
-- 0, 1, 1, 2, 3, 5, 8, 13,,,
-- 첫번째와 두번째 항은 각각 0과 1이고, 그 이후에 각 항은 이전 두항의 합이다.

WITH RECURSIVE Fibonacci_CTE AS (
-- [1] 초기값 (N = 0, FIB = 0, PREV_FIB = 1)
SELECT 0 AS N, 0 AS FIB, 1 AS PREV_FIB
UNION ALL
-- [2] 재귀적으로 피보나치 수열을 계산하자
SELECT N + 1, PREV_FIB AS FIB, FIB + PREV_FIB AS PREV_FIB
FROM Fibonacci_CTE
WHERE N < 10
)
SELECT N AS "항번호", FIB AS "피보나치 수열"
FROM Fibonacci_CTE;
call 04_Fibonacci_CTE();
call 05_Fibonacci_CTE(5);
call 05_Fibonacci_CTE(15);

###########################################################
-- MUTI COLUMN SUBQUERY
-- Q1. 	직업이 'SALESMAN'인 사원과 같은 부서에서 근무하고 (AND)
-- 		같은 월급을 받는 사원들의 이름, 월급, 부서번호를 출력하자.

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE 	DEPTNO IN (
	SELECT DEPTNO
    FROM EMP
    WHERE JOB = 'SALESMAN')
AND
		SAL IN (
	SELECT SAL
    FROM EMP
    WHERE JOB = 'SALESMAN');

/*
# ENAME	SAL	DEPTNO
ALLEN	1600.00	30
WARD	1250.00	30
MARTIN	1250.00	30
TURNER	1500.00	30
*/

SELECT ENAME, SAL, DEPTNO
FROM EMP
WHERE (DEPTNO, SAL) IN (SELECT DEPTNO, SAL
						FROM EMP
						WHERE JOB = 'SALESMAN');

/*                        
2) 서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서 WHERE, HAVING, FROM, SELECT절 등 
            위치에 사용
           - WHERE	조건절로 사용	WHERE SAL > (SELECT ...)
           -SELECT	출력 컬럼으로 사용	SELECT ENAME, (SELECT COUNT(*) ...) AS CNT
           - FROM	임시 테이블로 사용	FROM (SELECT ... ) AS TEMP
           
5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다.
*/