########## 숫자 함수  ###########
/*
ROUND(숫자, 자릿수)	반올림 (자릿수 생략하면 정수로 반올림)	ROUND(123.456, 2) ➔ 123.46
TRUNCATE(숫자, 자릿수)	버림 (반올림X, 자릿수까지 표시)	TRUNCATE(123.456, 2) ➔ 123.45
CEIL(숫자)	무조건 올림	CEIL(4.1) ➔ 5
FLOOR(숫자)	무조건 내림	FLOOR(4.9) ➔ 4
ABS(숫자)	절대값	ABS(-10) ➔ 10
MOD(숫자, 나누는수)	나머지	MOD(10, 3) ➔ 1
DIV	몫 계산	10 DIV 3 ➔ 3
POWER(숫자, 제곱수)	거듭제곱	POWER(3, 2) ➔ 9
SQRT(숫자)	제곱근 계산	SQRT(25) ➔ 5
LOG(숫자)	자연로그 (밑 e)	LOG(100) ➔ 4.60517
LOG10(숫자)	밑 10 로그	LOG10(1000) ➔ 3
RAND()	0~1 사이 임의 난수	RAND() ➔ 0.3456
IFNULL(컬럼, 대체값)	NULL 처리	IFNULL(COMM, 0)
SUM() OVER()	윈도우 함수로 전체 합계 계산	SAL / SUM(SAL) OVER()
FORMAT(숫자, 자릿수)	숫자를 천 단위 콤마 포함해서 포맷팅	FORMAT(1234567.89, 2) ➔ 1,234,567.89
*/



USE MY_EMP;

-- Q1. 사원의 봉급(SAL)에 대해 15%의 세금을 적용한 후, 소수점 이하 두 자리에서 반올림하여 실수령액을 출력하자.
-- ex): 850.00 -> 722.50
SELECT ENAME, SAL, ROUND(SAL * 0.85, 2) AS "실수령액"
FROM EMP;

-- Q2. 사원의 봉급(SAL)을 두 배로 증가시킨 후, 결과를 500 단위로 반올림하여 출력하자.
-- ex): 800 -> 2000, 750 -> 1500
SELECT ENAME, SAL, ROUND(SAL * 2, -3) AS RES
FROM EMP;

-- Q3. 사원의 봉급(SAL)을 기준으로 소수점 이하 3자리까지만 표시하여 출력하자.
-- ex): 1234.56789 -> 1234.568
SELECT ENAME, SAL, ROUND(SAL, 3) AS RES
FROM EMP;

-- Q4. 사원의 봉급(SAL)과 커미션(COMM)을 더한 후, 소수점 이하를 모두 버리고 정수로 출력하자.
-- ex): 봉급 1500, 커미션 200.75 -> 1700
SELECT ENAME, SAL, COMM, FLOOR(SAL + IFNULL(COMM, 0)) AS RES
FROM EMP;

-- Q5. 사원의 봉급(SAL)을 음수로 변환한 후, 다시 양수로 변환하여 출력하자.
-- ex): 1200 -> -1200 -> 1200
SELECT ENAME, -SAL AS "봉급(음수)", ABS(-SAL) AS "절대값"
FROM EMP;

-- Q6. 사원의 봉급(SAL)을 50으로 나눈 후, 나머지가 0인 사원만 필터링하여 출력하자.
-- ex): 봉급 1000 -> 출력, 봉급 1025 -> 필터링
SELECT ENAME, SAL, MOD(SAL, 50) AS "50으로 나눈 나머지"
FROM EMP
WHERE MOD(SAL, 50) = 0;

-- Q7. 사원의 봉급(SAL)에서 최대값과 최소값의 차이를 계산하여 출력하자.
-- ex): 최대 봉급 3000, 최소 봉급 800 -> 2200
SELECT MAX(SAL) - MIN(SAL) AS "봉급 차이"
FROM EMP
WHERE JOB != 'PRESIDENT';

