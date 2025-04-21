CREATE DEFINER=`juanpark`@`%` PROCEDURE `my_calc`(IN a INT, IN b INT, OUT hap INT, OUT sub INT, OUT mul INT, OUT r_div DECIMAL(10,2))
BEGIN
	SET hap = A + B;
    SET sub = A - B;
    SET mul = A * B;
    IF B != 0 THEN
		SET r_div = A / B;
	ELSE
		SET r_div = NULL;
	END IF;
END