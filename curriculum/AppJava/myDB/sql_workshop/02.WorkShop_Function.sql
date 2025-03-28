USE mywork;
-- book 테이블을 활용한 윈도우 함수, 문자열 함수, 숫자 함수, 날짜 함수활용
-- 결과 캡처가 없을 수 있으며 결과는 별칭 및 속성 명 기준임

-- Q1. 책 가격이 높은 순서로 순위를 매겨 책 제목, 가격과 함께 출력하시오. (RANK 함수 활용)
SELECT TITLE, BOOK_AMT,
RANK() OVER ( ORDER BY BOOK_AMT DESC) AS price_rank
FROM BOOK;

-- Q2) 카테고리별로 대여 횟수 순위를 매겨 책 제목, 대여 횟수와 함께 출력하시오.
-- 풀이 1:
SELECT BK_IDX, CATEGORY, TITLE, RENT_CNT,
		DENSE_RANK() OVER (
        PARTITION BY CATEGORY
        ORDER BY RENT_CNT DESC
    )AS rent_rank
FROM BOOK;
-- 풀이 2:
SELECT BK_IDX, CATEGORY, TITLE, RENT_CNT,
       DENSE_RANK() OVER w AS rent_rank
FROM BOOK
WINDOW w AS (PARTITION BY CATEGORY ORDER BY RENT_CNT DESC);


-- Q3) 등록일 기준으로 가장 오래된 도서와 가장 최근 도서 제목을 각각 출력하시오.
-- (FIRST_VALUE, LAST_VALUE 함수 활용)
SELECT BK_IDX, TITLE, REG_DATE,
	FIRST_VALUE(TITLE) OVER (ORDER BY REG_DATE) AS oldest_book,
    LAST_VALUE(TITLE) OVER (ORDER BY REG_DATE
		ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS newest_book
FROM BOOK;

-- Q4) 카테고리별 평균 가격과 각 도서의 가격 차이를 계산하여 책 제목과 함께 출력하시오.
-- (AVG 함수 활용)
SELECT BK_IDX, CATEGORY, TITLE, BOOK_AMT,
	AVG(BOOK_AMT) OVER (PARTITION BY CATEGORY) AS avg_amt,
	BOOK_AMT - AVG(BOOK_AMT) OVER (PARTITION BY CATEGORY) AS diff_avg
FROM BOOK;
    
-- Q5) 카테고리별 총 대여 횟수를 계산하여 책 제목과 함께 출력하시오. (SUM 함수 활용)
SELECT BK_IDX, CATEGORY, TITLE, RENT_CNT,
	SUM(RENT_CNT) OVER (PARTITION BY CATEGORY) AS total_rent
FROM BOOK;

-- Q6) 책 제목을 대문자로 변환하여 출력하시오. (UPPER 함수 활용)
SELECT TITLE, UPPER(TITLE) AS upper_title
FROM BOOK;

-- Q7) 저자명이 '김'씨인 도서의 제목과 저자명을 출력하시오. (LEFT 함수 활용)
SELECT TITLE, AUTHOR
FROM BOOK
WHERE LEFT(TRIM(AUTHOR), 1) = '김';
    
-- Q8) 도서 설명(INFO)에서 'JAVA'라는 단어가 포함된 도서의 제목과 설명을 출력하시오.
-- (INSTR 함수 활용)
SELECT TITLE, INFO
FROM BOOK
WHERE INSTR(INFO, 'JAVA') > 0;
-- WHERE INSTR(INFO, '도') > 0;

-- Q9) 제목 길이가 10자 이상인 도서의 제목과 글자 수를 출력하시오. (CHAR_LENGTH 함수 활용)
SELECT TITLE, CHAR_LENGTH(TITLE) AS len
FROM BOOK
WHERE CHAR_LENGTH(TITLE) >= 10;

-- Q10) 도서 가격에 부가세(10%)를 추가한 금액을 계산하고, ₩ 기호가 붙은 통화 형식으로 변환하여 책 제목과 함께 출력하시오.
-- (FORMAT + CONCAT 문자열 함수 활용)
SELECT TITLE, BOOK_AMT,
	CONCAT("₩", FORMAT(BOOK_AMT * 1.1, 0)) AS price_with_tax
FROM BOOK;

-- Q11) 등록일로부터 현재까지 경과한 날짜를 계산하여 책 제목과 함께 출력하시오. (DATEDIFF 함수 활용)
SELECT TITLE, REG_DATE, DATEDIFF(NOW(), REG_DATE) AS days_passed
FROM BOOK;

-- Q12) 대여 횟수의 최대값과 각 도서의 대여 횟수 차이를 계산하여 책 제목과 함께 출력하시오. (MAX 함수 활용)
SELECT TITLE, RENT_CNT,
	MAX(RENT_CNT) OVER () - RENT_CNT AS diff_max_rent
FROM BOOK;