-- Q8. 사원의 봉급(SAL)에 대해 20% 인상된 금액과 10% 감소된 금액의 차이를 계산하여 출력하자.
-- ex): 봉급 1000 -> (1000 * 1.2) - (1000 * 0.9) = 1200 - 900 = 300
SELECT ENAME, SAL, (SAL * 1.2) - (SAL * 0.9) AS RES
FROM EMP;

-- Q9. 사원의 봉급(SAL)을 기준으로 1000 단위로 올림한 값을 출력하자.
-- ex): 봉급 1750 -> 2000
SELECT ENAME, SAL, CEIL(SAL / 1000) * 1000 AS "봉급 천 단위"
FROM EMP;

-- Q10. 사원의 봉급(SAL)에서 300을 빼고, 그 결과를 5로 나눈 나머지를 출력하자.
-- ex): 봉급 1500 -> (1500 - 300) % 5 = 1200 % 5 = 0
SELECT ENAME, SAL, (SAL - 300) AS SAL_300, MOD(SAL - 300, 5) AS "나머지"
FROM EMP;

-- Q11. 사원의 봉급(SAL)에 임의의 소수를 더하고, 그 결과를 2로 나누어 반올림하여 출력하자.
-- ex): 봉급 1500 + 0.25 -> (1500.25 / 2) = 750.125 -> 750
SELECT ENAME, SAL, SAL + RAND() AS RAND_SAL, ROUND((SAL + RAND()) / 2) AS RES
FROM EMP;

-- Q12. 사원의 봉급(SAL)과 커미션(COMM)을 더한 후, 이 금액이 2000 이상인 사원들만 필터링하여 출력하자.
-- ex): 봉급 1800, 커미션 300 -> 2100 -> 출력
SELECT SAL, COMM, SAL + IFNULL(COMM, 0) AS RES
FROM EMP
WHERE SAL + IFNULL(COMM, 0) >= 2000;

-- Q13. 사원의 봉급(SAL)에서 100 단위로 절사하여 출력하자.
-- ex): 봉급 1750 -> 1700
SELECT ENAME, SAL, TRUNCATE(SAL, -2) AS RES
FROM EMP;

-- Q14. 사원의 봉급(SAL)을 제곱하여 출력하되, 결과가 1,000,000 이하인 경우에만 출력하자.
-- ex): 봉급 800 -> 640000, 봉급 1200 -> 필터링
SELECT SAL, POWER(SAL, 2) AS "봉급 제곱"
FROM EMP
WHERE POWER(SAL, 2) <= 1000000;

-- Q15. 사원의 봉급(SAL)의 로그 값을 구하고, 이를 소수점 둘째 자리에서 반올림하여 출력하자.
-- ex): 봉급 1000 -> LOG(1000) = 6.91
SELECT SAL, LOG(SAL) AS "LOG 봉급", ROUND(LOG(SAL), 2) AS "반올림 값"
FROM EMP;

-- Q16. 사원의 봉급(SAL)을 로그10으로 계산한 후, 그 결과를 3으로 곱하여 출력하자.
-- ex): 봉급 1000 -> LOG10(1000) * 3 = 3 * 3 = 9
SELECT SAL, LOG10(SAL) AS "로그10 봉급", LOG10(SAL) * 3 AS RES
FROM EMP;

-- Q17. 사원의 봉급(SAL)을 25로 나눈 몫과 나머지를 함께 출력하자.
-- ex): 봉급 1000 -> 몫: 40, 나머지: 0
SELECT SAL, SAL DIV 25 AS 몫, MOD(SAL, 25) AS "나머지"
FROM EMP;

-- Q18. 사원의 봉급(SAL)에 7%를 곱하고, 그 결과에서 3을 더하여 출력하자.
-- ex): 봉급 1000 -> (1000 * 0.07) + 3 = 70 + 3 = 73
SELECT SAL, SAL * 0.07 + 3 AS RES
FROM EMP;

