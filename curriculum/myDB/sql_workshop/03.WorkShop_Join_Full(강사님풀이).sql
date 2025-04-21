USE MYWORK;

-- Q1. 게시판에서 사용자 ID, 등록 날짜, 게시판 제목, 내용을 조회하세요.
SELECT USER_ID, REG_DATE, TITLE, CONTENT
FROM member
JOIN board USING(USER_ID);

-- Q2. 사용자 ID, 등급, 게시판 제목, 내용을 조회하되, 삭제되지 않은 게시글만 조회하세요.
SELECT USER_ID, grade, TITLE, CONTENT
FROM member
JOIN board USING(USER_ID)
WHERE IS_DEL = 0;

-- Q3. 사용자 ID, 역할, 게시판 제목, 내용을 조회하되, Socrates가 작성한 게시글만 조회하세요.
SELECT USER_ID, grade, TITLE, CONTENT
FROM member
JOIN board USING(USER_ID)
WHERE USER_ID = 'Socrates';

-- Q4. 2023년 12월에 탈퇴한 회원들의 회원 아이디(User ID), 이메일(Email), 그리고 회원 등급(Grade)을 조회하세요.
SELECT USER_ID, EMAIL, grade
FROM member
JOIN member_info USING(USER_ID)
WHERE member_info.LEAVE_DATE BETWEEN '2023-12-01' AND '2023-12-31';

-- Q5. '디디의 우산 :황정은 연작소설'을 대출한 회원의 ID와 대출 도서 수를 조회하세요.
SELECT USER_ID, COUNT(BK_IDX) AS 대출횟수
FROM member
JOIN rent_master USING(USER_ID)
JOIN rent_book USING(RM_IDX)
JOIN book USING(BK_IDX)
WHERE book.TITLE = '디디의 우산 :황정은 연작소설'
GROUP BY member.USER_ID;

-- Q6. 2023년 6월 10일 이후 등록된 도서를 대출한 건의 번호, 사용자 ID, 가입일자, 제목을 조회하세요.
SELECT DISTINCT RM.RM_IDX, RM.USER_ID, MI.REG_DATE, RM.TITLE
FROM rent_master RM
JOIN member_info MI USING(USER_ID)
WHERE RM.REG_DATE >= '2023-06-10';


-- Q7. 반납하지 않은 대출 건 중, 회원 등급이 'ROLE_USER'인 경우의 대출 번호, 사용자 ID, 제목, 대출일을 조회하세요.
SELECT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE FROM rent_master RM
JOIN member M USING(USER_ID)
WHERE RM.IS_RETURN = 0 AND M.GRADE = 'ROLE_USER';


-- Q8. 도서를 2권 이상 대출한 회원의 ID, 이메일, 대출 도서 수를 조회하세요.
SELECT M.USER_ID, M.EMAIL, COUNT(RB.BK_IDX) AS 대출도서수
FROM member M
JOIN rent_master RM USING(USER_ID)
JOIN rent_book RB USING(RM_IDX)
GROUP BY M.USER_ID
HAVING COUNT(RB.BK_IDX) >= 2;


-- Q9. 대출일로부터 3일 이내 반납한 도서의 대출 번호, 사용자 ID, 도서 제목, 반납일을 조회하세요.
SELECT DISTINCT RB.RB_IDX, M.USER_ID, B.TITLE, RB.RETURN_DATE FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN BOOK B USING(BK_IDX)
WHERE DATEDIFF(RB.RETURN_DATE, RB.REG_DATE) <= 3;


-- Q10. 탈퇴하지 않은 회원 중 도서를 가장 많이 대출한 회원의 ID, 이메일, 대출 도서 수를 조회하세요.
SELECT M.USER_ID, M.EMAIL, COUNT(RB.BK_IDX) AS 대출도서수 FROM member M
JOIN rent_master RM USING(USER_ID)
JOIN rent_book RB USING(RM_IDX)
WHERE M.IS_LEAVE = 0 
GROUP BY M.USER_ID
ORDER BY COUNT(RB.BK_IDX) DESC LIMIT 1;


-- Q11. 대출 상태가 ‘연체’인 도서의 대출 번호, 사용자 ID, 제목, 대출일, 상태 정보를 조회하세요.
SELECT DISTINCT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE, C.INFO 
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN CODE C ON C.CODE = RB.STATEINFOcode
WHERE C.INFO = '연체';

