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

-- 2) 더 많은 월급을 받는 사원의 이름과 봉급
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
SELECT * FROM cte;  -- 끝나는 구문

-- Q14) CTE를 사용해서, MG 상관부터 말단직원까지 구조를 탐색
-- 계층형 구조를 표현하고자 할때 level 사용. 계층이 하나씩 들어갈 때마다 level 값이 0부터 하나씩 증가

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



-- 서브 쿼리 사용법 
 -- 2)서브쿼리는 SELECT, INSERT, UPDATE, DELETE 문에서  WHERE, HAVING, FROM, SELECT절 등  위치에 사용
  -- SELECT절  서브 쿼리 사용방법
 /*
WHERE     	:조건 비교용 하위 질의
HAVING     	: 그룹 조건에 대한 비교
FROM     	: 인라인 뷰(하위 결과셋을 테이블처럼)
SELECT    	: 선택된 컬럼 값을 계산 또는 비교용 
*/
 
 -- CASE 1 ) 각 사원의 봉급이  그 사원이 속한  부서의 평균급여보다 얼마나 높은지 출력 해보자. 
 -- 부서평균 급여보다 높은 급여 차이
 SELECT ENAME,  SAL - ( SELECT AVG(SAL)
                      FROM EMP
                      WHERE DEPTNO  = E.DEPTNO)  AS RES
 FROM EMP E;
 
 
-- CASE 2)  사원의 이름과 모든 사원의 봉급의 합을  출력한 결과 
 SELECT ENAME ,  (SELECT  SUM(SAL)   FROM EMP   ) AS "TOTAL SAL"
 FROM EMP;
 
 -- CASE 3) 사원의 이름과 모든 사원의 봉급의 평균을 출력한 결과
 SELECT ENAME ,  (SELECT  AVG(SAL)   FROM EMP   ) AS "AVG SAL"
 FROM EMP;
 
-- CASE 4)  SELECT에서 계산된 'SAL'의 별칭을 WHERE 절에서 사용하고 싶다.  -> 쿼리를 재구성해야 한다.
-- SELECT의 별칭을 WHERE에 사용하려면? -> 별칭은 SELECT 이후에 정의되므로 WHERE 절에서 직접 호출할 수 없다.
-- 해결첵: 서브쿼리 또는 CTE 사용

  -- 4-1) 서브쿼리  재구성
    SELECT *
    FROM (SELECT ENAME, (SELECT  SUM(SAL) FROM EMP) AS MYSAL
          FROM EMP )   AS SUBQUERY 
    WHERE  MYSAL  > 2000 ;

  -- 4-2)  cte 사용
  WITH  CTE AS (
      SELECT ENAME, SAL AS MYSAL
      FROM EMP 
 ) 
 SELECT * 
 FROM CTE
 WHERE MYSAL > 2000 ; 
 
 
-- 5) EXISTS와 NOT EXISTS를 사용하여 특정 조건이 충족되는지 여부만을 판단하는 논리적 테스트를 수행한다. 
 -- EXISTS를 사용해서 부서에 사원이 존재 하는지  확인 후 부서명을 출력 해보자.
 
-- 부서에 사원이 존재하는 부서명을 출력해보자.
SELECT DNAME
FROM dept d
WHERE EXISTS (SELECT 1
              FROM emp 
              WHERE DEPTNO = d.DEPTNO);
 
 SELECT DNAME
FROM dept d
WHERE EXISTS (SELECT *
              FROM emp 
              WHERE DEPTNO = d.DEPTNO);

-- 6) 상관 서브쿼리(Correlated subqueries) : 서브쿼리가 외부 쿼리의 컬럼을 참조하는 경우를 말하며
   -- 서브쿼리는 외부 쿼리의 각 행에 대해 반복적으로 실행된다. 
   -- 외부쿼리 컬럼 참조 -> 행마다 서브쿼리가 실행됨.
  -- 각 부서에서 가장 높은 급여를 받는 사원의 모든 내용을 출력 해보자.
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP  E2
                  WHERE  E1.DEPTNO = E2.DEPTNO -- E1.DEPTNO 주쿼리 = 외부쿼리
                 ) ;
