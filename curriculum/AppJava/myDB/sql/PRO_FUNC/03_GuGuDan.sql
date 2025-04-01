CREATE DEFINER=`juanpark`@`%` PROCEDURE `03_GuGuDan`(IN p_dan INT)
-- KEYWORDS: IN, OUT, INOUT

BEGIN
WITH RECURSIVE GuGuDan AS (
-- [1] 초기값 지정 입력받은 단 * 1
SELECT p_dan AS DAN, 1 AS NUM, p_dan*1 AS RESULT

UNION ALL
-- [2] 재귀적으로 NUM을 1씩 증가 시키면서 9까지 반복한다.
SELECT DAN, NUM+1, DAN * (NUM + 1)
FROM GuGuDan
WHERE NUM < 9
);
-- [3] 전체 출력
SELECT CONCAT(DAN, " * ", NUM, " = ", RESULT) AS GuGuDan_PRN
FROM GuGuDan;
END