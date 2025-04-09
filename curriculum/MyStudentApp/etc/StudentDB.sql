# MVC 패턴 활용한 서비스 컴포터넌트를 콘솔에서 실행:

# view -> controller -> model [service, dao] -> JDBCTemplate -> db

USE MY_EMP;
SHOW TABLES;

CREATE TABLE IF NOT EXISTS Student (
	stdID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    major VARCHAR(50),
    grade INT
);

DESC STUDENT;

SELECT *
FROM STUDENT;

CALL PRO_insert_random_students();