/*
	1. EMP 테이블의 첫번째 행 (E1) 읽음 ( E1.DEPTNO = 10 )
    2. 서브쿼리 실행 MAX(SAL) = 5000
    3. 주쿼리 행의 SAL과 비교 E1.SAL = 5000이면 통과, 아니면 제외
    4. 1. EMP 테이블의 첫번째 행 (E1) 읽음 ( E1.DEPTNO = 20 ) -> 서브쿼리 -> SAL = (MAX(SAL))
  ->루프를 돌음
 
	행마다 다른 deptno가 들어가있다. -> 서브쿼리가 매번 다른 결과를 낸다. -> 결과에 따라 주쿼리 조건이 동적으로 계산된다.
 */ 

*/        

-- 6-1. JOIN으로 바꾸어 보자. JOIN + GROUP BY
SELECT  E1.ENAME, E1.SAL, E1.DEPTNO
FROM EMP E1 JOIN (
					SELECT DEPTNO, MAX(SAL) AS MAX_SAL
                    FROM EMP
                    GROUP BY DEPTNO) E2 ON E1.DEPTNO = E2.DEPTNO AND E1.SAL = E2.MAX_SAL;

-- 6-2. WINDOW 함수 
SELECT ENAME, SAL, DEPTNO
FROM (
		SELECT ENAME, SAL, DEPTNO, RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS RNK
        FROM EMP
) T
WHERE RNK = 1; -- 급여가 1위인 사람만 출력 (MAX라서)

###############################################
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP
                  WHERE  E1.DEPTNO = DEPTNO
                 ) ;
#####################  서브쿼리 안에서 주쿼리 별칭으로 JOIN 하면 안돼요?
  SELECT  *
  FROM EMP E1
  WHERE  SAL  =  (
                  SELECT MAX(SAL)
                  FROM EMP  E2
                  JOIN E1 USING(DEPTNO)
                 );

# Error Code: 1146. Table 'my_emp.e1' doesn't exist    0.000 sec
### 서브쿼리가 외부쿼리의 별칭을 직접 참조 할 수 없다. !!!!1

-- 7)서브쿼리 내에서 LIMIT 형태 절의 사용이 제한될 수 있다.
  -- 각 부서에서 월급이 가장 높은 상위 3명의 사원번호, 이름, 봉급, 부서번호를 출력해보자
  -- 각 부서별로 월급이 높은 순으로 정렬된 사원의 목록을 만든다 -> 상위 3명 추출
SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP E
WHERE (	SELECT COUNT(*)
		FROM EMP E2
        WHERE E2.SAL > E.SAL AND E2.DEPTNO = E.DEPTNO) < 3
ORDER BY 4, 3 DESC;

SELECT EMPNO, ENAME, SAL, DEPTNO
FROM EMP
ORDER BY SAL DESC;

-- 2025-03-31 --
####### HAVING 서브 쿼리를 확인 해보자. 
 -- Q1. HAVING 서브 쿼리	 <단일 값 확인 후 having에서 비교 연산>
 -- 평균 급여가 전체 평균 보다 더 높은 부서를 찾아 보자.	
 -- 각 부서의 평균 급여를 전체 평균 급여와 비교하여, 전체 평균보다 높은 부서를 출력하자.
 use my_emp;
 
SELECT DEPTNO, AVG(SAL) as avg_salary
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) > (SELECT AVG(SAL) 
                    FROM EMP );

  -- Q2. HAVING 서브 쿼리 
  --  부서별로 사원 수가 전체 사원 수의 평균 보다 많은 부서를 찾아 부서번호, 직원수를 출력 해보자 
  SELECT DEPTNO, COUNT(EMPNO) AS NUM_COUNT
  FROM EMP
  GROUP BY DEPTNO
  HAVING COUNT(EMPNO)  >  ( SELECT AVG(NUM_COUNT)
                            FROM (SELECT COUNT(EMPNO) NUM_COUNT
                            FROM EMP
                            GROUP BY DEPTNO ) as AVG_DEPT);

-- 1 . 모든 부서별 사원 수를 계산
SELECT COUNT(EMPNO) NUM_COUNT
                    FROM EMP
                    GROUP BY DEPTNO;   -- 결과   3, 5, 6 
