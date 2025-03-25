 /* 윈도우함수  OVER()절  => 범위, 그룹화, 정렬 
 window_spec:
    [window_name] [partition_clause] [order_clause] [frame_clause]  
    https://dev.mysql.com/doc/refman/8.4/en/window-functions-named-windows.html
    
    주요 함수 
ROW_NUMBER()	 : 순번 부여
RANK()	 : 동일 순위 존재 시 건너뛰는 순위 부여
DENSE_RANK()	:동일 순위 존재해도 순위 연속 부여
NTILE(N)	: N등분 구간 나누기
LAG()	: 현재 행 기준 이전 행 값 가져오기
LEAD()	: 현재 행 기준 다음 행 값 가져오기
FIRST_VALUE() : 	그룹 내 첫 번째 값
LAST_VALUE(): 	그룹 내 마지막 값
NTH_VALUE()	: N번째 값 가져오기
CUME_DIST()	: 누적 비율 계산
PERCENT_RANK()	: 상대적 백분율 순위 계산
    
    
    
     1. 순위 함수  :   ROW_NUMBER() , RANK(), DENSE_RANK() , NTILE(N) ,,
     2. 집계 함수  :  MAX, MIN, COUNT,AVG, SUM ,,,,
	 3. 행 순서 함수 :  LAG _현재행앞에 데이터, LEAD()_현재 행 뒤에 데이터 , FIRST_VALUE(), LAST_VALUE()
                     NTH_VALUE()
	 4. 프레임함수 : CUME_DIST() _누적 분포 비율  /  PERCENT_RANK()   
     
    [선언형식 ]
    frame_extent:    {frame_start | frame_between}       -> 프레임시작위치 | 끝과  마지막 지정

     frame_between:  BETWEEN frame_start AND frame_end   ->  프레임 시작과 끝  

     frame_start, frame_end: {
    CURRENT ROW          ----> 현재 행  : 프레임은 항상 현재 행에서 START  
  | UNBOUNDED PRECEDING  ---->  프레임시작을 현재 파티션의 첫번쨰 행으로 지정     
  | UNBOUNDED FOLLOWING  ---->  프레임 끝을 현재 파티션의 마지막 행으로 지정  
  | expr PRECEDING     ----> EXPR 이전의 행  /  3 PRECEDING  -> 현재 행의 3이전부터 프레임 시작 또는 끝  
  | expr FOLLOWING      ---> EXPR  이후의 행  /  2 FOLLOWING  ->  현재 행의 2행 이후 부터 프레임이 시작 또는 끝 
    }
    
  EX 1) 프레임 시작  : UNBOUNDED PRECEDING ,     프레임 끝 : CURRENT ROW
  . SUM(SAL) OVER ( ORDER BY HIREDATE  
					ROWS   BETWEEN UNBOUNDED PRECEDING  AND CURRENT ROW) 
	  --->  현재 행까지의 모든 이전행에 대한 급여의 합계를 리턴  
      
  EX 2)프레임 시작  : CURRENT ROW  ,     프레임 끝 :  UNBOUNDED FOLLOWING
  . SUM(SAL) OVER ( ORDER BY HIREDATE  
					ROWS  BETWEEN CURRENT ROW  AND UNBOUNDED FOLLOWING)
                    	  --->  현재 행에서 시작 해서 이후의  모든행 에 대한 급여의 합계를 리턴  

 EX 3) 프레임 시작  :  2 PRECEDING  ,     프레임 끝 :  1 FOLLOWING
  . SUM(SAL) OVER ( ORDER BY HIREDATE  
					ROWS  BETWEEN  2 PRECEDING   AND 1 FOLLOWING)
	--->  현재 행을 기준으로 2행 전부터 1행 후까지의 급여합계를 구하자 
 */
 
 -- Q1) 급여가 높은 순서대로 정렬하고 각 사원의 이전 사원 급여를 리턴 해보자 
 SELECT ENAME, SAL, LAG(SAL,1)  OVER (ORDER BY SAL DESC)  AS res
 FROM EMP;
 
  SELECT ENAME, SAL, LAG(SAL)  OVER (ORDER BY SAL DESC)  AS res
 FROM EMP;
   
    SELECT ENAME, SAL, LAG(SAL , 2)  OVER (ORDER BY SAL DESC)  AS res
 FROM EMP;
   
  -- Q2) 급여가 높은 순서대로 정렬하고 각 사원의 다음 사원 급여를 리턴 해보자   
  SELECT ENAME, SAL, LEAD(SAL ,1)  OVER (ORDER BY SAL DESC)  AS res
 FROM EMP;
   
   -- Q3) 첫번째와 마지막 값 가져오기  
   -- 부서별 직원들의 급여을 정렬한 후 , 각 직원의 부서내 첫번째(가장많이 받는) 와 마지막 급여(가장적게 받는)를 출려하자.  
   --  사원의 부서번호, 사원의 이름, 봉급, 첫번째, 마지막 출력 해보자. 
    SELECT   DEPTNO, ENAME,  SAL, 
    FIRST_VALUE(SAL) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC) AS "첫번째",
    LAST_VALUE(SAL) OVER (PARTITION BY DEPTNO ORDER BY SAL DESC 
        ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS "마지막"
FROM EMP;

 -- Q4) 부서별로 가장 먼저 입사한 직원의 급여를 출력해 보자.  FIRST_VALUE() 
 --  부서번호, 사원의 이름, 입사일 ,봉급,  RES 
 
