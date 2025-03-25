USE my_emp;
/*
like문 
SELECT 컬럼명
FROM 테이블명
WHERE 컬럼명 LIKE '패턴';
대소문자 구분 → MySQL 기본은 대소문자 구분 안 함 (utf8_general_ci 등 collation 영향)

%	0개 이상 모든 문자
_	정확히 1개 문자

ex)
'A%':	A로 시작	ALICE, ANDY 매칭
'%A':	A로 끝남	LISA, NINA 매칭
'%A%':	A를 포함	MARK, ADAM 매칭
'A_C':	A로 시작, 아무 문자 하나, C로 끝	ABC, ADC, AEC 매칭

*/
SELECT ename
FROM emp
WHERE ename LIKE 'S%';   -- S로 시작하는 사원

SELECT ename
FROM emp
WHERE ename LIKE '%T';   -- T로 끝나는 사원

SELECT ename
FROM emp
WHERE ename LIKE '%A%';  -- A를 포함하는 사원

SELECT ename
FROM emp
WHERE ename LIKE '_MITH'; -- 2번째 글자가 M인 사원 (SMITH)

-- 대소문자를 구분하고 싶다면
SELECT ename
FROM emp
WHERE ename LIKE 's%' COLLATE utf8_bin; -- 소문자 s로 시작


-- ESCAPE 문법 (%, _를 문자로 취급하고 싶을 때)
-- LIKE 'A\_%' ESCAPE '\'	A_로 시작하는 문자열 (_는 문자 취급)
/*
SELECT comment
FROM board
WHERE comment LIKE '%\%%' ESCAPE '\';  -- % 기호 자체 검색
*/

-- REGEXP / RLIKE 
/*
WHERE 컬럼 REGEXP '정규식'
^, $, [], ` 
기본적으로 대소문자 구분 (옵션으로 변경 가능)

*/

-- REGEXP  (S 또는 A로 시작하는 사원의 이름을 출력해 보자.  )
SELECT ename FROM emp WHERE ename REGEXP '^(S|A)';


/*
CUBE = 소계 , 총계: GROUP BY 문과 함께 사용되며 GROUP BY 문에서 명시한 
전체 컬럼에서 대하여 추가적인 요약 정보를 단계적으로 만들어 준다  _MYSQL x 
*/
/*
GROUPING : GROUPING 함수는  그룹 기준에서 고려하지 않은 부분 총계인 경우에 1[롤업]을 리턴하고,
                            그렇지 않은 경우 0[일반행]을 리턴한다. 
							* 일반 그룹에 속해 있는지,  WITH ROLLUP에 속해 있는지.                                                        
					
*/
-- Q1) 사원의 커미션의 합계, 각 사원에 대한 커미션의 총합, 전체 커미션 총합을 출력하자.  
SELECT ENAME, COMM, SUM(COMM)  AS "SUM",
     GROUPING(ENAME), GROUPING(COMM) 
FROM EMP
GROUP BY ENAME, COMM WITH ROLLUP 
ORDER BY 2;