-- Q12. 반납 상태이며 반납일이 2023-06-15 이전인 도서의 번호, 사용자 ID, 제목, 반납일을 조회하세요.
SELECT RB.RB_IDX, M.USER_ID, B.TITLE, RB.RETURN_DATE
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
JOIN book B USING(BK_IDX)
JOIN code C ON C.CODE = RB.STATE
WHERE C.INFO = '반납'
  AND RB.RETURN_DATE <= '2023-06-15';



-- Q13. 'ROLE_USER'이며 대출 기록은 있지만 연체 이력이 없는 회원의 ID와 이메일을 조회하세요.
/*연체 상태"인지 아닌지는 판단하지 않고 단지 "대출 미반납이 없다"는 조건만 확인할 경우는 캡처 내용처럼 나오고  
연체 상태로 분류된 대출이 있는지 확인을 하게 되면 정확하게  2행 리턴합니다.  */
SELECT member.USER_ID, member.EMAIL
FROM member
JOIN rent_master USING(USER_ID)
WHERE member.GRADE = 'ROLE_USER' AND member.IS_LEAVE = 0
AND NOT EXISTS (
    SELECT * FROM rent_master rm2
    WHERE rm2.USER_ID = member.USER_ID AND rm2.IS_RETURN = 0
);

SELECT m.USER_ID, m.EMAIL
FROM member m
JOIN rent_master rm ON m.USER_ID = rm.USER_ID
WHERE m.GRADE = 'ROLE_USER' 
  AND m.IS_LEAVE = 0
  AND NOT EXISTS (
      SELECT 1
      FROM rent_master rm2
      JOIN rent_book rb2 ON rm2.RM_IDX = rb2.RM_IDX
      WHERE rm2.USER_ID = m.USER_ID
        AND rb2.STATE = 'RE02'  -- 연체 상태 코드
);


-- Q14. 'RE01' 상태인 도서 중 가장 먼저 대출된 도서의 번호, 사용자 ID, 제목, 대출일을 조회하세요.
SELECT RM.RM_IDX, M.USER_ID, RM.TITLE, RM.REG_DATE
FROM rent_master RM
JOIN rent_book RB USING(RM_IDX)
JOIN member M USING(USER_ID)
WHERE RB.STATE = 'RE01'
ORDER BY RB.REG_DATE ASC
LIMIT 1;

-- Q15. 도서가 존재하는 카테고리별 도서 재고 합계를 조회하세요.
SELECT CATEGORY, C.INFO, SUM(BOOK_AMT) AS '도서재고량'
FROM BOOK B
JOIN CODE C ON B.CATEGORY = C.CODE GROUP BY B.CATEGORY;


-- Q16. '문학'이라는 상위 카테고리에 포함된 모든 하위 카테고리를 조회하세요.
SELECT * FROM CODE C 
JOIN CODE C2 ON C.UPPER_CODE = C2.CODE
WHERE C2.INFO = '문학';


-- Q17. 마지막 로그인 일자가 2023년 12월인 회원이 대출한 도서 수를 조회하세요.
SELECT MI.USER_ID, COUNT(RB.RB_IDX) AS RENT_BOOK_CNT
FROM MEMBER_INFO MI
JOIN RENT_MASTER RM USING(USER_ID)
JOIN RENT_BOOK RB USING(RM_IDX)
WHERE MI.LOGIN_DATE BETWEEN '2023-12-01' AND '2023-12-31'
GROUP BY MI.USER_ID;


-- Q18. 대출 중이며 연체 상태인 책의 수를 조회하세요.
SELECT COUNT(rb.RB_IDX) AS OVERDUE_COUNT
FROM rent_book rb
JOIN rent_master rm USING(RM_IDX)
JOIN code c ON c.code = rb.state
WHERE c.info = '연체';



-- Q19. 모든 도서카테고리의 도서 재고 합계를 구하세요.
SELECT IFNULL(SUM(BOOK_AMT),0) AS 도서재고, C.INFO
FROM BOOK B
RIGHT JOIN CODE C ON B.CATEGORY = C.CODE
WHERE C.UPPER_CODE IN(SELECT CODE FROM CODE WHERE UPPER_CODE = 'B')
GROUP BY C.INFO;


-- Q20. 모든 도서의 제목, 카테고리명, 상위 카테고리명을 조회하세요.
SELECT TITLE, C.INFO, C2.INFO FROM BOOK B
JOIN CODE C ON B.CATEGORY = C.CODE
JOIN CODE C2 ON C.UPPER_CODE = C2.CODE;


