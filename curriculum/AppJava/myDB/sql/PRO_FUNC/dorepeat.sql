CREATE DEFINER=`juanpark`@`%` PROCEDURE `dorepeat`(p1 INT)
BEGIN
	-- 임시 테이블 생성해서 INT값 하나를 넣는 컬럼을 생성한다.
    -- 1~10까지 INSERT 한다.
    -- 결과 출력을 SELECT 해보자.
 SET @x = 0;
 DROP TEMPORARY TABLE IF EXISTS temp_numbers;
 CREATE TEMPORARY TABLE temp_numbers (
	num INT
);
 
 REPEAT
   SET @x = @x + 1;
   INSERT INTO temp_numbers VALUES(@x);
 UNTIL @x >= p1 END REPEAT;
END