INSERT INTO post (title, content) VALUES 
('Spring 이벤트 게시판', '이벤트 기반 구조를 연습합니다.'),
('두 번째 게시글', '댓글 기능을 테스트할 예정입니다.');

INSERT INTO comment (post_id, writer, content) VALUES
(1, 'kim', '좋은 글이에요!'),
(1, 'lee', '비동기 이벤트 테스트 중입니다.'),
(2, 'park', '삭제 이벤트가 작동할까요?');
