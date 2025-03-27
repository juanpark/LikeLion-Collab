use world;
-- 각 테이블의 내용을 확인 하자.  
SELECT * 
FROM CITY;

SELECT * 
FROM COUNTRY;

SELECT * 
FROM COUNTRYLANGUAGE;

-- Q1. 모든 도시(city)의 이름과 해당 국가(country)의 이름을 출력하되, 각각 City와 Country라는 별칭으로 표시하자.
-- ANSI
SELECT city.Name AS City, country.Name AS Country
FROM city
JOIN country ON city.CountryCode = country.Code;

-- MYSQL
SELECT city.Name AS City, country.Name AS Country
FROM city, country
WHERE city.CountryCode = country.Code;


-- Q2. 인구 수가 100만 이상인 도시 이름, 인구, 해당 국가 이름을 출력하되, 도시의 인구가 기준이다.
-- ANSI
SELECT city.Name, city.Population, country.Name
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE city.Population >= 1000000;


-- MYSQL
SELECT city.Name, city.Population, country.Name
FROM city, country
WHERE city.CountryCode = country.Code
AND city.Population >= 1000000; 

-- Q3. 도시 이름, 국가 코드, 해당 도시가 속한 국가에서 사용되는 언어를 출력하자.
-- ANSI
SELECT city.Name, city.CountryCode, countrylanguage.Language
FROM city
JOIN countrylanguage USING(CountryCode);

-- MYSQL
SELECT city.Name, city.CountryCode, countrylanguage.Language
FROM city, countrylanguage
WHERE city.CountryCode = countrylanguage.CountryCode;



-- Q4. 공용 언어(IsOfficial='T')만 골라 언어 이름과 해당 국가 이름을 출력하자.
-- ANSI
SELECT country.Name, countrylanguage.Language
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.IsOfficial = 'T';

-- MYSQL
SELECT country.Name, countrylanguage.Language
FROM country, countrylanguage
WHERE country.Code = countrylanguage.CountryCode
AND countrylanguage.IsOfficial = 'T';


-- Q5. 아시아 대륙에 속한 국가에 있는 도시의 이름과 인구를 출력하자.
-- ANSI
SELECT city.Name, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE Continent = 'Asia';

-- MYSQL
SELECT city.Name, city.Population
FROM city, country
WHERE city.CountryCode = country.Code
AND country.Continent = 'Asia';

-- Q6. 기대 수명(LifeExpectancy)이 80 이상인 국가의 이름과 대륙을 출력하자.
-- ANSI
SELECT Name, Continent
FROM country
WHERE LifeExpectancy >= 80;

-- MYSQL

-- Q7. 공용어가 영어인 국가의 이름만 출력하자.
-- ANSI
SELECT country.Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
WHERE Language = 'English' AND IsOfficial = 'T';

-- MYSQL
SELECT country.Name
FROM country, countrylanguage
WHERE country.Code = countrylanguage.CountryCode
AND countrylanguage.Language = 'English'
AND countrylanguage.IsOfficial = 'T';

-- Q8. 모든 국가의 이름과 수도 도시의 이름을 각각 Country, Capital로 별칭을 주어 출력하자.
-- ANSI
SELECT country.Name AS Country, city.Name AS Capital
FROM country
JOIN city ON Capital = ID;

-- MYSQL
SELECT country.Name AS Country, city.Name AS Capital
FROM country, city
WHERE country.Capital = city.ID;

-- Q9. 도시 이름, 도시 인구, 해당 국가의 지역(region)을 출력하자.
-- ANSI
SELECT city.Name, city.Population, country.Region
FROM city
JOIN country ON CountryCode = Code;

-- MYSQL
SELECT city.Name, city.Population, country.Region
FROM city, country
WHERE city.CountryCode = country.Code;

-- Q10. 인구가 500만 이상인 국가에서 사용되는 언어를 해당 국가 이름과 함께 출력하자.
-- ANSI
SELECT country.Name, Language
FROM country
JOIN countrylanguage ON (Code = CountryCode) 
WHERE Population >= 5000000;

-- MYSQL
SELECT country.Name, countrylanguage.Language
FROM country, countrylanguage
WHERE country.Code = countrylanguage.CountryCode
AND country.Population >= 5000000;

