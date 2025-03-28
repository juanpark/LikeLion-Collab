USE MYWORK;

SELECT *
FROM BOOK;

-- 1. 게시판에서 사용자 ID, 등록 날짜, 게시판 제목, 내용을 조회하세요.
SELECT USER_ID, REG_DATE, TITLE, CONTENT
FROM BOARD;

-- 2. 사용자 ID, 등급, 게시판 제목, 내용을 조회하되, 삭제되지 않은 게시글만 조회하세요.
SELECT USER_ID, REG_DATE, TITLE, CONTENT
FROM BOARD
WHERE IS_DEL = 0;

-- 3. 사용자 ID, 역할, 게시판 제목, 내용을 조회하되, Socrates가 작성한 게시글만 조회하세요.
SELECT USER_ID, GRADE, TITLE, CONTENT
FROM MEMBER
JOIN BOARD USING (USER_ID)
WHERE USER_ID = 'SOCRATES';

-- 4. 2023년 12월에 탈퇴한 회원들의 회원 아이디(User ID), 이메일(Email), 그리고 회원 등급(Grade)을 조회하세요.
SELECT USER_ID, EMAIL, GRADE
FROM MEMBER_INFO
JOIN MEMBER USING (USER_ID)
WHERE LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';

-- 5. 회원들 중에서 '디디의 우산 :황정은 연작소설'를 대출한 이력이 있는 회원의 회원 아이디(User ID),대출 도서 수를 조회하세요.
SELECT USER_ID, RENT_BOOK_CNT
FROM RENT_MASTER
WHERE TITLE LIKE '디디의 우산%';

-- 6. 대출 도서 중에서 등록일이 2023년 6월 10일 이후인 도서의 대출 번호(Rent Master Index),
-- 대출자 이름(User ID), 대출자 가입일자, 대출건 제목(Title)을 조회하세요.
SELECT RM_IDX, USER_ID, MEMBER_INFO.REG_DATE, TITLE
FROM RENT_MASTER
JOIN MEMBER_INFO USING (USER_ID)
WHERE RENT_MASTER.REG_DATE > '2023-06-10';

-- 7. 대출 번호, 대출자 이름, 대출건 제목, 그리고 대출일자를 조회하세요. 단, 대출 도서가 모두
-- 반납되지 않았고, 회원 등급이 'ROLE_USER'인 회원만 포함시켜주세요.
SELECT RM_IDX, USER_ID, TITLE, REG_DATE
FROM RENT_MASTER
JOIN MEMBER USING (USER_ID)
WHERE IS_RETURN = 0 AND GRADE = 'ROLE_USER';

-- 8. 도서를 2권 이상 대출한 회원들의 회원 아이디, 이메일, 그리고 대출도서 수를 조회하세요.
SELECT USER_ID, EMAIL, RENT_BOOK_CNT
FROM RENT_MASTER
JOIN MEMBER USING (USER_ID)
WHERE RENT_BOOK_CNT >= 2;

-- 9. 대출 도서 중에서 대출일로부터 3일 이내에 반납을 완료한 도서의 대출도서번호, 대출자 이름,
-- 도서 제목, 반납일자를 조회하세요.
SELECT RB_IDX, USER_ID, TITLE,RETURN_DATE 
FROM RENT_BOOK
JOIN RENT_MASTER USING (RM_IDX)
WHERE DATEDIFF(RETURN_DATE, RENT_BOOK.REG_DATE) <= 3;

/*
SELECT RENT_BOOK.REG_DATE, RETURN_DATE, DATEDIFF(RENT_BOOK.REG_DATE, RETURN_DATE)
FROM RENT_BOOK
JOIN RENT_MASTER USING (RM_IDX); -- 모두 음수, 즉 반납일을 앞, 대출일을 뒤에 두어야 정상적으로 대출한 날짜. 계산 가능

SELECT RENT_BOOK.REG_DATE, RETURN_DATE, DATEDIFF(RETURN_DATE, RENT_BOOK.REG_DATE)
FROM RENT_BOOK
JOIN RENT_MASTER USING (RM_IDX);
*/

-- 10. 탈퇴하지 않은 회원 중에서 도서를 가장 많이 대출한 회원의 아이디, 이메일, 대출도서 수를 조회하세요.
SELECT USER_ID, EMAIL, RENT_BOOK_CNT
FROM MEMBER
JOIN RENT_MASTER USING (USER_ID)
WHERE IS_LEAVE = 0
ORDER BY RENT_BOOK_CNT DESC
LIMIT 1;

-- 11. 대출 도서 중에서 ‘연체’ 상태인 도서의 대출 번호, 대출자 아이디, 대출건 제목, 대출일 대출
-- 도서 상태를 조회하세요.
SELECT DISTINCT RM.RM_IDX, RM.USER_ID, RM.TITLE, RB.REG_DATE, C.INFO
FROM RENT_MASTER RM
JOIN RENT_BOOK RB USING (RM_IDX)
JOIN CODE C ON (RB.STATE = C.CODE)
WHERE INFO = '연체'; 

