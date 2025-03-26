########## 문자열 함수  ############# 
/*
초기값 확인, 리턴 타입 확인 
https://dev.mysql.com/doc/refman/8.4/en/string-functions.html

CONCAT()	문자열 연결	CONCAT(ENAME, '-', JOB) 
SUBSTR(),   SUBSTRING()	문자열 잘라내기	SUBSTR(JOB, 1, 3) 
UPPER()	  대문자 변환	
LOWER()	 소문자 변환	
LENGTH()	바이트 기준 길이	LENGTH('가') ➔ 3
CHAR_LENGTH()	문자 기준 길이	CHAR_LENGTH('가') ➔ 1
REVERSE()	문자열 뒤집기	REVERSE('SMITH') ➔ 'HTIMS'
LEFT()	왼쪽부터 N글자	LEFT(ENAME, 1) ➔ 'S'
RIGHT()	오른쪽부터 N글자	RIGHT(ENAME, 2) ➔ 'TH'
REPLACE()	특정 문자 치환	REPLACE(ENAME, 'A', 'X') ➔ 'XLLEN'
TRIM()	앞뒤 공백 제거	TRIM(' ALLEN ') ➔ 'ALLEN'
LPAD()	왼쪽에 문자 채우기	LPAD(ENAME, 10, '*') ➔ '*****SMITH'
RPAD()	오른쪽에 문자 채우기	RPAD(ENAME, 8, '!') ➔ 'SMITH!!!'
INSTR()	특정 문자 위치 찾기	INSTR(ENAME, 'E') ➔ 2
LOCATE()	특정 문자 위치 찾기	LOCATE('A', ENAME) ➔ 2
DATE_FORMAT()	날짜 포맷 변경	DATE_FORMAT(HIREDATE, '%Y년 %m월 %d일')
GROUP_CONCAT()	그룹 내 문자열 합치기	GROUP_CONCAT(ENAME) ➔ 'SMITH,ALLEN,WARD'
TO_BASE64()	Base64 인코딩	TO_BASE64('abc') ➔ 'YWJj'
FROM_BASE64()	Base64 디코딩	FROM_BASE64('YWJj') ➔ 'abc'
WEIGHT_STRING()	정렬용 문자 가중치 반환	ORDER BY WEIGHT_STRING(ENAME) -> 다국어 
*/
use my_emp;
select  *
from emp;
-- Q1. 이름과 직업을 연결해서 하나의 컬럼을 만들어서 사원번호, 결합내용을 별칭으로 출력하자. CONCAT
-- ex): 'SMITH-CLERK', 'ALLEN-SALESMAN', ...  CONCAT(str1,str2,...) 
 SELECT   CONCAT(ENAME,'-', JOB)   
 FROM EMP; 

-- Q2. 직업의 처음 세글자를 추출해서 출력하자. SUBSTR, SUBSTRING 
-- ex): 'CLE', 'SAL', 'MAN', ...
/*
SUBSTR(str,pos), SUBSTR(str FROM pos), SUBSTR(str,pos,len), SUBSTR(str FROM pos FOR len)
SUBSTRING(str,pos), SUBSTRING(str FROM pos), SUBSTRING(str,pos,len), SUBSTRING(str FROM pos FOR len)
*/
SELECT JOB, SUBSTR(JOB, 1,3)  
FROM EMP;

SELECT JOB, SUBSTRING(JOB, 1,3)  
FROM EMP;

SELECT SUBSTRING('Quadratically',-3,1); 
SELECT SUBSTRING('Quadratically',2);   #2번째 위치 부터 나머지   
SELECT SUBSTR('Quadratically',2);

-- Q3. 사원의 번호, 사원의 이름을 출력하되 사원의 이름의 첫글자만 대문자 나머지 소문자로 출력하자.
  -- CONCAT, UPPER, LOWER, SUBSTR 
-- ex): 'Smith', 'Allen', ...
SELECT  EMPNO,  CONCAT(UPPER(SUBSTR(ENAME,1,1)) , LOWER(SUBSTR(ENAME,2)) ) AS 결과
FROM EMP;
-- Q3-1 INSTR 사용 
SELECT EMPNO, 
	CONCAT(UPPER(SUBSTR(ENAME, INSTR(ENAME, SUBSTR(ENAME, 1, 1)), 1)),
			LOWER(SUBSTR(ENAME, 2))) AS 결과
	FROM EMP;

