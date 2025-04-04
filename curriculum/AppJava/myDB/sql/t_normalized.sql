-- 비정규형
CREATE TABLE Unnormalized_Students (
    student_id INT,
    name VARCHAR(50),
    phone_numbers VARCHAR(100)	-- 010-123-4567, 010-0000-0000
);

-- 1NF: 하나의 컬럼에는 하나의 값만 - 원자값 보장 1:1
-- phone_number를 2행으로
/*
 1. 홍길동 010-123-4567
 2. 홍길동 010-0000-0000
*/
CREATE TABLE Students_1NF (
    student_id INT,
    name VARCHAR(50),
    phone_number VARCHAR(20) -- phone_numbers를 개별로 구현
);

-- 2NF: 복합키 사용 시 부분 종속 제거 (기본키에 종속적이지 않은 컬럼 분리) - 부분함수 종속 제거
-- 1NF를 만족하면서, 복합키의 일부에만 종속된 속성을 제거
-- 비정규화 예: 과목명이 subject_id에만 종속됨: 부분함수 종속
CREATE TABLE Enrollments_Unnormalized (
    student_id INT,
    subject_id INT,
    subject_name VARCHAR(50),
    score INT,
    PRIMARY KEY (student_id, subject_id)
);

-- 정규화된 테이블 분리_ 2NF
CREATE TABLE Enrollments_2NF (
    student_id INT,
    subject_id INT,
    score INT,
    PRIMARY KEY (student_id, subject_id)
);
-- subject_name 과목 테이블로 분리
CREATE TABLE Subjects (
    subject_id INT PRIMARY KEY,
    subject_name VARCHAR(50)
);

-- 3NF: 이행 종속 제거 _ 기본키를 제외한 나머지 컬럼들 간의 종속 불가 >>> dept_name은 dept_id에 종속, emp_id를 통해서 간접 종속
-- 2NF를 만족하면서, 기본키 이외의 속성이 또 다른 속성ㅇ에 종속되었을 경우 제거 
-- 부서명이 부서ID에 종속, 사원테이블에서 제거 필요
CREATE TABLE Employees_Unnormalized (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    dept_name VARCHAR(50)
);

-- 정규화된 테이블
CREATE TABLE Employees_3NF (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT
);

CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- BCNF: 모든 결정자가 후보키일 것 : 기본키가 여러 개 존재할 경우, 복합키로 
-- 3NF를 만족해도 후보키가 아닌 결정자가 존재하면 분해하는 것이 원칙

-- 교수는 강의실을 배정받지만, 강의실은 교수에만 종속 → 비정규 상태
CREATE TABLE ProfessorRoom_BCNF_Unnormalized (
    prof_id INT,
    room_id INT,	-- prof_id -> room_id (결정자지만 후보키가 아님) 
    course_id INT,
    PRIMARY KEY (prof_id, course_id)
);

-- 분해
CREATE TABLE ProfessorRoom (
    prof_id INT PRIMARY KEY,
    room_id INT
);

CREATE TABLE CourseAssignment (
    prof_id INT,
    course_id INT,
    PRIMARY KEY (prof_id, course_id)
);

-- 4NF: 다치 종속 제거
-- 하나의 속성에 대해 여러 독립된 다치 속성이 존재할 경우 분리
-- 두 개 이상의 독립적인 다대다 관계를 하나의 테이블에 표현되면 안됨 
-- 학생이 여러 과목과 활동을 동시에 가짐
-- subject activity ->독릭적으로 n:m
CREATE TABLE Student_Multivalued (
    student_id INT,
    subject VARCHAR(50),
    activity VARCHAR(50),
    PRIMARY KEY (student_id, subject, activity)
);

-- 분해
CREATE TABLE Student_Subject (
    student_id INT,
    subject VARCHAR(50),
    PRIMARY KEY (student_id, subject)
);

CREATE TABLE Student_Activity (
    student_id INT,
    activity VARCHAR(50),
    PRIMARY KEY (student_id, activity)
);

-- 5NF: 조인 종속 제거
-- 테이블이 여러개로 분리되도 원래의 정보가 손실되지 않도록 조인했을 경우도 보장되면 된다!
-- 제품이 부품, 공급자, 지역에 따라 분해되는 구조
CREATE TABLE Product_5NF (
    product_id INT,
    component_id INT,
    supplier_id INT,
    region_id INT,
    PRIMARY KEY (product_id, component_id, supplier_id, region_id)
);

-- 분해 예
CREATE TABLE Product_Component (
    product_id INT,
    component_id INT,
    PRIMARY KEY (product_id, component_id)
);

CREATE TABLE Component_Supplier (
    component_id INT,
    supplier_id INT,
    PRIMARY KEY (component_id, supplier_id)
);

CREATE TABLE Supplier_Region (
    supplier_id INT,
    region_id INT,
    PRIMARY KEY (supplier_id, region_id)
);