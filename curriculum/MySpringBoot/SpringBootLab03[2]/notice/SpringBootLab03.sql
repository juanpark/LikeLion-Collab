
-- SpringBootLab03 공통 SQL 스크립트

-- 데이터베이스 생성
CREATE DATABASE IF NOT EXISTS spring_lab DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE spring_lab;

-- Member 테이블
CREATE TABLE IF NOT EXISTS member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) DEFAULT 'ROLE_USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Board 테이블
CREATE TABLE IF NOT EXISTS board (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    member_id BIGINT,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

-- Comment 테이블
CREATE TABLE IF NOT EXISTS comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    board_id BIGINT,
    member_id BIGINT,
    FOREIGN KEY (board_id) REFERENCES board(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

-- 초기 Member 데이터
INSERT INTO member (username, password, role) 
VALUES 
('admin', '$2a$10$7xvi6WbD.Ey7ZgWq5V22ke/YOdQ/FIhE9BysfnQACZW0lqzJFAcFG', 'ROLE_ADMIN'),
('user1', '$2a$10$y.l7E9x7.5d3.Ze7lF5/EuGtz5Kn/xH0oDB4AG.T5JoEPeHTf1Pti', 'ROLE_USER');

-- 초기 Board 데이터
INSERT INTO board (title, content, member_id) 
VALUES 
('첫 번째 게시글', '안녕하세요! SpringBootLab03 게시판입니다.', 1),
('두 번째 게시글', '테스트 게시글입니다.', 2),
('세 번째 게시글', '이건 세 번째 게시글이에요. Spring Security 실습 중입니다.', 1),
('네 번째 게시글', '게시판에 다양한 내용을 작성할 수 있습니다.', 2),
('다섯 번째 게시글', 'OAuth2 실습도 곧 시작합니다!', 1);

-- 초기 Comment 데이터
INSERT INTO comment (content, board_id, member_id) 
VALUES 
('첫 댓글입니다.', 1, 2),
('관리자 댓글입니다.', 1, 1),
('두 번째 게시글의 댓글입니다.', 2, 2),
('세 번째 게시글의 첫 댓글입니다.', 3, 2),
('세 번째 게시글의 관리자 댓글입니다.', 3, 1),
('네 번째 게시글의 첫 댓글입니다.', 4, 1),
('네 번째 게시글의 두 번째 댓글입니다.', 4, 2),
('다섯 번째 게시글의 댓글입니다.', 5, 2);