SELECT   DEPTNO, ENAME, HIREDATE,SAL, 
		FIRST_VALUE(SAL) OVER (
								PARTITION BY DEPTNO 
								ORDER BY HIREDATE 
								ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
		) AS RES
FROM EMP
ORDER BY DEPTNO, HIREDATE;


 -- Q5) 부서별로 가장 최근  입사한 직원의 급여를 출력해 보자.  LAST_VALUE() 
 
SELECT   DEPTNO, ENAME, HIREDATE,SAL, 
		LAST_VALUE(SAL) OVER (
								PARTITION BY DEPTNO 
								ORDER BY HIREDATE 
								ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING
		) AS RES
FROM EMP;

-- Q6 ) 부서별로 현재 행까지 급여중 가장 마지막 값을 조회하자.  
--  해당 부서 내에서 현재행까지의 급여중 가장 최근의 값  
EXPLAIN
SELECT   DEPTNO, ENAME, HIREDATE,SAL, 
		LAST_VALUE(SAL) OVER (
								PARTITION BY DEPTNO 
								ORDER BY HIREDATE 
								ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
		) AS RES
FROM EMP;


-- Q7 ) 부서별로 현재 행과 그 이전 행 중 가장 높은 급여를 출력하자.  LAST_VALUE()
--   현재 행의 값이 프레임의 마지막 값으로 간주된다.  
SELECT   DEPTNO, ENAME, SAL, 
         LAST_VALUE(SAL) OVER (
        PARTITION BY DEPTNO 
        ORDER BY SAL DESC 
        ROWS BETWEEN 1 PRECEDING AND CURRENT ROW   # 마지막 값을 현재 행의 값으로 리턴  
    ) AS RES
FROM EMP
ORDER BY DEPTNO, SAL DESC;

-- PERCENT_RANK()  :   결과 집합 행의  상대적 순위를 계산하는 함수  

-- Q8)  사원테이블에서 봉급의 백분율를 계산해 보자.   - 상대적 순위 
   SELECT SAL ,
   PERCENT_RANK() OVER (ORDER BY SAL ) AS RES
   FROM EMP;

-- Q9) 사원테이블에서 봉급의 백분율과 순위를 계산해보자. 
   SELECT SAL ,
   PERCENT_RANK() OVER (ORDER BY SAL ) AS RES,
   RANK() OVER ( ORDER BY SAL DESC) AS "RANK"
   FROM EMP;
   
-- Q10)  번외 편  사원 테이블에서 봉급의 합을 구하자.  
-- OVER은 행의 결과집합이 리턴되어 결과 집합의 시작 부터 현재 행까지의 모든행에 대한 누적 합계
SELECT SUM(SAL)  OVER (ORDER BY SAL), SAL
FROM EMP;

-- Q11) 같은 부서의 모든 사원의 급여 합계를 내보자. 
SELECT DEPTNO, SAL, SUM(SAL) OVER (PARTITION BY DEPTNO) AS RES
FROM  EMP;


/*
SELECT DEPTNO, SAL , SUM(SAL)
FROM EMP
GROUP BY DEPTNO, SAL
ORDER BY  1;
*/

-- Q12)  사원의 입사일과 지정된 날짜까지 입사한 사원의 직원수를 출력 해보자.  
SELECT HIREDATE, COUNT(*) OVER (ORDER BY HIREDATE) AS "CNT"
FROM EMP;

