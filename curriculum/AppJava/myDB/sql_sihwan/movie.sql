USE MY_P;
CREATE TABLE 2020_movie_report (id INTEGER PRIMARY KEY, name TEXT, category TEXT, main_month INTEGER, view_count INTEGER);
INSERT INTO 2020_movie_report 
VALUES (1,'태극권 배우기', 'Action', 3, 120000),
(2, '여름 왕국', 'Fantasy', 6, 10000000),
(3, '성태후 일병 구하기', 'Drama', 5, 5000000),
(4, '그날 너를 보았다', 'Romance', 4, 7000000),
(5, '다이이지', 'Action', 5, 2300000),
(6, '쓰리캅스', 'Action', 5, 7000000),
(7, '매드미니멈', 'Action', 4, 8500000),
(8, '무인도, 20일', 'Thriller', 4, 1000000),
(9, '허씨표류기', 'Comedy', 5, 300000),
(10, '링거전쟁', 'Thriller', 3, 150000),
(11, '타임백투유', 'Romance', 3, 5000000),
(12, '그렇게 살아간다', 'Drama', 3, 3200000),
(13, '배틀스타', 'SF', 4, 1650000),
(14, '내일은 결혼식', 'Comedy', 5, 2000000),
(15, '화성탈출', 'SF', 5, 4500000);

SELECT * FROM 2020_movie_report;

/*
Q2.
현재, 2020_movie_report 테이블에서 영화별 장르(category), 주 상영 월(main_month), 
그리고 총 관객 수(view_count)를 관리하고 있습니다. 
다음과 같은 조건을 만족하는 데이터를 추출하세요.

category 컬럼, main_month 컬럼 기준 그룹화
그룹 중에서 주 상영 월이 5월이고, view_count의 합이 3000000(삼백만) 이상인 그룹만 선별해 주세요.
category 컬럼, main_month 컬럼, 각 그룹에 속한 영화의 개수, 각 그룹의 관객 수 합계 출력
각 그룹에 속한 영화의 개수에 movie_count라는 별칭을 붙여 주세요.
각 그룹의 관객 수 합계에 total_audience라는 별칭을 붙여 주세요.
*/

# 시환님 풀이:
SELECT
    category, main_month,
    COUNT(*) AS movie_count,
    SUM(view_count) AS total_audience
FROM 2020_movie_report
GROUP BY category, main_month
HAVING main_month = 5 AND total_audience >= 3000000;