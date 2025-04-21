CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO11_Insert_random_members`()
BEGIN
	DECLARE i INT DEFAULT 1;
    DECLARE rand_name VARCHAR(50);
    DECLARE rand_phone VARCHAR(20);
    DECLARE rand_date DATE;
    WHILE i <= 100 DO
		-- 난수 이름 생성 (User_00)
        SET rand_name = CONCAT('User_', FLOOR(1 + RAND() * 9999));
        -- 난수 전화번호 생성 (010-1234-5678)
        SET rand_phone = CONCAT('010-',
					LPAD(FLOOR(RAND() * 10000), 4, '0'), '-', LPAD(FLOOR(RAND() * 10000), 4, '0'));
		-- 난수 날짜 (2020-01-01 ~ 2024-12-31)
        SET rand_date = DATE_ADD('2020-01-01', INTERVAL FLOOR(RAND() * 1826) DAY);
        
        -- INSETRT 실행
        INSERT INTO random_members(name, phone, join_date)
        VALUES(rand_name, rand_phone, rand_date);
        SET i = i + 1;
	END WHILE;

END