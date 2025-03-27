use my_emp;
########주요 날짜 함수
-- Q1. 현재 날짜와 시간 정보를 출력하라.
-- 예: 2024-08-15 15:30:00
SELECT NOW();


-- Q2. 현재 날짜만 출력하라.
-- 예: 2024-08-15
SELECT CURDATE();

-- Q3. 현재 시간만 출력하라.
-- 예: 15:30:00
SELECT CURTIME();

-- Q4. 특정 날짜(2024-08-15)의 요일을 출력하라.
-- 예: Friday
SELECT DAYNAME('2024-08-15');

-- Q5. 현재 날짜에서 30일을 더한 날짜를 출력하라.
-- 예: 2024-09-14
SELECT DATE_ADD(CURDATE(), INTERVAL 30 DAY);

-- Q6. 현재 날짜에서 30일을 뺀 날짜를 출력하라.
-- 예: 2024-07-16
SELECT DATE_SUB(CURDATE(), INTERVAL 30 DAY);

-- Q7. 현재 시간에서 1시간을 더한 시간을 출력하라.
-- 예: 16:30:00
SELECT ADDTIME(CURTIME(), '01:00:00');

-- Q8. 현재 시간에서 1시간을 뺀 시간을 출력하라.
-- 예: 14:30:00
SELECT SUBTIME(CURTIME(), '01:00:00');

-- Q9. 주어진 날짜('2024-08-15')가 해당 연도의 몇 번째 주인지 출력하라.
-- 예: 33
SELECT WEEK('2024-08-15');

-- Q10. 주어진 날짜('2024-08-15')가 해당 연도의 몇 번째 일인지 출력하라.
-- 예: 228
SELECT DAYOFYEAR('2024-08-15');

-- Q11. '2024-08-15 15:30:00'에서 연도만 출력하라.
-- 예: 2024
SELECT YEAR('2024-08-15 15:30:00');

-- Q12. '2024-08-15 15:30:00'에서 월만 출력하라.
-- 예: 08
SELECT MONTH('2024-08-15 15:30:00');

-- Q13. '2024-08-15 15:30:00'에서 일만 출력하라.
-- 예: 15
SELECT DAY('2024-08-15 15:30:00');

-- Q14. '2024-08-15 15:30:00'에서 시만 출력하라.
-- 예: 15
SELECT HOUR('2024-08-15 15:30:00');

-- Q15. '2024-08-15 15:30:00'에서 분만 출력하라.
-- 예: 30
SELECT MINUTE('2024-08-15 15:30:00');

-- Q16. '2024-08-15 15:30:00'에서 초만 출력하라.
-- 예: 00
SELECT SECOND('2024-08-15 15:30:00');

-- Q17. emp 테이블에서 현재 날짜 기준으로 입사일이 10년 이상 된 사원의 목록을 출력하라.
-- 예: ID, 이름, 입사일
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate <= DATE_SUB(CURDATE(), INTERVAL 10 YEAR);

-- Q18. emp 테이블에서 입사일이 가장 최근인 사원의 목록을 출력하라.
-- 예: ID, 이름, 입사일
SELECT empno, ename, hiredate
FROM emp
ORDER BY hiredate DESC
LIMIT 1;

-- Q19. dept 테이블에서 현재 날짜와 가장 가까운 과거의 부서 설립일을 출력하라.
-- 예: 부서번호, 설립일
SELECT deptno, loc
FROM dept
WHERE loc <= CURDATE()
ORDER BY loc DESC
LIMIT 1;

-- Q20. emp 테이블에서 각 사원의 연차를 계산하라 (현재 날짜 기준).
-- 예: ID, 이름, 연차
SELECT empno, ename, TIMESTAMPDIFF(YEAR, hiredate, CURDATE()) AS years_of_service
FROM emp;

-- Q21. dept 테이블에서 부서설립일이 현재 날짜 기준으로 가장 오래된 부서를 출력하라.
-- 예: 부서번호, 설립일
SELECT deptno, loc
FROM dept
ORDER BY loc ASC
LIMIT 1;

############ USE WORLD ################
-- 데이터베이스 전환
USE WORLD;

-- city의 구조를 확인 해보자 22번부터 city 테이블 문제는 스킵 
DESC city;
DESC country;
DESC countrylanguage;

