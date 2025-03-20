use my_emp;
CREATE DATABASE TEST;
DROP DATABASE TEST;


/*
SELECT COLUMNAME,,, [*]
FROM TABLENAME;

*/

#Q1: 사원테이블에서 전체 인원을 출력 해보자.
SELECT *
FROM EMP;

#Q2. 사원테이블에서 사원의 이름, 사원의 번호를 출력하자
SELECT ENAME, EMPNO
FROM EMP;

#Q3. 사원케이블에서 사원의 이름, 봉급, 부서번호를 출력하자
SELECT ENAME, SAL, DEPTNO
FROM EMP;

#Q4. 부서 테이블의 모든 데이터를 출력하자 
SELECT *
FROM DEPT;

#Q5. 부서 테이블의 부서이름, 부서번호를 출력하자
SELECT DNAME, DEPTNO
FROM DEPT;

#6. 부서 테이블과 사원테이블의 모든 내용을 출력하자
SELECT *
FROM EMP, DEPT;

#7. 사원의 이름과 부서이름 부서의 위치를 출력하자
SELECT ENAME, DNAME, LOC
FROM EMP, DEPT;

#8. 사원의 이름, 부서번호, 부서이름 출력하자. 
SELECT EMP.ENAME, DEPTNO, DNAME
FROM EMP, DEPT;
## Error Code: 1052. Column 'DEPTNO' in field list is ambiguous
## CASE 1
SELECT ENAME, EMP.DEPTNO, DNAME
FROM EMP, DEPT;
## CASE 2
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM EMP E, DEPT D;
## CASE 3
SELECT E.ENAME, E.DEPTNO, D.DNAME
FROM EMP AS E, DEPT AS D;

/* 별칭 주자 컬럼별칭, 테이블 별칭
SELECT COLUMNNAME [AS] ALIAS ,,,[*]
FROM 테이블명 [AS] ALIAS ,,,[*]
*/

#9 "사원의 이름", "부서번호", "부서이름" 출력하자. 
## CASE 1
SELECT E.ENAME "사원 이름", E.DEPTNO "부서 번호", D.DNAME "부서 이름1"
FROM EMP E, DEPT D;
## CASE 2
SELECT E.ENAME AS 사원이름, E.DEPTNO AS 부서번호, D.DNAME AS 부서이름2
FROM EMP E, DEPT D;
## CASE 3
SELECT EMP.ENAME AS "사원 이름", EMP.DEPTNO 부서번호, DEPT.DNAME 부서이름3
FROM EMP, DEPT;

/* 중복데이터 제거
SELECT DISTINCT COLUMNAME [AS] ALIAS ,,, [*]
FROM TABLENAME [AS] ALIAS,,,,;

DISTINCT: 	지정한 컬럼 값이 완전히 같을 때 중복 제거
			컬럼 1개일 때는 해당 컬럼값만 비교하고,
            컬럼 2개 이상일 때 컬럼들의 조합이 같아야 중복으로 간주한다.
*/
#10 사원테이블에서 고유 직업명만 출력하자
SELECT DISTINCT JOB
FROM EMP;

#11 사원테이블에서 고유 직업, 부서번호를 고유값으로 출력하자.
SELECT DISTINCT JOB, DEPTNO
FROM EMP;

## 속성에 4칙 연산을 할 수 있다.
/*
	연산 시 NULL은 NULL로 리턴되어 계산되지 않는다.
    - IFNULL(널이 있는 컬럼, 초기값)  
    - COALESCE(VALUE, ...)
	- WHERE문과 같이 사용 IS NULL 	
*/

#12 사원의 이름, 사원의 봉급, 사원의 연봉을 연봉이라고 출력하자.
SELECT ENAME, SAL, SAL * 12 AS 연봉
FROM EMP;

#13 사원의 이름, 사원의 봉급을 출력하되 봉급 = 봉급 + 커미션을 계산하여 봉급이라고 출력하자
SELECT ENAME, SAL, COMM, SAL + IFNULL(COMM,0) AS 봉급
FROM EMP;