-- Q3-2 사원의 이름 중 INSTR 이용해서 A글자를 찾아서 전체 소문자로 출력하자. INSTR(ENAME, 'A') > 0
-- INSTR은 특정 패턴을 찾아 비교할 때 사용하는 함수
SELECT LOWER(ENAME)
FROM EMP
WHERE INSTR(ENAME, 'A') > 0;
-- A글자 있는 사원 이름만 전체 소문자 나머지는 그대로 출력 
SELECT
	ENAME,
    CASE
		WHEN INSTR(ENAME, 'A') > 0 THEN
			(LOWER(ENAME))
		ELSE
			ENAME
	END AS 결과
FROM EMP;

-- Q4. 사원의 이름, 입사한날짜(0000년도 00월 00일) 출력하자. DATE_FORMAT
-- ex): 'SMITH', '1980년도 12월 17일', ...
 SELECT ENAME, DATE_FORMAT(HIREDATE, '%Y년도 %m월 %d일') AS 입사한날짜
 FROM EMP;
 
 SELECT ENAME, DATE_FORMAT(HIREDATE, '%m, %d, %Y') AS 입사한날짜
 FROM EMP;

-- Q5. 사원의 이름을 두번째 글자를 기준으로 내림차순 정렬하자. SUBSTRING, ORDER BY
-- ex): 'CLARK', 'SMITH', 'BLAKE', ...
SELECT ENAME
FROM EMP
ORDER BY SUBSTRING(ENAME,2,1) DESC;

-- Q6. 사원의 이름과 길이를 출력하자. LENGTH
-- ex): 'SMITH', 5, 'ALLEN', 5, ...
SELECT CONCAT(ENAME, " ", 'NAME LENGTH = ', LENGTH(ENAME))
FROM EMP;

-- Q7. 사원번호, 사원의 이름, 연봉의 별칭으로 하나의 문자열로 출력하자. CONCAT
-- ex): '7369SMITH800', '7499ALLEN1600', ...
SELECT CONCAT(EMPNO, ENAME, ROUND(SAL, 0))
FROM EMP;

-- Q8. 사원의 이름을 역순으로 출력하자. REVERSE
-- ex): 'HTIMS', 'NELLA', 'DRAH', ...
SELECT ENAME, REVERSE(ENAME) 
FROM EMP;

-- Q9. 사원의 이름에서 마지막 두 글자를 추출해서 출력하자. RIGHT
-- ex): 'TH', 'EN', 'RD', ...
SELECT ENAME , RIGHT(ENAME,2) AS "RIGHT", LEFT(ENAME,1) AS "LEFT"
FROM EMP;
-- Q10. 사원의 이름에서 'A' 문자를 'X' 문자로 대체해서 출력하자. REPLACE
-- ex): 'SMITH', 'XLLEN', 'WXRD', ...
SELECT ENAME,  REPLACE(ENAME, 'A','X')
FROM EMP;

-- Q11. 사원의 이름을 대문자로 변환하여 출력하자. UPPER
-- ex): 'SMITH', 'ALLEN', ...
SELECT UPPER(ENAME)
FROM EMP;

-- Q12. 사원의 이름을 소문자로 변환하여 출력하자. LOWER
-- ex): 'smith', 'allen', ...
SELECT LOWER(ENAME)
FROM EMP;

-- Q13. 사원의 이름에서 공백을 제거하고 출력하자. TRIM
-- TRIM([{BOTH | LEADING | TRAILING} [remstr] FROM] str), TRIM([remstr FROM] str)
/*
mysql> SELECT TRIM('  bar   ');         			-> 'bar'
mysql> SELECT TRIM(LEADING 'x' FROM 'xxxbarxxx');	-> 'barxxx'
mysql> SELECT TRIM(BOTH 'x' FROM 'xxxbarxxx');		-> 'bar'
mysql> SELECT TRIM(TRAILING 'xyz' FROM 'barxxyz');	-> 'barx'
*/
-- ex): 'SMITH', 'ALLEN', ...
SELECT ENAME, LENGTH(ENAME), TRIM(ENAME)
FROM EMP;

SELECT TRIM(TRAILING 'xyz' FROM 'barxxyz') AS RES;
SELECT TRIM(TRAILING 'xyz' FROM 'barxx1z') AS RES;

