USE MY_EMP;

-- Q1. 사원 테이블에서 '부서번호'와 '사원 이름'을 모두 출력해보자. 단 별칭으로 출력하자. 
SELECT DEPTNO AS '부서번호', ENAME AS '사원이름'
FROM EMP;

-- Q2. 부서번호가 10번인 사원의 모든 정보를 출력해보자.
SELECT *
FROM EMP
WHERE DEPTNO = 10;

-- FORMAT(X,D[,locale]) : 천단위 ',' 표시
-- Q3. 급여가 3000 이상인 사원의 사번(empno), 이름(ename), 급여(sal)를 출력해보자.
SELECT EMPNO, ENAME, FORMAT(SAL,0) AS SALARY
FROM EMP
WHERE SAL >= 3000;

-- Q4. 직업이 'MANAGER'인 사원의 이름과 직업를 출력해보자.
-- 명령은 대소문자를 구분하지 않지만 VALUE는 정확하게 구분
SELECT ENAME, JOB
FROM EMP
WHERE JOB = 'MANAGER';

-- 현재 날짜 포멧
SELECT DATE_FORMAT(NOW(), '오늘은 %Y년 %m월 %d일 %w입니다.');

-- Q5. 입사일이 1985년 이후인 사원의 이름과 입사일을 출력해보자.
SELECT ENAME, DATE_FORMAT(HIREDATE, '입사일은 %Y년 %m월 %d일 %w입니다.') AS '입사일'
FROM EMP
WHERE HIREDATE >= '1985-01-01';

-- Q6. 급여가 2000 이상이면서 직무가 'SALESMAN'인 사원의 이름과 급여, 직업를 출력해보자.
SELECT ENAME, FORMAT(SAL,0) AS SALARY, JOB
FROM EMP
# WHERE SAL >= 2000 AND JOB = 'SALESMAN'
WHERE SAL >= 1500 AND JOB = 'SALESMAN';

-- Q7. 커미션이 NULL이거나 급여가 5000 이상인 사원의 이름과 급여, 커미션을 출력해보자.
-- 단, 커미션이 없으면 없다고 출력을 해보자.
SELECT ENAME, FORMAT(SAL,0), IFNULL(FORMAT(COMM,0), '없음') AS '커미션'
FROM EMP
WHERE COMM IS NULL OR SAL >= 2000;

SELECT ENAME, FORMAT(SAL,0), IFNULL(FORMAT(COMM,0), '없음') AS '커미션'
FROM EMP;

-- Q8. 사원의 이름과 매니저를 출력하자, 단 매니저가 없으면 '없음'으로 출력 
SELECT ENAME, IFNULL(MGR, '없음') AS '매니저'
FROM EMP;

-- Q9. 사원의 이름과 매니저를 출력하자, 단 매니저가 없으면 '없음'으로 출력 [번외편: CASE WHEN THEN]
SELECT ENAME, 
			CASE WHEN MGR IS NULL THEN '없음'
 				ELSE CAST(MGR AS CHAR) -- 숫자를 문자로 변환 : '없음' 문자와 나머지 숫자를 문자로 캐스팅해서 컬럼의 형의 일관화 
			END AS '매니저'
FROM EMP;


-- DATE_FORMAT(date,format)
/*
mysql> SELECT DATE_FORMAT('2009-10-04 22:23:00', '%W %M %Y'); 요일이금, 월이름, 4자리연도
        -> 'Sunday October 2009'
mysql> SELECT DATE_FORMAT('2007-10-04 22:23:00', '%H:%i:%s'); 시간, 분, 초
        -> '22:23:00'
mysql> SELECT DATE_FORMAT('1900-10-04 22:23:00',
    ->                 '%D %y %a %d %m %b %j'); 일(TH), %a 요일의 약어, %j 일년중 몇번째 날
        -> '4th 00 Thu 04 10 Oct 277'
mysql> SELECT DATE_FORMAT('1997-10-04 22:23:00',
    ->                 '%H  24시간 2자리 표시
						%k  24시간 1자리 표시
                        %I  12시간제
                        %r  12시간 표시 시,분,초
                        %T  24시간 표시 시,분,초
                        %S  초
                        %w  요일 숫자 0=일요일
                        ');
        -> '22 22 10 10:23:00 PM 22:23:00 00 6'
mysql> SELECT DATE_FORMAT('1999-01-01', '%X %V');
        -> '1998 52'
mysql> SELECT DATE_FORMAT('2006-06-00', '%d');
        -> '00'
*/

/*   실행순서  
SELECT  컬럼리스트   -----------------------------------------------5
FROM    테이블 리스트          ------------------------------------ 1
WHERE   조건문 [숫자비교, 문자비교, 대소문자비교, NULL, 날짜비교,,]-------  2
GROUP BY   그룹화( 집계연산 SUM, MAX, MIN, AVG, MEAN, STD,,,,)------------  3
HAVING    GROUP BY 조건문    -----------------------------------  4
ORDER BY  정렬  ----------------------------------------------- 6 
LIMIT[옵션]  결과 제한  ---------------------------------------------7  
 
  FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT 
*/
 
