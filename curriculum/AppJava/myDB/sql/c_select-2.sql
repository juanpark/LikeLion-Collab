USE my_emp;
/*
like문 
SELECT 컬럼명
FROM 테이블명
WHERE 컬럼명 LIKE '패턴';
대소문자 구분 → MySQL 기본은 대소문자 구분 안 함 (utf8_general_ci 등 collation 영향)
ci : 대소문자 구분없이 비교하겠다 (a = A)

utf8_general_ci	-> 사전식. 정렬 숫자도 문자로 처리하겠다.
	- cast(), substring() 로 숫자를 숫자답게 처리할 수 있다.

패턴 종류 : 
	%	0개 이상 모든 문자
	_	정확히 1개 문자

ex)
'A%':	A로 시작	ALICE, ANDY 매칭
'%A':	A로 끝남	LISA, NINA 매칭
'%A%':	A를 포함	MARK, ADAM 매칭
'A_C':	A로 시작, 아무 문자 하나, C로 끝	ABC, ADC, AEC 매칭 

*/
-- Q1. 사원의 이름 중 S로 시작하는 사원의 이름을 출력 해보자.
SELECT ename
FROM emp
WHERE ename LIKE 'S%';   -- S로 시작하는 사원

-- Q2. 사원의 이름 중 T로 끝나는 사원의 이름을 출력 해보자.
SELECT ename
FROM emp
WHERE ename LIKE '%T';   -- T로 끝나는 사원

SELECT ename
FROM emp
WHERE ename LIKE '%_T';   -- T로 끝나는 사원

SELECT ename
FROM emp
WHERE ename LIKE '%TT';   -- TT로 끝나는 사원

-- Q3. 사원의 이름 중 A를 포함하는 사원의 이름을 출력 해보자.
-- 결과가 앞뒤 A가 다 출력된다.
SELECT ename
FROM emp
WHERE ename LIKE '%A%';  -- A를 포함하는 사원

-- Q4. 사원의 이름 중 A를 포함하는 사원의 이름을 출력 해보자. 단 중간에 포함하는 것만 검색하고 싶다.
-- -> and, not
SELECT ename
FROM emp
WHERE ename LIKE '%A%'  -- A를 포함하는 사원
	and ename not LIKE 'A%'  -- A로 시작하지 않겠다.
    and ename not LIKE '%A'; -- A로 끝나지 않겠다.

-- Q5. 2번째 글자가 M인 사원 (SMITH)을 출력해보자.
SELECT ename
FROM emp
WHERE ename LIKE '_MITH'; -- 2번째 글자가 M인 사원 (SMITH)

-- Q6. 대소문자를 구분하고 싶다면, 소문자 s로 시작하는 이름을 찾아보자.
SELECT ename
FROM emp
WHERE ename LIKE 's%' COLLATE utf8_bin; -- 소문자 s로 시작
-- 보통 서버에서 명령은 대소문자 구분하지 않지만 속성값은 반드시 구분 / php는 제외


-- ESCAPE 문법 (%, _를 문자로 취급하고 싶을 때) ESCAPE뒤에 있는 것을 찾음
-- LIKE 'A\_%' ESCAPE '\'	A_로 시작하는 문자열 (_는 문자 취급)

/*
SELECT comment
FROM board
WHERE comment LIKE '%\%%' ESCAPE '\';  -- {%기호 자체 검색}

-- comment에 %기호가 있는 글자만 찾아라.
WHERE comment LIKE '%!%%' ESCAPE '!';  -- {%기호 자체 검색}
	->  !% 에서 !가 ESCAPE라서 실제 % 문자열을 찾는다.
    
-- USERID에 _가 포함된 아이디를 찾아보자.
  WHERE UESRID LIKE '%\_%' ESCAPE '\';  

-- 제품 설명 50%라는 글자가 들어간 제품만 조회
  WHERE DESC LIKE '%!50!%%' ESCAPE '!';    
  
*/