SELECT LENGTH(TRIM(TRAILING ' ' FROM 'barxx1z        ')) AS RES;

-- Q14. 사원의 이름을 10자리로 맞추고, 나머지 부분을 '*'로 채워 출력하자. LPAD
-- ex): '*****SMITH', '*****ALLEN', ...
SELECT ENAME, LPAD(ENAME, 10,'*') AS "LPAD",  RPAD(ENAME, 10,'*') AS "RPAD"
FROM EMP;

SELECT LPAD('hi', 3,'??') AS "L", RPAD('hi',1,'??') AS "R";
#----->  길이를 '1'로 지정하면 원본 문자열을 잘라서 첫번째 문자만 리턴한다. 
SELECT LPAD('hi',0,'??') AS "L", RPAD('hi',0,'??') AS "R";

-- Q15. 사원의 이름에서 'E' 문자의 위치를 찾아 출력하자. INSTR
-- ex): 2, 5, 0, ...

-- Q16. 사원의 이름을 '이름: [ENAME]' 형식으로 출력하자. CONCAT
-- ex): '이름: SMITH', '이름: ALLEN', ...

-- Q17. 사원의 이름과 직업을 '-'로 연결하고, 전체를 대문자로 변환하여 출력하자. CONCAT, UPPER
-- ex): 'SMITH-CLERK', 'ALLEN-SALESMAN', ...
SELECT UPPER(CONCAT(ENAME, "-", JOB))
FROM EMP;

-- Q18. 사원의 이름을 5자리로 맞추고, 왼쪽에 '#' 문자를 추가하여 출력하자. LPAD
-- ex): '#SMITH', '#ALLEN', ...

-- Q19. 사원의 이름을 8자리로 맞추고, 오른쪽에 '!' 문자를 추가하여 출력하자. RPAD
-- ex): 'SMITH!!!', 'ALLEN!!!', ...
SELECT ENAME, RPAD(ENAME, 8, '!') AS RES
FROM EMP;

-- Q20. 사원의 이름이 'SMITH'인 경우 'SMITH'를 대문자로 변환하고, 그렇지 않으면 원래 이름을 출력하자. 
  -- CASE ~ WHEN ~THEN, UPPER 
-- ex): 'SMITH', 'ALLEN', ...
SELECT  CASE WHEN ENAME= 'SMITH' THEN  UPPER(ENAME) 
        ELSE  ENAME
        END  AS  "결과"
FROM EMP;		

SELECT  CASE WHEN ENAME= 'SMITH' THEN  LOWER(ENAME) 
        ELSE  ENAME
        END  AS  "결과"
FROM EMP;		

-- Q21. 사원의 이름에서 처음으로 나타나는 'A'의 위치를 출력하자. LOCATE
-- LOCATE(substr,str), LOCATE(substr,str,pos)
-- ex): 2, 0, 3, ...
SELECT ENAME, LOCATE('A', ENAME) AS 'A 위치'
FROM EMP;

SELECT ENAME, LOCATE('A', ENAME, 1) AS 'A 위치'
FROM EMP;

-- Q22. 사원의 이름에서 세 번째 글자부터 끝까지 추출하여 출력하자. SUBSTRING
-- ex): 'ITH', 'LEN', 'RD', ...
SELECT ENAME, SUBSTRING(ENAME, 3) AS RES
FROM EMP;

-- Q23. 사원의 이름이 'J'로 시작하는 경우 해당 이름을 대문자로 변환하여 출력하자. UPPER, LIKE
-- ex): 'JONES', 'JAMES', ...
SELECT ENAME, UPPER(ENAME) AS "결과"
FROM EMP
WHERE ENAME LIKE 'J%';

SELECT ENAME, LOWER(ENAME) AS "결과"
FROM EMP
WHERE ENAME LIKE 'J%';

