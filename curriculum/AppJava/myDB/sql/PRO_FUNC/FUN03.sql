CREATE DEFINER=`juanpark`@`%` FUNCTION `FUN03`(emp_name VARCHAR(50), hire_date DATE) RETURNS varchar(100) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
    RETURN CONCAT(emp_name, '은 ', DATE_FORMAT(hire_date, '%m월 %d일'), ' 입사했다');
END