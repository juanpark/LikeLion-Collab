-- 데이터베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS spring_lab06;
USE spring_lab06;

-- 학생 테이블
CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- 강의 테이블 
CREATE TABLE course (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL
);

-- 학생-강의 연결 테이블 (다대다 관계)
CREATE TABLE student_course (
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES course(id)
);

--  학생 데이터 
INSERT INTO student (name) VALUES
('홍길동'),
('정길동'),
('이길동'),
('최길동'),
('박길동');

--  강의 데이터 
INSERT INTO course (title) VALUES
('자바 프로그래밍'),
('웹 개발'),
('데이터베이스 설계'),
('스프링 부트'),
('머신러닝');

--  수강 관계
INSERT INTO student_course (student_id, course_id) VALUES
(1, 1), -- 홍길동 - 자바 프로그래밍
(1, 2), -- 홍길동 - 웹 개발
(1, 4), -- 홍길동 - 스프링 부트
(2, 1), -- 정길동 - 자바 프로그래밍
(2, 3), -- 정길동 - 데이터베이스 설계
(3, 2), -- 이길동 - 웹 개발
(3, 3), -- 이길동 - 데이터베이스 설계
(3, 5), -- 이길동 - 머신러닝
(4, 4), -- 최길동 - 스프링 부트
(4, 5), -- 최길동 - 머신러닝
(5, 1), -- 박길동 - 자바 프로그래밍
(5, 2), -- 박길동 - 웹 개발
(5, 3), -- 박길동 - 데이터베이스 설계
(5, 4); -- 박길동 - 스프링 부트
