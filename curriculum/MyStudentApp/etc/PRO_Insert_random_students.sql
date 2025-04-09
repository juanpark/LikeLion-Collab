CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO_Insert_random_students`()
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE rand_name VARCHAR(50);
    DECLARE rand_major VARCHAR(50);
    DECLARE rand_grade INT;
    DECLARE major_index INT;
    WHILE i <= 100 DO
		-- 난수 이름 생성 (User_00)
        SET rand_name = CONCAT('User_', FLOOR(1 + RAND() * 9999));
        -- 난수 전공 생성
        SET major_index = FLOOR(1 + RAND() * 10); -- 1 ~ 10 사이 난수
        SET rand_major = CASE major_index
			WHEN 1 THEN '컴퓨터 공학'
            WHEN 2 THEN '로봇 공학'
            WHEN 3 THEN '경영'
            WHEN 4 THEN '미술'
            WHEN 5 THEN '건축'
            WHEN 6 THEN '한국사'
            WHEN 7 THEN '교육'
			WHEN 8 THEN '영어'
			WHEN 9 THEN '물리학'
			WHEN 10 THEN '경제학'
		END;
			
		-- 난수 점수 생성 (30점에서 100점 사이)
        SET rand_grade = FLOOR(30 + (RAND() * 71)); -- 30 + (0~70)
        
        -- INSETRT 실행
        INSERT INTO Student(name, major, grade)
        VALUES(rand_name, rand_major, rand_grade);
        SET i = i + 1;
	END WHILE;

END