-- WHERE는 GROUP BY 이전에 실행 → 일반 필터링
-- HAVING은 GROUP BY 이후에 실행 → 그룹핑 결과 필터링
-- -------------------------------------------------------------
-- SQL: 숫자함수, 문자함수, 날짜함수 
-- 집계함수 COUNT, MAX, MIN,SUM, AVG ...
-- Q1. 사원 테이블의 봉급을 이용해서 집계함수를 출력 해보자.
SELECT COUNT(SAL), MAX(SAL), MIN(SAL), SUM(SAL), AVG(SAL)
FROM EMP;

SELECT COUNT(NULL), MAX(NULL), MIN(NULL), SUM(NULL), AVG(NULL);

SELECT COUNT(COMM) -- COUNT NULL -> 0
FROM EMP;

SELECT COUNT(*)
FROM EMP;

-- Q2. 사원테이블에서 부서 번호가 10번인 사원의 평균 월급을 구해보자.
SELECT AVG(SAL)
FROM EMP
WHERE DEPTNO = 10;

-- Q3. 사원테이블에서 부서 번호가 10, 30번인 사원의 월급의 합을 구하자.
SELECT SUM(SAL)
FROM EMP
WHERE DEPTNO IN (10,30);

-- Q4. 직업이 세일즈맨인 사원의 평균 월급과 월급의 합을 구해보자.
SELECT AVG(SAL), SUM(SAL)
FROM EMP
WHERE JOB = 'SALESMAN';

-- Q5. 봉급이 3000 이상 5000 이하의 월급을 몇명이 받는지 개수를 출력해보자.
SELECT COUNT(*) AS '사원수'
FROM EMP
WHERE SAL BETWEEN 3000 AND 5000;


/*
SELECT 
FROM 
GROUP BY
ORDER BY

-GROUP BY 절에서는 테이블의 칼럼이나 변수만 사용할 수 있으며, { 그룹 함수는 사용할 수 없다} 
-SELECT 리스트에는 GROUP BY에 명시된 표현식과 그룹 함수만 사용할 수 있으며, *는 사용할 수 없다 (MYSQL는 예외적용)
-ORDER BY 절에서는 SELECT 리스트에 명시된 칼럼, 표현식, 별칭, 또는 칼럼 번호를 사용할 수 있다.
-FROM → WHERE → GROUP BY → HAVING → SELECT → ORDER BY → LIMIT
*/


-- Q1. 부서별 평균 월급을 구하자.
SELECT AVG(SAL)
FROM EMP
GROUP BY DEPTNO; -- 10 20 30

-- Q1-1 부서별 평균 월급을 구하자. 별칭을 NO로 주자
SELECT DEPTNO AS NO, AVG(SAL) AS '부서별 월급 평균'
FROM EMP
GROUP BY DEPTNO; -- 10 20 30

-- Q1-2 부서별 평균 월급을 구하자. 별칭으로 그룹핑 해보자.
SELECT DEPTNO AS NO, AVG(SAL) AS '부서별 월급 평균2'
FROM EMP
GROUP BY NO; -- 10 20 30 	별칭 그룹핑 권장사항 아님. 

-- Q1-3 부서별 평균 월급을 구하자. 문자열의 별칭으로 그룹핑 해보자. 안된다!!!
SELECT DEPTNO AS "번 호", AVG(SAL) AS '부서별 월급 평균2' -- "번 호" 따옴표 되어 있으면 안됨 - 문자열 그룹핑이 안됨.
FROM EMP
GROUP BY "번 호"; -- 10 20 30

-- Q1-4 부서별 평균 월급을 구하자. 속성명의 위치로 그룹핑 해보자.
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY 1; -- SELECT 속성명 위치 -- 이것도 권장사항 아님 

-- Q1-5 1-3의 번외편을 만들어서 실행해 보자. (따옴표 없이)
SELECT DEPTNO AS 번호, AVG(SAL) AS '부서별 월급 평균3'
FROM EMP
GROUP BY 번호; -- 10 20 30

-- Q2.  직업별 평균 월급을 구하자.
SELECT JOB, FORMAT(AVG(SAL), 2)
FROM EMP
GROUP BY JOB;

-- Q3.  부서별 평균 월급을 구하되 10번 부서의 평균 월급만 출력하자. 
SELECT DEPTNO, AVG(SAL)
FROM EMP
WHERE DEPTNO = 10
GROUP BY DEPTNO;

-- Q4. 직업별 월급의 합을 구하자
SELECT JOB, FORMAT(ROUND(SUM(SAL), 0),0) AS RES
FROM EMP
GROUP BY JOB;