-- Q13) 년도별 고용수를 확인 하자.  
SELECT   YEAR(HIREDATE) , COUNT(*) AS EMP_COUNT
FROM   EMP
GROUP BY   YEAR(HIREDATE) 
ORDER BY 1 ; 



SELECT   EXTRACT(YEAR FROM HIREDATE)  AS  년도 , 
          COUNT(*) AS EMP_COUNT
FROM   EMP
GROUP BY    EXTRACT(YEAR FROM HIREDATE)
ORDER BY 1 ; 


SELECT   EXTRACT(YEAR FROM HIREDATE)  AS  년도 , 
          COUNT(*) AS EMP_COUNT
FROM   EMP
GROUP BY   년도    ##############컬럼 별칭사용  
ORDER BY 1 ;

-- Q14)  사원테이블에서 부서 번호와 각 부서 (DEPTNO) 직원의 평균 재직 기간(년)을 출력 하자.  
     --  현재 날짜는 오늘날짜로, 직원이 있는 부서만 계산을 한다.  
     -- AVG, TIMESTAMPDIFF , COUNT 사용 
     
     SELECT DEPTNO,  AVG(TIMESTAMPDIFF(YEAR, HIREDATE,NOW())) AS "평균재직기간" 
     FROM EMP
	 GROUP BY DEPTNO
     HAVING COUNT(EMPNO) > 0;
     
 -- Q15) 직업과 직업별 사원의 근무기간(년도)의 표준 편차를 출력 해보자.  
    SELECT JOB,  STD( TIMESTAMPDIFF(YEAR, HIREDATE,NOW()))  AS "표준편차"
    FROM EMP
    GROUP BY JOB;
 
 -- Q16) 급여의 변동을 확인해 보고 싶다.  : 모집단 표본을 기본으로 분산하겠다. 
  -- 전체 데이터 셋이 아닌 표본 데이터 셋을 활용 
 --  부서번호와 각 부서에 대한 표본 분산을 출력 해보자.  
 
   SELECT DEPTNO ,   VAR_SAMP(SAL) AS "RES"
   FROM EMP
   GROUP BY DEPTNO ;
   
   EXPLAIN
   SELECT DEPTNO ,   VAR_SAMP(SAL) AS "RES"
   FROM EMP
   GROUP BY DEPTNO ;
     
 -- Q17) 부서내 급여 표준 편차  : 부서의 개인 급여가 부서의 평균 급여와 얼마나 다른지 측정하는 것  
 --  STDDEV(EXPR)  :  표준 편차가 높을 수록 급여의 범위가 넓다.  
 -- 사원의 각 부서별 봉급의 표준 편차 계산해 보자.  
 SELECT DEPTNO, 
        STDDEV(SAL) AS RES  # 모집단 표본을 기본으로 분산하겠다.  
 FROM EMP
 GROUP BY DEPTNO;
 
 -- Q18)  00님의 월급은  00입니다.   GROUP_CONCAT() 
 SELECT  CONCAT(ENAME,'님의 월급은',SAL,'입니다') as message
 FROM EMP;
 /*
 
GROUP_CONCAT([DISTINCT] expr [,expr ...]
             [ORDER BY {unsigned_integer | col_name | expr}
                 [ASC | DESC] [,col_name ...]]
             [SEPARATOR str_val])
             
*/
# 18-1 
SELECT GROUP_CONCAT(ENAME)  AS RES
FROM EMP;
-- 18-2  고유한 직업리스트를 하나의 문자열로 결합해서 리턴  
 SELECT GROUP_CONCAT(DISTINCT JOB)
 FROM EMP;
 
-- 18-3  ORDER BY   : 월급이 높은 순서대로 직원의 이름을 결합해서 리턴  
 SELECT GROUP_CONCAT(ENAME ORDER BY  SAL DESC)
 FROM EMP;

-- 18-4
SELECT  GROUP_CONCAT(ENAME SEPARATOR ' |  ') as message
 FROM EMP;
 
 -- 18-5 여러개의 열을 결합해 보겠다.  
 -- 사원이름 : 직업  -> 오름차순으로 결합  
 
 SELECT  GROUP_CONCAT(CONCAT(ENAME, ':', JOB) 
                 ORDER BY ENAME ASC SEPARATOR '; ')  as message
 FROM EMP;
 
 





 

   
   
   
   
   