-- REGEXP / RLIKE 
/*
WHERE 컬럼 REGEXP '정규식'
^, $, [], ` 
기본적으로 대소문자 구분 (옵션으로 변경 가능)
 - ^A	A로 시작
 - A$	A로 끝
 [0-9]	숫자 하나 포함
 ^[0-9]+$	숫자로만 구성
 ^[A-Za-z]+$	영문자만 구성
 [A-Z]{3}	{}반복횟수. 대문자 3글자 연속으로 찾음
 ^.{5}$		정확히 5글자만 추출              
 
  ^[A-Za-z0-9._%]+@[A-Za-z0-9._]+\.[A-Za-z]{2,} 이메일패턴		finish07@a.com
   [A-Za-z0-9._%]+		영대소문자, 숫자, .%중 하나이상 -> 아이디 부분
   [A-Za-z0-9._]+		영대소문자, 숫자 . _ 중 하나 -> 도메인 이름 부분
   \.	마침표 (.) 		\.으로 문자인식
   [A-Za-z]{2}			영문자 2자 이상 -> 도메인 확장자	com, net 등
   
	^[A-Za-z0-9._%]+@[A-Za-z0-9._]+\\.1[A-Za-z]{2,}$ => 동일함
    
    .임의의 문자 1개를 나타냄 (줄바꿈등은 제외)
    .* 임의의 문자 0개 이상
*/

-- Q1. REGEXP  (S 또는 A로 시작하는 사원의 이름을 출력해 보자.  )
SELECT ename FROM emp WHERE ename REGEXP '^(S|A)';

-- Q2. 사원의 이름이  TH로 끝나는 사원의 이름을 출력 해보자.
SELECT ename FROM emp WHERE ename REGEXP '^TH$';

-- Q3. 사원의 이름에 L, M, N이 들어간 사원의 이름을 출력 해보자.
SELECT ename FROM emp WHERE ename REGEXP '[LMN]';

-- Q4. 사원의 이름이 4글자인 사원의 이름을 출력해보자.
-- 포함관계이기 때문에 시작과 끝을 명시하고 아무글자나 4글자를 표시한다.
SELECT ename FROM emp WHERE ename REGEXP '^.{4}$';
-- 소문자 알파벳만 조회
SELECT ename FROM emp WHERE ename REGEXP '^[a-z]+$';

-- https://dev.mysql.com/doc/refman/8.4/en/regexp.html <가이드 확인!!>
-- 어떤 문자 이든지 있어도 되고 없어도 되고
SELECT 'Michael!' REGEXP '.*'; -- 모든 문자 0 more

-- new\\* 문자열에서 new* 를 그대로 찾겠다.
-- .	줄바꿈 제외 아무문자 1
-- \\* 	*문자
-- line	문자열 line 찾겠다.
SELECT 'new*\n*line' REGEXP 'new\\*.\\*line';  -- \n 줄바꿈이 있기에 매핑실패
SELECT 'e' REGEXP '^[a-d]';

/*
REGEXP_INSTR(expr, pat[, pos[, occurrence[, return_option[, match_type]]]])
-- 시작위치, 찾을 횟수 디폴트는 1,1
REGEXP_INSTR(검색 대상, '정규식', 시작위치, 찾을 횟수) : 위치 리턴 
*/

SELECT REGEXP_INSTR('dog cat dog', 'dog', 2);

SELECT REGEXP_INSTR('aa aaa aaaa', 'a{3}') as res;


-- REGEXP_REPLACE(원본, '패턴', '대체문자', 시작위치, 변경위치)사용
-- 시작위치, 변경위치 디폴트는 1,0
-- b를 x로 바꿔줘
SELECT REGEXP_REPLACE('a b c', 'b', 'X');

-- 영문자 소문자로 매칭 [a-z]+ 를  X로 3번 매치를 변경해줘
SELECT REGEXP_REPLACE('abc def ghi', '[a-z]+', 'X', 1, 3) as res;

-- 영문자 소문자로 매칭 [a-z]+ 를  X로 2번째 변경해줘
SELECT REGEXP_REPLACE('abc def ghi', '[a-z]+', 'X', 1, 2) as res;

-- 영문자 소문자로 매칭 [a-z]+ 를  X로 변경해줘
SELECT REGEXP_REPLACE('abc def GBCD', '[a-z]+', 'X', 1, 1) as res01;

SELECT REGEXP_LIKE('justalnums', '[[:alnum:]]+') as ros02 ; 