-- Q5.직업이 SALESMAN인 사원의 월급의 합을 구하라.
SELECT JOB, SUM(SAL)
FROM EMP
WHERE JOB = 'SALESMAN';

-- Q6. 사원 테이블에서 사원의 최대 월급을 출력하자.
SELECT MAX(SAL)
FROM EMP;

SELECT ENAME, SAL
FROM EMP
WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- Q7. 사원테이블에서 사원 최소 월급을 출력하자. 
SELECT MIN(SAL);

SELECT ENAME, SAL
FROM EMP
WHERE SAL = (SELECT MIN(SAL) FROM EMP);

-- Q8. 각 부서별 최대 월급을 출력하자.
SELECT DEPTNO, MAX(SAL)
FROM EMP
GROUP BY DEPTNO;

-- Q9. 사원 테이블에서 커미션이 책정되어 있는 사원의 이름과 커미션을 출력하라
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NOT NULL;

-- Q10. 사원 테이블에서 커미션이 책정되지 않은 사원의 이름과 커미션을 출력하라.
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NULL;

/*
HAVING : 그룹함수로 집계된 데이터의 조건을 줄 때 사용 하는 구문
    1)  GROUP BY 절로 그룹화된 데이터에 조건을 줄때 사용
    2)  WHERE 절은 각 행에 대한 조건을 적용하는 반면,  HAVING 절은 그룹화된 데이터에 대한 조건을 적용한다. 
    3)  HAVING절에는 그룹핑된 컬럼이나 그룹함수에 대한 조건만 적용된다.
    4)  WHERE 와 HAVING은 함께 사용할 수 있으며, WHERE절로 행단위 조건은 먼저 수행하고, 그룹화된 
    결과에 추가 조건을  HAVING을 통해 적용할 수 있다. 
    5)  HAVING 다음에 SELECT-LIST에서 그룹핑에 사용한 컬럼과 , 그룹함수에 사용한 컬럼에 대해서만 조건을 
        줄 수 있다.
        
	WITH ROLLUP  =  그룹의 총계, 부분 소계를 나타낸다. ROLLUP 연산자는 GROUP BY 문과 함께 사용되며
		 GROUP BY 문에서 명시된 컬럼 순서대로 추가적인 요약 정보를 단계적으로 만들어 준다.
*/

-- Q1. 직업별 월급의 합을 구하고, 월급이 5000 이상인 사원만 출력해보자.
SELECT JOB, SUM(SAL)
FROM EMP
WHERE SAL >= 5000
GROUP BY JOB;

-- Q2. 직업별 월급의 합을 구하고, 월급이 5000 이상인 사원만 울력해보자.
SELECT JOB, SUM(SAL)
FROM EMP
# WHERE SUM(SAL) >= 5000
GROUP BY JOB
HAVING SUM(SAL) >= 5000;

-- Q3. 부서별 월급의 합, 전체 총합 및 세부내역을 출력 해보자. --> WITH ROLLUP
SELECT DEPTNO, ENAME, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, ENAME WITH ROLLUP ;

SELECT DEPTNO, ENAME, SUM(SAL)
FROM EMP
GROUP BY DEPTNO, ENAME;

-- Q4. 직업별 사원의 이름과 월급의 합, 전체 총합 및 세부내역을 출력 해보자. --> WITH ROLLUP
SELECT JOB, ENAME, SUM(SAL)
FROM EMP
GROUP BY JOB, ENAME WITH ROLLUP
ORDER BY 1;

SELECT JOB, ENAME, SUM(SAL)
FROM EMP
GROUP BY JOB, ENAME WITH ROLLUP
ORDER BY 1 DESC;  -- ORDER BY COLUMNNAME, SELECT -LIST 순서(1부터 시작), ASC DEFAULT, DESC

/*
SELECT JOB, ENAME, SUM(SAL)
FROM EMP
GROUP BY ROLLUP (JOB,ENAME) -- 기타 프로그램은 함수로...
ORDER BY 1 DESC;  -- 
*/

/*
GROUPING SET : 선택적인 그룹화 구현하는 키워드
	- 여러개의 조합을 그룹으로 사용할 때 사용하는 키워드
	- GROUP BY + 
    EX) 부서별 그룹화, 직업별 그룹화를 동시에 결합 

SELECT DEPTNO, JOB, AVG(SAL)
FROM EMP
GROUP BY GROUPING SETS ((DEPTNO),(JOB),(DEPTNO,JOB)); 
// DOESN'T WORK IN MYSQL BUT IS PART OF ANSI SQL -- WORKS IN ORACLE, POSTGRESQL, MS-SQL
// MYSQL VERSION:
GROUPING(expr [, expr] ...) - MYSQL

TODO 14.19.2 GROUP BY Modifiers
*/