-- Q13) 저자명이 '이'로 시작하는 도서의 제목과 저자명을 출력하시오. (LEFT 함수 활용)
SELECT TITLE, AUTHOR
FROM BOOK
WHERE LEFT(TRIM(AUTHOR), 1) = '이';

-- Q14) 책 제목 중 'SQL'이 포함된 도서의 제목을 출력하시오. (LOCATE 함수 활용)
SELECT TITLE
FROM BOOK
WHERE LOCATE('SQL', TITLE) > 0;
-- WHERE LOCATE('MONEY', TITLE) > 0;

-- Q15) 도서 가격의 10%를 할인한 금액을 계산하여 책 제목과 함께 출력하시오. (ROUND 함수활용)
SELECT TITLE, BOOK_AMT,
	CONCAT("₩", ROUND(BOOK_AMT * 0.9, 0)) AS discounted_price
FROM BOOK;

-- Q16) 도서 가격을 천 단위로 절삭하여 책 제목과 함께 출력하시오. (FLOOR 함수 활용)
SELECT TITLE, FLOOR(BOOK_AMT) AS 천원
FROM BOOK;

-- Q17) 등록일에서 월만 추출하여 책 제목과 함께 출력하시오. (MONTH 함수 활용)
SELECT TITLE, REG_DATE, MONTH(REG_DATE) AS reg_month
FROM BOOK;

-- Q18) 도서 제목과 저자명을 연결하여 출력하시오. (CONCAT 함수 활용)
SELECT TITLE, AUTHOR, CONCAT(TITLE, " - ", AUTHOR) AS book_info
FROM BOOK;

-- UNSOLVED Q19) 대여가 한 번도 안 된 도서의 제목과 대여 횟수를 출력하시오. (IFNULL 함수 활용)
SELECT IFNULL(RENT_CNT, TITLE)
FROM BOOK;

-- Q20) 전체 도서의 총 권수와 각 도서의 제목을 함께 출력하시오. (COUNT() OVER() 활용)
SELECT TITLE,
	COUNT(TITLE) OVER()
FROM BOOK;

-- Q21) 대여 횟수가 많은 순으로 상위 3권의 책 제목과 대여 횟수를 출력하시오. (LIMIT 활용)
SELECT TITLE, RENT_CNT
FROM BOOK
ORDER BY RENT_CNT DESC
LIMIT 3;

-- Q22) 책 제목에서 공백을 제거한 결과를 출력하시오. (REPLACE 함수 활용)
SELECT TITLE, REPLACE(TITLE, " ", "") AS no_space_title
FROM BOOK;

-- Q23) 도서 가격의 제곱값을 계산하여 책 제목과 함께 출력하시오. (POWER 함수 활용)
SELECT TITLE, BOOK_AMT, POWER(BOOK_AMT, 2) AS price_squared
FROM BOOK;

-- Q24) 등록일의 요일을 계산하여 책 제목과 함께 출력하시오. (DAYNAME 함수 활용)
SELECT TITLE, REG_DATE, DAYNAME(REG_DATE) AS reg_weekday
FROM BOOK;

-- Q25) 대여 횟수를 기준으로 다음 도서의 대여 횟수를 함께 출력하시오. (LEAD 함수 활용)
SELECT TITLE, RENT_CNT, 
	LEAD(RENT_CNT) OVER (ORDER BY RENT_CNT) AS next_rent_cnt
FROM BOOK;

-- Q26) 도서 가격에 따라 가격 등급을 '고가', '중가', '저가'로 구분하여 책 제목과 함께 출력하시오. (CASE WHEN 활용)
SELECT TITLE, BOOK_AMT,
	CASE
		WHEN BOOK_AMT < 5 THEN '저가'
        WHEN BOOK_AMT < 10 THEN '중가'
        ELSE '고가'
	END AS pice_level
FROM BOOK;

-- Q27) 책 제목에서 괄호 ( )를 제거하고, 제목의 앞 5글자만 추출하여 출력하시오.
-- (REGEXP_REPLACE와 SUBSTRING 함수 활용)
SELECT TITLE, SUBSTRING(REGEXP_REPLACE(TITLE, '[()]', ''), 1, 5) AS short_title
FROM BOOK;

USE mywork;
-- Q28) 등록일 기준으로 누적 도서 수를 계산하여 책 제목과 함께 출력하시오. (COUNT + 윈도우 함수 활용)
SELECT TITLE, REG_DATE,
	COUNT(*) OVER (ORDER BY REG_DATE 
    ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS cumulative_count
FROM BOOK;
	

-- Q29) 저자명이 NULL인 도서의 제목과 저자명을 출력하시오. (IS NULL 활용)
SELECT TITLE, AUTHOR
FROM BOOK
WHERE AUTHOR IS NULL;

-- Q30) 대여 횟수 순위를 매겨 동일 값이면 같은 순위로 책 제목과 함께 출력하시오. (RANK 함수 활용)
SELECT TITLE, RENT_CNT,
		DENSE_RANK() OVER (
        ORDER BY RENT_CNT DESC
    )AS rent_rank
FROM BOOK;