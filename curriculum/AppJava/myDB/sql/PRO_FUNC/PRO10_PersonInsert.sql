CREATE DEFINER=`juanpark`@`%` PROCEDURE `PRO10_PersonInsert`(IN num  INT)
BEGIN
   DECLARE   i INT DEFAULT  0;
   DECLARE   init_name   VARCHAR(50) DEFAULT  '이길동';
   DECLARE   init_addr VARCHAR(50)  DEFAULT  '서울';
   DECLARE   init_phone  VARCHAR(50) DEFAULT  '010-000-0000';
   DECLARE   current_name VARCHAR(50);

    WHILE i < num_records DO
        SET current_name = CONCAT(init_name, LPAD(i + 1, 3, '0')); 

        INSERT INTO person (name, address, phone) 
             VALUES (current_name, init_addr, init_phone);
        SET i = i + 1;
    END WHILE; 

END