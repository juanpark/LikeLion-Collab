CREATE DEFINER=`juanpark`@`%` PROCEDURE `doiterate`(p1 INT)
BEGIN
  label1: LOOP
    SET p1 = p1 + 1;
    IF p1 < 10 THEN
      ITERATE label1;	-- 조건이 TRUE이면 LOOP 처음으로 돌아가자
    END IF;
    LEAVE label1;		-- 조건이 FALSE이면 LOOP를 종료하자
  END LOOP label1;
  SET @x = p1;
END