SELECT *
FROM CITY;

-- Q22. world의 city 테이블에서 각 도시의 개월 수를 계산하라 (현재 날짜 기준).
-- 예: 도시명, 개월 수
SELECT NAME, TIMESTAMPDIFF(MONTH, date, CURDATE()) AS months_since_established
FROM world.city;

-- Q23. world의 city 테이블에서 가장 최근에 설립된 도시를 출력하라.
-- 예: 도시명, 설립일
SELECT city, date
FROM world.city
ORDER BY date DESC
LIMIT 1;

-- Q24. emp 테이블에서 현재 날짜를 기준으로 입사일이 6개월 이상 경과한 사원의 목록을 출력하라.
-- 예: ID, 이름, 입사일
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate <= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);

-- Q25. emp 테이블에서 사원의 봉급(SAL)을 기준으로 가장 작은 두 자리 숫자를 만들어 출력하라.
-- 예: 봉급 1234 -> MOD(1234, 100) = 34
SELECT empno, ename, SAL, MOD(SAL, 100) AS last_two_digits
FROM emp;

-- Q26. emp 테이블에서 입사일을 기준으로 가장 최근에 입사한 사원의 입사일을 년, 월, 일로 분리하여 출력하라.
-- 예: ID, 이름, 연도, 월, 일
SELECT empno, ename, YEAR(hiredate) AS year, MONTH(hiredate) AS month, DAY(hiredate) AS day
FROM emp
ORDER BY hiredate DESC
LIMIT 1;

-- Q27. dept 테이블에서 각 부서의 설립일을 현재 날짜 기준으로 연도 단위로 출력하라.
-- 예: 부서번호, 연도
SELECT deptno, YEAR(loc) AS year_established
FROM dept;

-- Q28. world의 city 테이블에서 현재 날짜 기준으로 각 도시의 설립일을 년도 단위로 출력하라.
-- 예: 도시명, 연도
SELECT city, YEAR(date) AS year_established
FROM world.city;

-- Q29. 2020년 1월 1일 부터 2020년 12월 30일 사이에 입사한  사원의 번호, 이름, 입사일을 출력하자. 
-- BETWEEN   S_v AND  E_v  
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE HIREDATE BETWEEN '2020-01-01' AND '2020-12-30';

USE MY_EMP;
-- Q30)  특정 달에 입사한 직원을 조회 해보자. 
-- 1981년도 6월에 입사한 직원들의 사원번호, 사원의 이름, 입사일  
SELECT EMPNO, ENAME, HIREDATE
FROM EMP
WHERE  YEAR(HIREDATE)  = 1981  AND MONTH(HIREDATE )  = 6;

-- Q31) 입사 후  근무 기간이 5년 이상인 직원들의 사원번호, 사원의 이름, 입사일을 출력해보자. 
SELECT EMPNO, ENAME, HIREDATE, DATEDIFF(CURDATE() , HIREDATE) / 365  AS RES
FROM EMP 
HAVING  RES >= 5; # 특정 조건의  그룹을 필터링 한다.  오류나지 않는다.  

SELECT EMPNO, ENAME, HIREDATE, DATEDIFF(CURDATE() , HIREDATE) / 365  AS RES
FROM EMP 
WHERE   DATEDIFF(CURDATE() , HIREDATE) / 365 >= 5;  

SELECT EMPNO, ENAME, HIREDATE, DATEDIFF(CURDATE() , HIREDATE) / 365  AS RES
FROM EMP 
WHERE  RES >= 5; # 별칭 비교  오류 난다.    WHERE 절은 별칭 비교를 직접 사용할 수 없다. !!!! 


