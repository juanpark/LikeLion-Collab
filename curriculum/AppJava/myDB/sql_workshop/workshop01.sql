USE mywork;


-- 1. 대출 횟수가 20회 이상인 도서들의 식별번호, isbn, 제목, 대출횟수 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, RENT_CNT
FROM BOOK
WHERE RENT_CNT >= 20;

-- 2. 등록일이 2020년 6월 20일 이후인 도서의 식별번호, isbn, 제목, 등록일자 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, REG_DATE
FROM BOOK
WHERE REG_DATE > '2020-06-20';

-- 3. 카테고리가 'B001'이고 대출 횟수가 8회인 도서의 식별번호, isbn, 제목, 대출횟수 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, RENT_CNT
FROM BOOK
WHERE CATEGORY = 'B001' AND RENT_CNT = 8;

-- 4. 저자가 '혜민'인 도서들의 도서들의 식별번호, isbn, 제목, 저자 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, AUTHOR
FROM BOOK
WHERE AUTHOR LIKE '%혜민%';

-- 5. 도서 제목에 '소설'이 포함된 도서들의 제목 정보를 조회하세요.
SELECT TITLE
FROM BOOK
WHERE TITLE LIKE '%소설%';

-- 6. 등록일이 2020년 4월 15일 이전이고 대출 횟수가 10회 이하인 도서들의 식별번호, isbn, 제목, 저자, 등록일, 대출횟수 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, AUTHOR, REG_DATE, RENT_CNT
FROM BOOK
WHERE REG_DATE < '2020-04-15' AND RENT_CNT <= 10;

-- 7. 도서 제목이 '나는'으로 시작하는 도서들의 식별번호, isbn, 제목, 저자, 등록일, 대출횟수 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, AUTHOR, REG_DATE, RENT_CNT
FROM BOOK
WHERE TITLE REGEXP '^나는';

-- 8. 도서 카테고리별 평균 대출건수와 총 대출건수 조회하세요.
SELECT CATEGORY, AVG(RENT_CNT) AS '평균 대출건수', SUM(RENT_CNT) AS '총 대출건수'
FROM BOOK
GROUP BY CATEGORY;

-- 9. 가장 대출 횟수가 많은 도서 5권의 식별번호, isbn, 제목, 저자, 등록일, 대출횟수 정보를 조회하세요.
SELECT BK_IDX, ISBN, TITLE, AUTHOR, REG_DATE, RENT_CNT
FROM BOOK
ORDER BY RENT_CNT DESC
LIMIT 5;

-- 10. 도서 카테고리가 B002인 도서의 식별번호, isbn, 카테고리, 제목, 저자, 등록일정보를 등록일자 순으로 내림차순으로 조회하세요.
SELECT BK_IDX, ISBN, CATEGORY, TITLE, AUTHOR, REG_DATE
FROM BOOK
WHERE CATEGORY = 'B002'
ORDER BY REG_DATE DESC;

-- 11. 회원 등급이 ROLE_USER 인 회원을 이름으로 오름차순 정렬하여 조회하세요.
SELECT *
FROM MEMBER
WHERE GRADE = 'ROLE_USER'
ORDER BY USER_ID;

-- 12. 등급이 'ROLE_ADMIN'인 사용자 중 탈퇴하지 않은 사용자만 조회하세요.
SELECT *
FROM MEMBER
WHERE GRADE ='ROLE_ADMIN' AND IS_LEAVE = 0;

-- 13. 등급 별 사용자 수를 조회하세요.
SELECT GRADE, COUNT(GRADE)
FROM MEMBER
GROUP BY GRADE;

-- 14. 등급이 'ROLE_USER'이고 전화번호가 9로 끝나는 회원을 조회하세요.
SELECT *
FROM MEMBER
WHERE GRADE = 'ROLE_USER' AND TELL REGEXP '9$';

-- 15. 퇴사하지 않은 사용자 중에서 등급이 'ROLE_ ADMIN' 인 사용자의 이메일 조회 (알파벳 순)
SELECT EMAIL
FROM MEMBER
WHERE GRADE = 'ROLE_ADMIN' AND IS_LEAVE = 0
ORDER BY EMAIL;

-- 16. 등급이 'ROLE_USER'이면서 퇴사하지 않은 사용자 중에서 전화번호의 4번째 숫자가 2이고 id가 E로 시작하는 사용자를 구하시오
SELECT *
FROM MEMBER
WHERE GRADE = 'ROLE_USER' AND TELL LIKE '___-2%' AND USER_ID REGEXP '^E';
-- WHERE GRADE = 'ROLE_USER' AND TELL LIKE '___-2%';
-- WHERE GRADE = 'ROLE_USER' AND USER_ID REGEXP '^E';

-- 17. 게시글 중에서 "철학" 단어를 포함하는 것만 조회: 제목이나 내용에 "철학" 단어를 포함하는 게시글을 조회하세요.
SELECT *
FROM BOARD
WHERE CONTENT LIKE '%철학%';

-- 18. 게시글 중에서 뷰 수가 높은 순으로 정렬하여 상위 10개만 조회: 뷰 수가 높은 순으로 정렬하여 상위 10개의 게시글만 조회하세요.
SELECT *
FROM BOARD
ORDER BY VIEW_CNT DESC
LIMIT 10;

-- 19. 게시글 중에서 조회수가 700 이상이고 작성자가 "Socrates"인 것만 조회
SELECT *
FROM BOARD
WHERE USER_ID = 'SOCRATES' AND VIEW_CNT >= 700;

-- 20. 도서의 식별번호, 제목, 저자, 대분류를 조회하시오.
-- 카테고리가 'B0' 으로 시작하는 도서는 대분류를 ‘문학’으로, 카테고리가 'B1'로 시작하는 도서는
-- 대분류를 ‘전문서적’으로 표시하시오
SELECT BK_IDX, TITLE, AUTHOR,
CASE
	WHEN CATEGORY LIKE 'B0%' THEN '문학'
	WHEN CATEGORY LIKE 'B1%' THEN '전문서적'
END AS 대분류
FROM BOOK;

-- 21. 대출상태가 'RE01' 인 대출도서 정보를 조회하시오.
SELECT *
FROM RENT_BOOK
WHERE STATE = 'RE01';

-- 22. 대출도서가 2권 이상인 대출 건 제목을 조회하시오.
SELECT TITLE
FROM RENT_MASTER
WHERE RENT_BOOK_CNT >= 2;

-- 23. 2020년 6월 25일 ~ 30일 사이에 입고된 도서의 식별번호, isbn, 제목, 등록일자 정보를 조회하시오.
SELECT BK_IDX, ISBN, TITLE, REG_DATE
FROM BOOK
WHERE REG_DATE BETWEEN '2020-06-25' AND '2020-06-30';

-- 24. 2023년 12월에 탈퇴한 사용자를 조회하시오.
SELECT *
FROM MEMBER_INFO
WHERE LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';






