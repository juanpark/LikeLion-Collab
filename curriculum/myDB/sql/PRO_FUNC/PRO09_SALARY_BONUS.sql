CREATE DEFINER=`mydb`@`%` PROCEDURE `PRO09_SALARY_BONUS`(INOUT p_empno INT)
BEGIN
	DECLARE v_bonus INT; -- 임의 변수 선언
    -- 사원번호에 해당하는 급여 조회 후 계산
    
    -- 보너스 계산하기
    SELECT SAL + 1000 INTO v_bonus
    FROM EMP_TEST
    WHERE EMPNO = p_empno;
    
    -- 보너스 업데이트 하기
	UPDATE EMP_TEST
    SET SAL = v_bonus
    WHERE EMPNO = p_empno;
    
    COMMIT;
    
    -- INOUT 파라미터에 보너스를 넣어 반환
    SET p_empno = v_bonus;

END