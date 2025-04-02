CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO08_IF`(IN IN_SAL DECIMAL)
BEGIN
	-- 조건 TRUE, FALSE 판정 변수
	DECLARE FW INT;

	-- 사원의 존재 유무 확인
	SELECT COUNT(*)  INTO FW FROM EMP_TEST WHERE SAL >= IN_SAL;

	-- 입력받은 월급보다 많이 받는 사원의 이름과 급여를 출력하되, 존재하지 않으면 메시지를 출력하자.
	IF FW > 0 THEN
		SELECT ENAME, SAL
		FROM EMP_TEST
		WHERE SAL >= IN_SAL;
	ELSE
		-- 사원이 존재하지 않을 경우 메시지 출력
		SELECT "사원이 존재 하지 않는다" AS MESSAGE;
	END IF;
END