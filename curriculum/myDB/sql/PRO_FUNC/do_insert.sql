CREATE DEFINER=`juanpark`@`%` PROCEDURE `do_insert`(value INT)
BEGIN
  -- Declare variables to hold diagnostics area information
  DECLARE code CHAR(5) DEFAULT '00000';
  DECLARE msg TEXT;
  DECLARE nrows INT;
  DECLARE result TEXT;
  -- Declare exception handler for failed insert : 변수에 오류 정보 저장
  DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    BEGIN
      GET DIAGNOSTICS CONDITION 1
        code = RETURNED_SQLSTATE, msg = MESSAGE_TEXT;
    END;

  -- Perform the insert : 실제 insert 실행
  INSERT INTO t1 (int_col) VALUES(value);
  -- Check whether the insert was successful
  IF code = '00000' THEN -- SQLSTATE 00000 -> True
    GET DIAGNOSTICS nrows = ROW_COUNT; -- 변경된 행의 수
    SET result = CONCAT('insert succeeded, row count = ',nrows); -- 성공 메시지
  ELSE
    SET result = CONCAT('insert failed, error = ',code,', message = ',msg); -- 실패 메시지
  END IF;
  -- Say what happened
  SELECT result;
END