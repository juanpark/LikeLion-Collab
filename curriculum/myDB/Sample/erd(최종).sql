-- 스키마 생성 (선택 사항)
CREATE SCHEMA IF NOT EXISTS ecommerce;
USE ecommerce;

-- 부서 테이블 생성
CREATE TABLE IF NOT EXISTS 부서 (
    부서번호 INT PRIMARY KEY COMMENT '주 식별자, 내부 식별자, 단일 식별자, 본질 식별자'
);

-- 사원 테이블 생성
CREATE TABLE IF NOT EXISTS 사원 (
    사번 INT PRIMARY KEY COMMENT '주 식별자, 내부 식별자, 단일 식별자, 본질 식별자',
    주민등록번호 VARCHAR(13) UNIQUE COMMENT '보조 식별자 (AK1, 1)',
    부서번호 INT COMMENT '외부 식별자 (FK)',
    FOREIGN KEY (부서번호) REFERENCES 부서(부서번호) ON DELETE RESTRICT ON UPDATE CASCADE
);
ALTER TABLE 사원 ADD INDEX idx_주민등록번호 (주민등록번호);

-- 교육 이력 테이블 생성
CREATE TABLE IF NOT EXISTS 교육이력 (
    사번 INT COMMENT '주 식별자 (FK)',
    수강일자 DATE COMMENT '주 식별자',
    PRIMARY KEY (사번, 수강일자),
    FOREIGN KEY (사번) REFERENCES 사원(사번) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 구매 신청 테이블 생성
CREATE TABLE IF NOT EXISTS 구매신청 (
    주문번호 VARCHAR(255) PRIMARY KEY COMMENT '주 식별자, 단일 식별자, 내부 식별자, 인조 식별자 (사번 + 주문일자 + 순번)',
    사번 INT COMMENT '외부 식별자 (FK)',
    주문일자 DATE COMMENT '주 식별자 (복합 식별자 구성)',
    -- 필요하다면 순번 속성 추가
    FOREIGN KEY (사번) REFERENCES 사원(사번) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- 부모 테이블
CREATE TABLE 비식별자관계부모 (
    부모번호 INT PRIMARY KEY
);

-- 자식 테이블 (부모번호는 외래키일 뿐 주식별자에 포함되지 않음)
CREATE TABLE 비식별자관계자식 (
    자식번호 INT PRIMARY KEY,
    부모번호 INT,
    FOREIGN KEY (부모번호) REFERENCES 비식별자관계부모(부모번호)
);

-- 부모 테이블
CREATE TABLE 식별자관계부모 (
    부모번호 INT PRIMARY KEY
);

-- 자식 테이블 (부모번호가 주식별자(PK) + 외래키(FK))
CREATE TABLE 식별자관계자식 (
    부모번호 INT,
    자식순번 INT,
    자식데이터 VARCHAR(100),
    PRIMARY KEY (부모번호, 자식순번),
    FOREIGN KEY (부모번호) REFERENCES 식별자관계부모(부모번호)
);

-- 인조 식별자 생성을 위한 트리거 (선택 사항 - 데이터 삽입 시 자동 생성)
DELIMITER //
CREATE TRIGGER before_insert_구매신청
BEFORE INSERT ON 구매신청
FOR EACH ROW
BEGIN
    -- 간단한 순번 생성을 위한 변수 (실제 환경에서는 더욱 정교한 방식 필요)
    DECLARE next_순번 INT DEFAULT 1;
    SELECT COALESCE(MAX(SUBSTR(주문번호, LENGTH(NEW.사번) + 2 + LENGTH(DATE_FORMAT(NEW.주문일자, '%Y%m%d')) + 1)), 0) + 1
    INTO next_순번
    FROM 구매신청
    WHERE 사번 = NEW.사번 AND 주문일자 = NEW.주문일자;

    SET NEW.주문번호 = CONCAT(NEW.사번, '-', DATE_FORMAT(NEW.주문일자, '%Y%m%d'), '-', LPAD(next_순번, 3, '0'));
END//
DELIMITER ;