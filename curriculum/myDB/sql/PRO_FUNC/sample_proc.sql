CREATE DEFINER=`juanpark`@`%` PROCEDURE `sample_proc`(IN param1 INT, OUT result INT)
BEGIN
   SELECT param1 * 2 INTO result;
END