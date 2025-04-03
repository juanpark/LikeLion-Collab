CREATE DEFINER=`juanpark`@`%` PROCEDURE `T3_INSERT`(IN row_count INT)
BEGIN
	DECLARE i INT DEFAULT 1;
    WHILE i <= row_count DO
		INSERT INTO MY_EMP.t3 (id, year_col)
					VALUES (i, 1995 + (i % 10)); -- 1995 ~ 2004
		SET i = i + 1;
	END WHILE;
END