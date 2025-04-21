CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO09_IF`(IN RATE DECIMAL(5,2))
BEGIN
	-- 비율이 0 보다 작으면 예외 발생 : SIGNAL _예외발생키원드
    IF RATE <= 0 THEN
		SIGNAL SQLSTATE '45000'  -- 일반적인 사용자 오류 코드
        SET MESSAGE_TEXT = '급여 인상 비율은 0보다 커야 합니다.';
	END IF;
    
    -- 급여의 인상 처리
    SET SQL_SAFE_UPDATES = 0;
    UPDATE EMP_TEST
    SET SAL = SAL + (SAL * RATE);
	SET SQL_SAFE_UPDATES = 1;
    
    -- 변경 결과 확인
    SELECT ENAME, SAL FROM EMP_TEST;
END