-- Q11. 도시 이름과 해당 국가의 정부 형태(GovernmentForm)를 출력하자.
-- ANSI
SELECT city.Name, GovernmentForm
FROM city
JOIN country ON city.CountryCode = country.Code;

-- MYSQL
SELECT city.Name, GovernmentForm
FROM city, country
WHERE city.CountryCode = country.Code;

-- Q12. 공용어가 영어인 국가에 속한 도시 이름을 중복 없이 출력하자.
-- ANSI
SELECT DISTINCT city.Name
FROM city
JOIN countrylanguage USING(CountryCode)
WHERE Language = 'English'
AND IsOfficial = 'T';

-- MYSQL
SELECT DISTINCT city.Name
FROM city, countrylanguage
WHERE city.CountryCode = countrylanguage.CountryCode
AND countrylanguage.Language = 'English'
AND countrylanguage.IsOfficial = 'T';

-- Q13. 국가 이름과 그 국가에서 사용되는 언어 이름을 출력하자.
-- ANSI
SELECT Name, countrylanguage.Language
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode;

-- MYSQL
SELECT country.Name, countrylanguage.Language
FROM country, countrylanguage
WHERE country.Code = countrylanguage.CountryCode;

-- Q14. 모든 국가의 이름과 수도 도시의 인구를 출력하자.
-- ANSI
SELECT country.Name, city.Population
FROM country
JOIN city ON country.Capital = city.ID;

-- MYSQL
SELECT country.Name, city.Population
FROM country, city
WHERE country.Capital = city.ID;

-- Q15. 도시 이름과 해당 국가의 독립 연도(IndepYear)를 출력하자.
-- ANSI
SELECT city.Name, country.IndepYear
FROM city
JOIN country ON city.CountryCode = country.Code;

-- MYSQL
SELECT city.Name, country.IndepYear
FROM city, country
WHERE city.CountryCode = country.Code;

-- Q16. 사용 언어 수가 5개 이상인 국가의 이름을 출력하자.
--  같은 나라에 속한 모든 언어를 하나의 그룹으로 같은 나라별 언어 수를 COUNT로 조건문으로구현  
-- ANSI
SELECT country.Name
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.CountryCode
GROUP BY country.Name
HAVING COUNT(countrylanguage.Language) >= 5;

-- MYSQL
SELECT country.Name
FROM country, countrylanguage
WHERE country.Code = countrylanguage.CountryCode
GROUP BY country.Name
HAVING COUNT(countrylanguage.Language) >= 5;

-- Q17. 도시 이름과 그 도시가 속한 국가의 국토 면적(SurfaceArea)을 출력하자.
-- ANSI
SELECT city.Name, country.SurfaceArea
FROM city
JOIN country ON city.CountryCode = country.Code;

-- MYSQL
SELECT city.Name, country.SurfaceArea
FROM city, country
WHERE city.CountryCode = country.Code;

-- Q18. 아프리카 대륙에 속한 국가의 이름과 수도 도시 이름을 출력하자.
-- ANSI
SELECT country.Name, city.Name AS Capital
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Africa';

-- MYSQL
SELECT country.Name, city.Name AS Capital
FROM country, city
WHERE country.Capital = city.ID
AND country.Continent = 'Africa';

-- Q19. 전 세계에서 인구가 가장 많은 도시의 이름과 그 도시가 속한 국가 이름을 출력하자.
-- ANSI
SELECT city.Name, country.Name
FROM city
JOIN country ON city.CountryCode = country.Code
ORDER BY city.Population DESC
LIMIT 1;

-- MYSQL
SELECT city.Name, country.Name
FROM city, country
WHERE city.CountryCode = country.Code
ORDER BY city.Population DESC
LIMIT 1;

-- Q20. 도시 인구의 평균이 100만 이상인 국가의 이름을 출력하자.
-- ANSI
SELECT country.Name
FROM country
JOIN city ON country.Code = city.CountryCode
GROUP BY country.Name
HAVING AVG(city.Population) >= 1000000;

-- MYSQL
SELECT country.Name
FROM country, city
WHERE country.Code = city.CountryCode
GROUP BY country.Name
HAVING AVG(city.Population) >= 1000000;   

-- Q21. 도시 정보가 없는 국가를 출력하자  -> 나라에는 등록되어 있지만 도시 정보가 없는 경우 
SELECT country.Name
FROM country
LEFT JOIN city ON country.Code = city.CountryCode
WHERE city.ID IS NULL;