/*
키값 조심!!!
REPLACE works exactly like INSERT, except that if an old row in the
table has the same value as a new row for a PRIMARY KEY or a UNIQUE
index, the old row is deleted before the new row is inserted. 
-> 테이블에 새로운 행을 삽입할 때 (PRIMARY KEY 또는 UNIQUE INDEX값이 충돌할 때)
기존 행을 삭제하고 새로운 행을 삽인한다. 중복키 처리 방식이 INSERT하고 다르다.

CASE 1: 키 또느 인덱스 중복
새로운 행을 테이블에 삽입 -> PRIMARY KEY 또는 UNIQUE INDEX값이 중복된 값이 있을 경우
-> 기존 중복행을 삭제 -> 새로운 행을 테이블에 삽입 (원하지 않는 케이스일 수 있음)
CASE 2: 중복이 되지 않을 경우는 일반 INSERT INTO와 같다 

REPLACE [LOW_PRIORITY | DELAYED]
    [INTO] tbl_name
    [PARTITION (partition_name [, partition_name] ...)]  	-- 특정 파티션에 데이터 교체
    [(col_name [, col_name] ...)]							
    { {VALUES | VALUE} (value_list) [, (value_list)] ...	-- 삽입할 값
      |
      VALUES row_constructor_list
    }

*/
-- Q24. 사원의 이름에서 모든 'L' 문자를 제거하여 출력하자. REPLACE
-- ex): 'SMITH', 'AEN', 'WARD', ...
SELECT ENAME, REPLACE(ENAME, 'L', '') AS RES
FROM EMP;

-- Q25. 사원의 이름을 '*'로 감싸서 출력하자. CONCAT
-- ex): '*SMITH*', '*ALLEN*', ...
SELECT CONCAT('*', ENAME, '*')
FROM EMP;

##################################################번외 편 
-- Q26. BASE64  : 이메일  -> 텍스트 전용 시스템을 통해서 문제 발생될 부분(프린트 할수없는) 의 인코딩 
--  radix-64:   64를 밑수로 사용하는 것   [a-z,A-Z, 0-9] + /   = 64개를 글자 

--  ==> BASE64는  이진 데이터를 radix-64를 기반으로 텍스트 형식으로 인코딩    
--  ==>  데이터 ->  6비트로 나눔   -> radix-64 문자 매핑  

/*
TO_BASE64()   = 인코딩 /  FROM_BASE64() = 디코딩 
   
  BASE64 :  바이터리 데이터 [각 3byte(24bit)씩  4개의 6bit 그룹으로 나눈다.  2^6  = 64 ->  
             6bit 그룹에 2진 데이터를 표현할수 있는]  -> 
             문자열로 리턴 ( 만일 바이너리 데이터가 3의 배수가) 아닌경우 패딩문자 '='가 추가된다.              
   BASE64  :  이진데이터 분류  -> 문자에 매핑 (radix-64)  -> 인코딩 프로세싱(문자열로 리턴) ->  패딩      
 */
SELECT TO_BASE64('abc'), FROM_BASE64(TO_BASE64('abc'));  -- BASE64인코딩 
/*
1. 원본 문자열  'abc' 
2.  이진데이터 분류
      'a    ->  97(ASCII) -> 01100001 (8BIT 이진수)
       b    ->  98(ASCII) -> 01100010 (8BIT 이진수)
       c'   ->  99(ASCII) -> 01100011 (8BIT 이진수)
       ===> 01100001 01100010 01100011   (24bit)
       
3. 6bit씩 나누기    ->  24을 6비트로 계산   -> 그대로 분할  
011000   ->  24 (십진수)  [24	011000   	Y]
010110   ->  22(십진수)   [22	010110	    W]
001001  ->   9(십진수)    [ 9	001001	   J ]
100011  ->  35(십진수)    [ 35 100011  	j] 
*/
# 패딩값 없이 진행 
SELECT TO_BASE64('HELLO, MYSQL');  -- 바이너리 데이터->  radix-64	 -> ASCII  =  BASE64인코딩 
HELP  TO_BASE64;

SELECT LENGTH('A'),LENGTH('TEXT'), LENGTH('가'),LENGTH('한글') ;
SELECT CHAR_LENGTH('A'), CHAR_LENGTH('TEXT'), CHAR_LENGTH('가'),  CHAR_LENGTH('한글') ;
HELP LENGTH;

-- Q27. LOAD_FILE()  테이블을 이용해서 파일을 로드 해 보자.  
SHOW VARIABLES  LIKE 'secure_file_priv';  #경로 확인    \\  /  \ 
SHOW VARIABLES  LIKE  'max_allowed_packet'; #파일 크기 제한  
 -- 경로는 NULL, 파일 크기는 'max_allowed_packet', '67108864' 