/*---------------ROW_NUMBER()---------------------------
SELECT ROW_NUMBER() [OVER  PARTITION BY, 
                            ORDER BY ]	
                    
 열 A 값의 내림차순으로 일련 번호 리턴 : SELECT ROW_NUMBER() OVER (ORDER BY A DESC);
 
 컬럼 X 의 값으로 그룹핑 분할 하고 ,그 중에서 컬럼 A 의 값의 내림차순으로 일련번호를 리턴
 SELECT ROW_NUMBER() OVER (PARTITION BY X ORDER BY  A DESC);
 
 --  RANK() : 동일한 값에 같은 순위를 부여하고 다음 순위는 중복된 개수를 고려해서 건너 띤다.   
 SELECT RANK() OVER  (PARTITION BY,   ORDER BY)	1,2,2,2,5,6,6,8
    EX) 3일에 입사한 모든 사원들은 같은 순위를 받고, 그 다음 순위는 건너띄게 된다.  
    
  -- DENSE_RANK()  : 순위를 할당 하지만 중복값이 있어도 순위를 건너띄지 않는다.  
  SELECT DENSE_RANK() OVER  (PARTITION BY,   ORDER BY )	1,2,2,2,3,4,4,4,4,4,5
    EX) 3일에 입사한 사원들이 여러명 있다면 모두 같은 순위를 받은 다음에 그다음은 연속순위다.                    
  */  
  -- Q1)  사원테이블에서 사원의 이름을 출력하고 1부터 번호를 매기자. NO라는 별칭을 주자.  
   SELECT ROW_NUMBER() OVER (ORDER BY ENAME) AS "NO",  ENAME
   FROM EMP;  
   -- Q2) 사원테이블에서 사원의 이름을 출력하고 14 부터 번호를 매기자. NO라는 별칭을 주자.  
   SELECT ROW_NUMBER() OVER (ORDER BY ENAME) AS "NO",  ENAME
   FROM EMP
   ORDER BY 1 DESC;   
   -- Q3) 사원테이블에서 사원의 이름을 Z~A 출력하고  번호를 매기자. NO라는 별칭을 주자.  
   SELECT ROW_NUMBER() OVER (ORDER BY ENAME DESC) AS "NO",  ENAME
   FROM EMP;   
   
   -- Q4)  사원테이블에서 사원의 이름을 출력하고 1부터 번호를 매기자. NO라는 별칭을 주자.  
   -- 홀수 라벨링 2N-1  -> N  
   SELECT ( 2 * ROW_NUMBER() OVER (ORDER BY ENAME)  -1) AS "NO",  ENAME
   FROM EMP;   
   
   
   -- Q5)  사원테이블에서 사원의 이름을 출력하고 1부터 번호를 매기자. NO라는 별칭을 주자. 
    -- 짝수 라벨링 2N
   SELECT ( 2 * ROW_NUMBER() OVER (ORDER BY ENAME)) AS "NO",  ENAME
   FROM EMP; 
   
   -- Q6). 직업별로 그룹화를 하고 번호를 출력하자, 이름으로 정렬하자.
   -- 직업별 그룹화 내에 이름 기준으로 순서를 매기자.  
   SELECT ROW_NUMBER()  OVER (PARTITION BY JOB ORDER BY ENAME ) AS RES, 
         JOB, ENAME
   FROM EMP;
   
   -- GROUP BY  : 테이블 내의 특정(열,컬럼)의 값에 따라 그룹화 하고 각 그룹에 집계함수를 적용한다 (개별행 x) 
   -- ROW_NUMBER() 의 PARTITION BY속성을 지정하게 되면 특정열의 값에 따라 여러 그룹으로 나눌수 있고 
   --  ORDER BY 절에 따라 순서를 매긴다. (개별행 O)  
   
   -- Q7)  사원의 번호, 사원의 이름, 입사일을 출력하되 입사일을 기준으로 순위를 출력해보자.  
   
   SELECT RANK()  OVER  ( ORDER BY  HIREDATE) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  HIREDATE) AS DRANK_NO,  
          EMPNO, ENAME, HIREDATE
   FROM EMP;
     
   -- 7-1  번외편  
   -- 년도별 
    SELECT RANK()  OVER  ( ORDER BY  YEAR(HIREDATE)) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  YEAR(HIREDATE)) AS DRANK_NO,  
          EMPNO, ENAME, HIREDATE
   FROM EMP;
   
   -- 월 별  
    SELECT RANK()  OVER  ( ORDER BY  MONTH(HIREDATE)) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  MONTH(HIREDATE)) AS DRANK_NO, 
          MONTH(HIREDATE),EMPNO, ENAME, HIREDATE
   FROM EMP;
   
   -- 날짜별
    SELECT RANK()  OVER  ( ORDER BY  HIREDATE) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  HIREDATE) AS DRANK_NO,  
          EMPNO, ENAME, HIREDATE
   FROM EMP;
   
   -- 요일별  
    SELECT RANK()  OVER  ( ORDER BY  HIREDATE) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  HIREDATE) AS DRANK_NO,  
          EMPNO, ENAME, HIREDATE
   FROM EMP;
   /*
      WEEKDAY ()   0~ 6 월요일 ~ 일요일  
	  YEAR() : 1000 ~  9999 4자리 
	  MONTH() : 1~ 12
      DAY  ()  : 1~ 31 
      DAYOFMONTH()  = DAY()
      DATE_ADD()   
   */
   
   
   /* 윈도우함수  OVER()절  => 범위, 그룹화, 정렬 
     1. 순위 함수  :   ROW_NUMBER() , RANK(), DENSE_RANK() , NTILE(N) ,,
     2. 집계 함수  :  MAX, MIN, COUNT,AVG, SUM ,,,,
	 3. 행 순서 함수 :  LAG _현재행앞에 데이터, LEAD()_현재 행 뒤에 데이터 , FIRST_VALUE(), LAST_VALUE()
                     NTH_VALUE()
	 4. 프레임함수 : CUME_DIST() _누적 분포 비율  /  PERCENT_RANK()   
   
   */
 
  
  /*
    DB로 그룹화 지표를 확인하는 순서  
  1. 데이터 리포터를 구현하는 키워드를 사용 
  2. GROUPING() 함수로 확인  
  3. ROW_NUMBER() 를 통해서 데이터 추출 후 넘버를 지정 
  4. Rank()로 순위
  */
  SELECT  DEPTNO,  JOB,  ENAME,  SAL,
    SUM(SAL) OVER (PARTITION BY DEPTNO) AS TotalDeptSalary,
    GROUPING(DEPTNO) AS GroupingDept,
    GROUPING(JOB) AS GroupingJob,
    ROW_NUMBER() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS RowNum,
    RANK() OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS "Rank"
FROM EMP
GROUP BY ROLLUP(DEPTNO, JOB, ENAME, SAL);