-- 12. 대출 도서 중에서 ‘반납' 상태이면서 반납일자가 ‘2023-06-15’ 이전인 도서의 대출 도서 번호,
-- 대출자 이름, 대출 도서 제목, 그리고 반납일자를 조회하세요.
SELECT RM.RM_IDX, RM.USER_ID, RM.TITLE, RB.RETURN_DATE, C.INFO
FROM RENT_MASTER RM
JOIN RENT_BOOK RB USING (RM_IDX)
JOIN CODE C ON (RB.STATE = C.CODE)
WHERE C.INFO = '반납' AND RB.RETURN_DATE > '2023-06-15';
-- WHERE RB.RETURN_DATE < '2023-06-15';
-- WHERE C.INFO = '연체' AND RB.RETURN_DATE < '2023-06-15';

-- 13. 회원 등급이 'ROLE_USER'이면서 대출을 한 이력이 남아있고, 대출도서를 연체한 이력이 없
-- 는 회원들의 회원 아이디(User ID), 이메일(Email)을 조회하세요.
SELECT USER_ID, EMAIL, INFO, GRADE
FROM MEMBER
JOIN RENT_MASTER RM USING (USER_ID)
JOIN RENT_BOOK RB USING (RM_IDX)
JOIN CODE C ON (C.CODE = RB.STATE)
WHERE GRADE = 'ROLE_USER' AND INFO != '연체';

-- 14. 대출 도서 중에서 'RE01' 상태인 도서 중에 가장 빨리 대출된 도서의 대출 번호, 대출자 아이디, 
-- 대출 도서 제목 그리고 대출일자를 조회하세요.
SELECT DISTINCT RM.RM_IDX, USER_ID, TITLE, RM.REG_DATE, STATE
FROM RENT_MASTER RM
JOIN RENT_BOOK RB ON (RM.RM_IDX)
WHERE STATE = 'RE01'
ORDER BY RM.REG_DATE
LIMIT 1;

-- 15. 도서가 존재하는 도서 카테고리별 도서 재고의 합을 조회 하시오.
SELECT CATEGORY, C.INFO, SUM(BOOK_AMT) AS '도서재고량'
FROM BOOK B
JOIN CODE C ON (C.CODE = B.CATEGORY)
GROUP BY CATEGORY;

-- 16. 도서카테고리의 하위 카테고리인 문학카테고리에 속하는 모든 카테고리를 조회 하시오.
SELECT C.CODE, C.UPPER_CODE, C.INFO, P.CODE, P.UPPER_CODE, P.INFO
FROM CODE C
JOIN CODE P ON C.UPPER_CODE = P.CODE
WHERE P.CODE = 'B0';
-- WHERE C IS CHILD CODE, AND P IS PARENT CODE

-- 17. 회원 중에서 마지막 로그인 일자가 2023년 12월인 가진 회원이 대출한 대출도서건수를 조회하시오.
SELECT MI.USER_ID, RENT_BOOK_CNT, LOGIN_DATE
FROM MEMBER_INFO MI
JOIN RENT_MASTER RM USING (USER_ID)
WHERE LOGIN_DATE BETWEEN '2023-12-1' AND '2023-12-31';

-- 18. 대출 중인 책 중에서 연체 상태인 책의 수를 조회하세요.
SELECT COUNT(STATE) AS OVERDUE_COUNT
FROM RENT_MASTER RM
JOIN RENT_BOOK RB USING (RM_IDX)
JOIN CODE C ON (RB.STATE = C.CODE)
WHERE C.INFO = '연체';

-- 18번 검증
SELECT STATE, INFO, TITLE, RENT_BOOK_CNT
FROM RENT_MASTER RM
JOIN RENT_BOOK RB USING (RM_IDX)
JOIN CODE C ON (RB.STATE = C.CODE)
WHERE C.INFO = '연체';

-- 19. 모든 도서 카테고리의 도서 재고 합을 구하시오.
SELECT SUM(BOOK_AMT) AS 도서재고, C.INFO
FROM BOOK B
JOIN CODE C ON (B.CATEGORY = C.CODE)
GROUP BY CATEGORY;

-- 20. 모든 도서의 제목과 카테고리, 상위카테고리를 조회 하시오.
SELECT TITLE, C.INFO AS 카테고리, P.INFO AS '상위 카테고리'
FROM BOOK B
JOIN CODE C ON (B.CATEGORY = C.CODE)
JOIN CODE P ON (C.UPPER_CODE = P.CODE);
-- WHERE C IS CHILD CODE, AND P IS PARENT CODE