SELECT LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\APPLE.JPG');
SELECT LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\A.TXT');
SHOW VARIABLES  LIKE  'NO_AUTO_VALUE_ON_ZERO'; # 컬럼에 AUTO_INCREMENT 0값 저장 안함  

DROP TABLE MY_FILE;
CREATE TABLE MY_FILE(
    ID INT AUTO_INCREMENT  PRIMARY KEY,   # NO_AUTO_VALUE_ON_ZERO, PRIMARY KEY(U+N)  
    FILE_CONTENT  LONGTEXT
);

INSERT INTO MY_FILE(FILE_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\A.TXT'));  
         
SELECT  FILE_CONTENT  
FROM MY_FILE;  
DELETE FROM MY_FILE; 
DESC MY_FILE;


DROP TABLE MY_IMAGE;

CREATE TABLE MY_IMAGE(
  ID INT AUTO_INCREMENT  PRIMARY KEY, 
  IMG_CONTENT  BLOB
); 

DESC MY_IMAGE;
INSERT INTO MY_IMAGE(IMG_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\A.TXT')),
        (LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\APPLE.JPG'));  

INSERT INTO MY_IMAGE(IMG_CONTENT)  
  VALUES(LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\A.TXT')),  
                   (LOAD_FILE('C:\\ProgramData\\MySQL\\MySQL Server 8.4\\Uploads\\APPLE.JPG'));

SELECT IMG_CONTENT
FROM MY_IMAGE;
COMMIT;

DELETE FROM  MY_IMAGE;
COMMIT;

-- Q28)  WEIGHT_STRING(str [AS {CHAR|BINARY}(N)] [flags]) 사용해보자 
-- 이름을 기준으로 언어규칙을 정의해서 정렬할 때 사용  (베트남어, 중국어, 라틴어....)
SELECT  ENAME
FROM EMP
ORDER BY WEIGHT_STRING(ENAME);

SELECT ENAME, WEIGHT_STRING(ENAME)
FROM EMP;
-- Q29) EMP구조, 데이터를 가지고 동일한 TEST 테이블 생성하겠다. [키값 제외]
CREATE TABLE  TEST
AS
SELECT  * 
FROM  EMP;


SELECT  *  FROM TEST;
DESC TEST;

DROP TABLE TEST;

-- Q30 )  구조만 복사해보자.  
CREATE TABLE TEST AS
SELECT * 
FROM EMP
WHERE 1=0;  -- 데이터를 복사하지 않고 구조만 복사

-- 30-1 :  중국어 이름 저장 해보자.  
INSERT INTO TEST (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO)
VALUES
(1, '张伟', 'MANAGER', NULL, '2023-08-01', 5000, NULL, 10),
(2, '王芳', 'CLERK', NULL, '2023-08-02', 3000, NULL, 20),
(3, '李娜', 'SALESMAN', NULL, '2023-08-03', 2500, NULL, 30),
(4, '赵强', 'ANALYST', NULL, '2023-08-04', 4000, NULL, 10),
(5, '刘洋', 'MANAGER', NULL, '2023-08-05', 4500, NULL, 20);

SELECT * FROM TEST;

-- 30-2 :   WEIGHT_STRING()을 사용하여 정렬된 결과 확인해 보자.  
SELECT ENAME
FROM TEST
ORDER BY WEIGHT_STRING(ENAME);   #utf8 또는 utf8mb4가 기본 문자셋으로 설정되어 있기 때문에 정렬이 잘된다.  


-- 30-3  : COLLATE를 사용하여 정렬 제어    -> 특정 COLLATE를 적용해 문자열을 정렬한다.  
-- ORDER BY와 함께 사용한다.   / 중국어 데이터를 간체자에 (ZH-CN)에 맞게 정렬해보자.  
-- COLLATE utf8mb4_zh_ci로 구현 할 수 있다. 
SELECT ENAME
FROM TEST
ORDER BY ENAME COLLATE utf8mb4_zh_ci; #---설치가 안되어 있는 경우  

SELECT ENAME
FROM TEST
ORDER BY ENAME COLLATE utf8mb4_unicode_ci;      # unicode_language_id
 
 -- 30- 4: 목록확인
 SHOW COLLATION LIKE 'utf8mb4%';  
 
 










































