CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO10_DO_INSERT`(IN value INT)
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
    ROLLBACK;
    -- 사용자 예외 정의 발생
    SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = '오류 발생 : INSERT 실패로 롤백이다';
	END;
    -- 트랜젝션 시작
    START TRANSACTION;
	INSERT INTO t1 (int_col) VALUES(value);
    COMMIT;
    
    -- 성공 메시지 출력
    SELECT CONCAT('성공 ', value, ' 추가했다.') AS MESSAGE;
    
END