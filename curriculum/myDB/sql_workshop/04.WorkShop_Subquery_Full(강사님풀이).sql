use mywork;
-- Q1. 2023년 6월 18일에 대출된 도서의 제목을 조회합니다.
SELECT TITLE FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE REG_DATE = '2023-06-18');

-- Q2. 2023년 6월 30일에 반납된 도서의 작가를 조회합니다.
SELECT AUTHOR FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE RETURN_DATE = '2023-06-30');

-- Q3. 2023년 6월 28일에 대출되고 RENT_CNT가 1보다 큰 도서의 제목을 조회합니다.
SELECT TITLE FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE REG_DATE = '2023-06-28' AND RENT_CNT > 1);

-- Q4. 연체상태(RE01)인 대출도서의 카테고리를 조회합니다.
SELECT DISTINCT CATEGORY FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE STATE = 'RE01');

-- Q5. 대출일과 반납일이 동일한 도서의 제목을 조회합니다.
SELECT TITLE FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE REG_DATE = RETURN_DATE);

-- Q6. 2023년 6월 7일에 대출되고 6월 11일에 반납된 도서의 작가를 조회합니다.
SELECT AUTHOR FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE REG_DATE = '2023-06-07' AND RETURN_DATE = '2023-06-11');

-- Q7. 2023년 6월 15일에 대출된 도서의 제목을 조회합니다.
SELECT TITLE FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE REG_DATE = '2023-06-15');

-- Q8. 2023년 6월 30일에 대출된 도서들 중 누적 대출 횟수가 가장 적은 책 제목을를 조회합니다.
SELECT TITLE FROM book
WHERE BK_IDX IN (SELECT BK_IDX FROM rent_book WHERE RETURN_DATE = '2023-06-30')
ORDER BY RENT_CNT LIMIT 1;

SELECT TITLE 
FROM book 
WHERE BK_IDX = (
    SELECT BK_IDX 
    FROM rent_book 
    WHERE RETURN_DATE = '2023-06-30'
    ORDER BY RENT_CNT ASC 
    LIMIT 1
);


-- Q9. 2023년 6월에 대출되고 누적 대출 횟수가 평균보다 작은 도서의 제목과 대출 횟수를 조회합니다.
SELECT TITLE, RENT_CNT FROM book
WHERE BK_IDX IN (
    SELECT BK_IDX FROM rent_book
    WHERE REG_DATE BETWEEN '2023-06-01' AND '2023-06-30'
) AND RENT_CNT < (SELECT AVG(RENT_CNT) FROM BOOK);

-- Q10. 연체 상태인 대출도서의 식별자와 상태를 조회합니다.
SELECT DISTINCT BK_IDX, (SELECT CODE FROM code WHERE INFO = '연체') AS 상태 
FROM rent_book
WHERE STATE = (SELECT CODE FROM code WHERE INFO = '연체');

-- Q11. 사용자가 작성한 게시글 중에서 가장 긴 글의 제목과 글자 수를 조회합니다.
SELECT TITLE, LENGTH(CONTENT) AS CONTENT_LENGTH 
FROM board
WHERE LENGTH(CONTENT) = (SELECT MAX(LENGTH(CONTENT)) FROM board);

-- Q12. 게시글을 가장 많이 작성한 사용자의 이름과 작성된 게시글 수를 조회합니다.
SELECT USER_ID, ( 
    SELECT COUNT(BD_IDX) 
    FROM board 
    WHERE USER_ID = member.USER_ID 
) AS POST_COUNT 
FROM member 
ORDER BY POST_COUNT DESC 
LIMIT 1;

-- Q13. 가장 최근에 작성된 게시글의 제목과 작성일을 조회합니다.
SELECT TITLE, REG_DATE 
FROM board
WHERE REG_DATE = (SELECT MAX(REG_DATE) FROM board);

-- Q14. 가장 오래된 사용자의 이름과 등록일을 조회합니다.
SELECT USER_ID, REG_DATE 
FROM member_INFO
WHERE REG_DATE = (SELECT MIN(REG_DATE) FROM member_INFO);

-- Q15. 평균 게시글 길이가 가장 긴 사용자의 이름과 평균 게시글 길이 조회 합니다. 
SELECT USER_ID, AVG_LENGTH 
FROM ( 
    SELECT USER_ID, AVG(LENGTH(CONTENT)) AS AVG_LENGTH
    FROM board 
    GROUP BY USER_ID 
    ORDER BY AVG_LENGTH DESC 
    LIMIT 1
) AS LongestPostUser;

-- Q16. 게시글을 가장 많이 작성한 사용자의 이름과 게시글 수 조회합니다.
SELECT USER_ID, POST_COUNT 
FROM ( 
    SELECT USER_ID, COUNT(*) AS POST_COUNT
    FROM board 
    GROUP BY USER_ID 
    ORDER BY POST_COUNT DESC 
    LIMIT 1
) AS MostActiveUser;

-- Q17. 각 사용자별로 작성한 게시글 수와 함께 모든 사용자 아이디를 게시글 수를 내림차순으로 정렬하여 조회 하시오.
SELECT user_id, (
    SELECT COUNT(*) 
    FROM board 
    WHERE USER_ID = M.USER_ID
) AS POST_COUNT
FROM member M 
ORDER BY POST_COUNT DESC;

-- Q18. 카테고리가 수필인 도서의 도서 재고 합을 구합니다.
SELECT SUM(BOOK_AMT) AS '카테고리수필도서권수'
FROM book 
WHERE CATEGORY = (SELECT CODE FROM code WHERE INFO = '수필');

-- Q19. 가장 최근에 가입한 회원의 이름과 가입 일자 조회합니다.
SELECT USER_ID, REG_DATE
FROM member_info
WHERE REG_DATE = (SELECT MAX(REG_DATE) FROM member_info);

-- Q20. 가장 먼저 탈퇴한 사용자가 작성한 게시물 중 가장 조회수가 높은 게시글의 작성자, 게시글, 조회수를 조회 합니다.
SELECT USER_ID, CONTENT, VIEW_CNT 
FROM board 
WHERE USER_ID = (
    SELECT USER_ID 
    FROM member_info
    WHERE LEAVE_DATE IS NOT NULL 
    ORDER BY LEAVE_DATE ASC 
    LIMIT 1
)
ORDER BY VIEW_CNT DESC 
LIMIT 1;