-- 2. 평균 값을 구한다.
SELECT AVG(NUM_COUNT)  -- AVG(3,5,6 )   -> 4.6667
         FROM (SELECT COUNT(EMPNO) NUM_COUNT
                FROM EMP
                GROUP BY DEPTNO 
                ) as AVG_DEPT;

 
 -- Q3. HAVING 서브 쿼리 
  -- 부서별 사원들의  최고 급여가  각 부서별 최고 급여의 평균보다  부서를 찾아 부서번호, 최고급여를 출력 해보자
  -- 주 쿼리 EMP 테이블에서 부서별 그룹화하고 각 그룹의 최고 급여를 계산한 다음 비교한다.
  -- HAVING 절에서 사용된 서브쿼리는 먼저 모든 부서의 최고 급여를 계산하고 -> 평균값을 계산한다. 

  -- 1. 모든 부서의 최고 급여를 계산
     SELECT MAX(SAL) as max_salary 
     FROM EMP GROUP BY DEPTNO;  -- 5000, 3000, 2850

  -- 2. 평균값을 계산한다. 
  SELECT AVG(max_salary) 
  FROM
     (SELECT MAX(SAL) as max_salary 
     FROM EMP GROUP BY DEPTNO) AS  DEPT_AVG_SAL ;  -- 3616

  -- 3. 병합
SELECT DEPTNO, MAX(SAL) as hi_sal  -- 10 , 5000 
FROM EMP
GROUP BY DEPTNO
HAVING MAX(SAL) > ( SELECT AVG(max_salary) 
                    FROM (SELECT MAX(SAL) as max_salary 
                         FROM EMP 
                         GROUP BY DEPTNO) AS  DEPT_AVG_SAL);


#####<---------------- INLINE VIEW ---------------> ####################


-- 13.2.15.7 : FROM 절에서 사용되는  INLINE VIEW
/*
INLINE VIEW ?  : from 절에서 사용되는 서브쿼리, 일시적인 가상테이블을 생성해서 주쿼리(외부)에서 사용
서브쿼리의 일종으로 From 절 뒤에 사용된다.
임시 테이블 처럼 사용된다. 단, {별칭}을 반드시 붙여야 한다.
주쿼리의 From 절에 포함된 서브쿼리의 결과를 임시테이블로 간주하여 조인하거나
추가적인 연산을 수행한다.
집계함수와 group by 같은 구문을 사용하여 중간결과를 생성한 후 쿼리에서 조인하거나 필터링하게 된다.
*/

-- Q1. 각 부서의 최대 급여를 출력 해보자. 부서의 이름과 최대급여를 출력 해보자. 
-- 단, 조건이 dept와 emp의 인라인 뷰를 사용해보자.
SELECT  D.DNAME, E.MAX_SAL 
FROM DEPT D
JOIN
 (SELECT DEPTNO  , MAX(SAL)  AS MAX_SAL
      FROM EMP 
      GROUP BY DEPTNO) E
ON  D.DEPTNO  = E.DEPTNO; 

-- 가상테이블 
SELECT DEPTNO  , MAX(SAL)  AS MAX_SAL
      FROM EMP 
      GROUP BY DEPTNO;

-- -> 가상 테이블과 detp d의 조인

-- Q2.임시테이블 생성 후 인라인 확인 해보자.alter
DROP TABLE T1;

-- 테이블 생성 
CREATE TABLE t1 (s1 INT, s2 CHAR(5), s3 FLOAT);

-- 구조 확인
desc t1;

-- 데이터 입력
INSERT INTO t1 VALUES (1,'1',1.0);
INSERT INTO t1 VALUES (2,'2',2.0);

-- 내용 확인
SELECT *
FROM  T1 ;

SELECT sb1,sb2,sb3
FROM (SELECT s1 AS sb1, 
			 s2 AS sb2, 
             s3*2 AS sb3 
      FROM t1) AS sb  -- 가상 테이블 객체를 SB 생성후
WHERE sb1 > 1;  --  ;를 만나면  자동  소멸 된다.

-- Q3. 각 부서별 평균 급여를 구하고 (= dept_avg 라는 인라인뷰 만들기), 평균 급여가 20000 이상인 부서의 부서번호와 평균급여를 출력하자.
select dept_avg.deptno, dept_avg.avg_sal
from (select deptno, avg(sal) as avg_sal
	  from emp
	  group by deptno) as dept_avg
where dept_avg.avg_sal >= 2000;

-- Q4. 인라인 뷰를 사용해서 사원의 이름, 급여, emp
-- 전체 사원의 평균 월급을 출력해보자. AA
select ename, sal, AA.avg_sal
from emp e
	join (select avg(sal) as avg_sal
		  from emp) AA;