/* 조건문
SELECT DISTINCT COLUMNNAME [AS] ALIAS ,,, [*]
FROM TABLENAME [AS] ALIAS ,,,
WHERE 조건식;  비교 연산의 결과	IN _ (DATA OR ,,, 또는), NOT IN, IS NULL, IS NOT NULL
AND, OR
BETWEEN AND
날짜비교
문자열 비교 LIKE
*/

#14 사원테이블에서 사원의 봉급이 1000 이상인 사원의 이름, 봉급, 커미션을 출력하자.
SELECT ENAME, SAL, COMM
FROM EMP 
WHERE SAL >= 1000;

#15 사원테이블에서 커미션이 500 이상인 사원의 이름, 봉급을 출력해보자.
SELECT ENAME, SAL, COMM
FROM EMP
WHERE COMM >= 500;

#16 커미션이 NULL이 아닌 사원의 이름, 커미션을 출력해보자
SELECT ENAME, COMM
FROM EMP
WHERE COMM IS NOT NULL;

#17 부서번호가 10 또는 20인 사원의 모든 정보를 출력하자
SELECT *
FROM EMP
WHERE DEPTNO IN(10,20); ## 10 OR 20

#18 부서번호가 10또는 20인 사원을 제외한 모든 정보를 출력하자
SELECT *
FROM EMP
WHERE DEPTNO NOT IN(10,20); ## !(10 OR 20)

#19 봉급이 2000 이상 5000 이하인 사원의 이름과 직업 봉급을 출력하자. 
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL >= 2000 AND SAL <= 5000;

#20 급이 2000 이상 5000 이하인 사원의 이름과 직업 봉급을 출력하자. 
SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL BETWEEN 2000 AND 5000;

SELECT ENAME, JOB, SAL
FROM EMP
WHERE SAL BETWEEN 5000 AND 2000; #DOESN'T WORK NEEDS TO BE SMALL TO LARGE?
/*
Yes, the BETWEEN operator in MySQL (and SQL in general) requires
 the lower bound to be specified first, followed by the upper bound. 
 If the lower bound is greater than the upper bound, the condition 
 will return no results because the range is logically incorrect.
*/

#21 날짜는 수치변환이 가능하다! 날짜 데이트를 확인 해보자.
#EMP 태이블의 구조를 확인하자.
DESC EMP;

#EMP 테이블의 모든 내용을 TEST테이블로 생성하자 (복사 시 제약조건 X)
CREATE TABLE TEST
AS
SELECT * FROM EMP;

SELECT *
FROM TEST;
# TEST 구조 확인!!! 
DESC TEST;

# EMP 테이블의 사원의 이름과 입사일을 TEST02테이블로 생성하자
CREATE TABLE TEST02
AS
SELECT ENAME, HIREDATE
FROM EMP;

# NO KEY VALUE
DESC TEST02;

# EMP 테이블의 사원의 이름과 입사일을 TEST03테이블로 생성하자
/*
CREATE TABLE TEST03 (사원이름, 입사일) # ORACLE에서는 되지만 MYSQL에서는 안된다
AS
SELECT ENAME, HIREDATE
FROM EMP;

DESC TEST03;
*/

# 구조만 가지고 오고 싶다.
CREATE TABLE TEST03 LIKE EMP;

# TEST02에 데이터를 입력해보자. INSERT INTO TABLENAME(COLUMNNAME,,) VALUES (,,,);
DESC TEST02;

INSERT INTO TEST02 
VALUES('111', '1980-01-01');

INSERT INTO TEST02 
VALUES('222', '1980/01/01');

INSERT INTO TEST02 
VALUES('333', '80-01-01');

INSERT INTO TEST02 
VALUES('444', '80/01/01');

SELECT *
FROM TEST02;

## TEST02의 사원들의 입사년도가 1981년 이후의 사원들의 목록을 출력해보자.
# DATE = 년, 월, 일
SELECT *
FROM TEST02
WHERE HIREDATE > '81/5/1'; # JUST 1981 DOES NOT WORK
# WHERE HIREDATE > '1981-05-01'; # VARIOUS FORMATS WORK