-- show variables like 'character_set%'; 을 확인해서 인코딩 내용 보기
/*
utf8mb4 : 4byte유니코드 지원하겠다., 이모지 저장
| character_set_system     | utf8mb3 : 3byte로 사용하겠다.

*/
create table mytable(
	id int
);

DROP TABLE mytable02;


CREATE TABLE mytable02 (
    id VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
);


CREATE TABLE mytable02 (
    id VARCHAR(255)
);

INSERT INTO mytable02 (id) VALUES
    ('가'), ('나'), ('다'), ('A'), ('B'), ('C'), ('a'), ('b'), ('c');

-- utf8mb4_general_ci는 대소문자를 구분하지 않으므로 a와 A를 같은 문자로 취급하고, 문자 코드 값에 따라 정렬한다. 
SELECT id FROM mytable02 ORDER BY id;

INSERT INTO mytable02 (id) VALUES
    ('가'), ('나'), ('다'), ('a'), ('b'), ('c'),('d');
    
-- 테이블 생성 시
CREATE TABLE mytable03 (
    id VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin
);
INSERT INTO mytable03 (id) VALUES   ('가'), ('나'), ('다'), ('A'), ('B'), ('C'), ('a'), ('b'), ('c');

SELECT id FROM mytable03 ORDER BY id;

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
-- ENAME, COMM컬럼 기준으로 그룹화 하고 각 그룹마다 COMM의 합계 SUM(COMM)을 계산
SELECT ENAME, COMM, SUM(COMM)  AS "SUM",
     GROUPING(ENAME), GROUPING(COMM) 
FROM EMP
GROUP BY ENAME, COMM WITH ROLLUP; -- 그룹 결과에 추가로 소계, 전체합계를 자동으로 계산
-- ORDER BY 2;
/* 실행 순서 (ENAME, COMM) -> 정상 그룹,
		  (ENAME, NULL)->ENAME의 소계 계산 , (NULL,NULL)-> 전체 계산
	  GROUPING(ENAME) : 1이면  ENAME이 NULL(소계, 전체), 0이면 실제 데이터
      GROUPING(COMM) : 1이면  COMM이 NULL(소계, 전체), 0이면 실제 데이터
*/


/*---------------ROW_NUMBER()---------------------------
SELECT ROW_NUMBER() [OVER  PARTITION BY, 
                            ORDER BY ]	 - 그룹핑도 하고 정렬도 하고 줄번호 표시
                    
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
  -- Q1)  사원테이블에서 사원의 이름을 출력하고 1부터 이름 옆에  번호를 매기자. NO라는 별칭을 주자.  
   SELECT ROW_NUMBER() OVER (ORDER BY ENAME DESC) AS "NO",  ENAME
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
    SELECT RANK()  OVER  ( ORDER BY  WEEKDAY(HIREDATE)) AS RANK_NO, 
          DENSE_RANK()  OVER  ( ORDER BY  WEEKDAY(HIREDATE)) AS DRANK_NO,  
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
   
	-- Q1. 부서별 평균 급여를 구하자. GROUP BY (개별행 x)
    select deptno, avg(sal)
    from emp
    group by deptno; 
   
	-- Q2. 부서별 평균 급여를 구하자. AVG OVER (개별행 O) 별칭은 부서 평균
    -- 부서별 평균급여와 전체 평균급여의 차이를 계산해보자.
    select deptno, avg(sal) OVER (PARTITION BY deptno) as '부서 평균',
				   avg(sal) OVER () as '전체 평균',
                   avg(sal) OVER (PARTITION BY deptno)-avg(sal) OVER () as 결과
    from emp;
    
   	-- Q3. 부서별 급여 합계를 구하자. SUM OVER (개별행 O) 별칭은 급여합계
    -- 부서별 급여합계와 전체 급여합계의 차이를 계산해보자.
    select deptno, sum(sal) OVER (PARTITION BY deptno) as '부서 합계',
				   sum(sal) OVER () as '전체 합계',
                   sum(sal) OVER (PARTITION BY deptno)-sum(sal) OVER () as 결과
    from emp; 
    
   
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
GROUP BY DEPTNO, JOB, ENAME, SAL WITH ROLLUP;