/*
1. 현재 날짜 및 시간
	NOW(): 현재 날짜와 시간을 리턴.
	CURDATE(): 현재 날짜를 리턴.
	CURTIME(): 현재 시간을 리턴.
2. 날짜 및 시간 추출
	YEAR(date): 날짜에서 연도를 추출.
	MONTH(date): 날짜에서 월을 추출.
	DAY(date): 날짜에서 일을 추출.
	HOUR(time): 시간에서 시를 추출.
	MINUTE(time): 시간에서 분을 추출.
	SECOND(time): 시간에서 초를 추출.
	DAYNAME(date): 날짜의 요일 이름을 리턴.
	DAYOFWEEK(date): 날짜의 요일을 숫자로 리턴. (1=일요일, 7=토요일).
3. 날짜 계산
	DATE_ADD(date, INTERVAL value unit): 날짜에 지정된 시간 간격을 추가.
	DATE_SUB(date, INTERVAL value unit): 날짜에서 지정된 시간 간격 리턴.
	DATEDIFF(date1, date2): 두 날짜 간의 차이를 일수로 리턴.
4. 날짜 형식 변환
	DATE_FORMAT(date, format): 날짜를 지정된 형식으로 리턴. 예: '%Y-%m-%d', '%d/%m/%Y'.
	STR_TO_DATE(string, format): 문자열을 날짜 형식으로 변환 -> CAST() 
5. 시간 계산
	ADDDATE(date, INTERVAL value unit): 날짜에 시간 간격을 추가 (DATE_ADD와 유사).
	SUBDATE(date, INTERVAL value unit): 날짜에서 시간 간격 리턴 (DATE_SUB와 유사).
	TIMESTAMPADD(unit, value, datetime): 주어진 단위와 값을 날짜에 추가
	TIMESTAMPDIFF(unit, datetime1, datetime2): 두 날짜/시간 간의 차이를 리턴.
6. 현재 시간 관련 함수
	UTC_DATE(): 현재 UTC 날짜를 리턴.
	UTC_TIME(): 현재 UTC 시간을 리턴.
	UTC_TIMESTAMP(): 현재 UTC 날짜와 시간을 리턴.
7. 날짜 및 시간 파트
	LAST_DAY(date): 주어진 월의 마지막 날짜를 리턴.
	QUARTER(date): 날짜가 속한 분기를 리턴. (1-4).
	WEEK(date, [mode]): 날짜가 속한 주 번호를 리턴. mode는 주의 시작일을 설정.
8. 날짜 및 시간의 파트 조합
	DATE(date): 날짜 부분만 리턴.
	TIME(time): 시간 부분만 리턴.
	TIMESTAMP(date, time): 날짜와 시간을 결합하여 리턴.
9. 현재 날짜 및 시간 포맷
	FORMAT(date, format): 날짜를 특정 포맷으로 리턴.
	TIME_FORMAT(time, format): 시간을 특정 포맷으로 리턴.
*/

###########시험 필수 함수 
/*
1. 집계 함수 (Aggregate Functions)
	COUNT(): 행의 개수
	SUM(): 합계
	AVG(): 평균
	MIN(): 최소값
	MAX(): 최대값
2. 문자열 함수 (String Functions)
	CONCAT(): 문자열 연결
	LENGTH(): 문자열 길이
	SUBSTRING(): 부분 문자열
	TRIM(): 공백 제거
	UPPER(): 대문자로 변환
	LOWER(): 소문자로 변환
	REPLACE(): 문자열 대체
	CHARINDEX(): 문자열 위치
3. 날짜 및 시간 함수 (Date and Time Functions)
	NOW(): 현재 날짜와 시간
	CURDATE(): 현재 날짜
	CURTIME(): 현재 시간
	DATEADD(): 날짜 간격 추가
	DATEDIFF(): 날짜 차이
	DATEPART(): 날짜의 특정 부분
	FORMAT(): 날짜 및 시간 형식화
4. 수학 함수 (Mathematical Functions)
	ROUND(): 반올림
	FLOOR(): 내림
	CEIL(): 올림
	ABS(): 절대값
	POWER(): 제곱
	SQRT(): 제곱근
5. 조건 함수 (Conditional Functions)
	CASE: 조건에 따른 값 반환
	IF(): 조건에 따른 값 반환
	NULLIF(): NULL 반환 또는 첫 번째 값
	COALESCE(): NULL이 아닌 첫 번째 값
6. 변환 함수 (Conversion Functions)
	CAST(): 데이터 유형 변환
	CONVERT(): 데이터 유형 변환
7. 기타 함수 (Miscellaneous Functions)
	GROUP_CONCAT(): 그룹 값 결합 (MySQL 전용)
	ROW_NUMBER(): 순번 매기기
	RANK(): 순위 매기기
	DENSE_RANK(): 순위 매기기 (중복 값 동일 순위)
*/