-- Q19. 사원의 봉급(SAL)을 반올림하지 않고 소수점 셋째 자리에서 내림한 후, 그 결과를 절대값으로 변환하여 출력하자.
-- ex): 봉급 1234.5678 -> 1234.567
SELECT SAL, ABS(TRUNCATE(SAL, 3)) AS "절대값"
FROM EMP;

-- Q20. 사원의 봉급(SAL)을 기준으로 각 사원의 봉급을 전체 봉급 합계의 비율로 계산하여 출력하자.
-- ex): 봉급 1000, 전체 합계 10000 -> 1000 / 10000 = 0.1
SELECT SAL, SAL / SUM(SAL) OVER() AS "비율"
FROM EMP;

-- Q21. 사원의 봉급(SAL)의 제곱근을 구한 후, 이 값을 100 단위로 반올림하여 출력하자.
-- ex): 봉급 2500 -> SQRT(2500) = 50 -> 100 단위 반올림 = 100
SELECT SAL, SQRT(SAL) AS "제곱근", ROUND(SQRT(SAL), -2) AS "100단위 반올림"
FROM EMP;

-- Q22. 사원의 봉급(SAL)을 3으로 나눈 결과를 출력하되, 소수점 이하를 모두 표시하도록 설정하자.
-- ex): 봉급 1000 -> 1000 / 3 = 333.3333
SELECT SAL,
    ROUND(SAL / 3, 4) AS "3으로 나눈 값"
FROM EMP;

-- Q23. 사원의 봉급(SAL)을 내림하여 출력하되, 내림 후의 값이 2000 이하인 경우에만 출력하자.
-- ex): 봉급 1999.99 -> 1999, 봉급 2001.25 -> 필터링
SELECT SAL, FLOOR(SAL) AS "내림 봉급"
FROM EMP
WHERE FLOOR(SAL) <= 2000;

-- Q24. 사원의 봉급(SAL)에서 소수점 이하 첫째 자리를 버리고 두 번째 자리까지만 남겨 출력하자.
-- ex): 봉급 1234.567 -> 1234.56
SELECT SAL, TRUNCATE(SAL, 2) AS RES
FROM EMP;

-- Q25. 사원의 봉급(SAL)을 기준으로 가장 작은 두 자리 숫자를 만들어 출력하자.
-- ex): 봉급 1234 -> MOD(1234, 100) = 34
SELECT SAL,
    CASE 
        WHEN MOD(SAL, 100) < 10 THEN CONCAT('0', MOD(SAL, 100))
        ELSE MOD(SAL, 100)
    END AS RES
FROM EMP;

###########################################################################
/*
TRUNCATE  -  반올림이나 올림없이 단순히 숫자의 소숫점 이하 자릿수를 잘라낸다  
            숫자를 소숫점 이하의 특정 자리까지만 유지하고 나머지는 잘라낼때 사용
            
ROUND  - 숫자를 반올림하여 가장 가까운 정수 또는 지정된 소숫점 자리로 만든다.  

CEIL   -  소숫점 이하 자리수가 있는 숫자를 항상 올림하여 가장 가까운 큰수로 만들어 준다.  

*/
 SELECT  TRUNCATE(4.567, 2); # 4.56
 SELECT  TRUNCATE(4.567, 0); # 4
 SELECT  TRUNCATE(-3.958, 2); # - 3.95

 SELECT  CEIL(4.567); # 올림해서 5를 리턴  
 SELECT  CEIL(4.567, 0); #    -- 오류난다.  
 SELECT  CEIL(-3.958, 2); #    -- 오류난다.  
 
 HELP CEIL;

#123, 123,5,  123.45,  123.450  -> 입력된 값에 3번째 자리가 없으므로 결과가 입력값으로 출력된다.  
SELECT ROUND(123.45) , ROUND(123.45 , 1 ), ROUND(123.45 , 2), ROUND(123.45, 3) ; 




