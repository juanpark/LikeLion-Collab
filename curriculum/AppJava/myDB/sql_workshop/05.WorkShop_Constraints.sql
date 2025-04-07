-- 1. ECOMMERCE 스키마를 생성하시오.

CREATE SCHEMA ecommerce_temp
DEFAULT CHARACTER SET utf8mb4
DEFAULT COLLATE utf8mb4_general_ci;

USE ECOMMERCE_TEMP;

SHOW DATABASES;

SELECT *
FROM INFORMATION_SCHEMA.SCHEMATA
WHERE SCHEMA_NAME = 'ECOMMERCE';

-- CREATE THE TABLES
CREATE TABLE User (
	UserID VARCHAR(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Address TEXT,
    PhoneNumber VARCHAR(20),
    regDate TIMESTAMP
);

CREATE TABLE Product (
	ProductID INT PRIMARY KEY,
    CategoryID INT NOT NULL,
    ProductName VARCHAR(255) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    StockQuantity INT NOT NULL,
    Description TEXT,
    Manufacturer VARCHAR(100),
    regDate TIMESTAMP
);

CREATE TABLE `Order` ( -- Order is a reserved keyword in SQL, use backticks to use it as a name
	OrderID INT PRIMARY KEY,
    UserID INT,
    OrderDate TIMESTAMP NOT NULL,
    TotalAmount DECIMAL(10,2) NOT NULL,
    ShippingAddress TEXT,
    IsShipped BOOLEAN
);

CREATE TABLE OrderDetail (
	OrderDetailID INT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT NOT NULL
);

CREATE TABLE Category (
CategoryID INT PRIMARY KEY,
UpperCategory TEXT,
CategoryName VARCHAR(255) NOT NULL,
Description TEXT
);

CREATE TABLE Payment (
PaymentID INT PRIMARY KEY,
OrderID INT,
PaymentMethod VARCHAR(50) NOT NULL,
TransactionDate DATE NOT NULL,
PayAmount DECIMAL(10,2) NOT NULL,
IsSuccessful BOOLEAN
);

CREATE TABLE UserFavorite (
FavoriteID INT PRIMARY KEY,
UserID VARCHAR(255),
ProductID INT,
regDate TIMESTAMP
);

SHOW TABLES FROM ECOMMERCE_TEMP;

-- 2. 비밀번호가 123QWE!@#인 SHOP_WEB 사용자를 생성하시오
CREATE USER 'SHOP_WEB'@'localhost' IDENTIFIED BY '123QWE!@#';


-- 3. 비밀번호가 123QWE!@#인 SHOP_ADMIN 사용자를 생성하시오
CREATE USER 'SHOP_ADMIN'@'localhost' IDENTIFIED BY '123QWE!@#';

-- 4. SHOP_WEB 사용자에게 ECOMMERCE 스키마에 존재하는 모든 테이블에 대한 SELECT, INSERT, UPDATE, DELTE 권한을 부여하고 SHOW GRANTS 명령어를 사용해 확인 하시오
GRANT SELECT, INSERT, UPDATE, DELETE ON ecommerce_temp.* TO 'SHOP_WEB'@'localhost';

FLUSH PRIVILEGES;

SHOW GRANTS FOR 'SHOP_WEB'@'localhost';
REVOKE ALL PRIVILEGES ON ecommerce.* FROM 'SHOP_WEB'@'localhost';

SELECT user, host FROM mysql.user;

-- 5. SHOP_ADMIN 사용자에게 ECOMMERCE 스키마에 대한 모든 권한과, 해당 권한을 다른 사용자에게 부여할 수 있는 권한을 부여하시오. 이후 SHOW GRANTS 명령어를 사용해확인 하시오
GRANT ALL ON ecommerce_temp.* TO 'SHOP_ADMIN'@'localhost';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'SHOP_ADMIN'@'localhost';

-- 6. SHOP_WEB 의 INSERT 권한을 회수하고 SHOW GRANTS 명령어로 확인 하시오
REVOKE INSERT ON ecommerce_temp.* FROM 'SHOP_WEB'@'localhost';
SHOW GRANTS FOR 'SHOP_WEB'@'localhost';

-- 7. 'ROLE_WEB' 이란 이름을 가지는 ROLE 을 생성 하시오
CREATE ROLE 'ROLE_WEB'@'localhost';


-- 8. 'ROLE_WEB' 에 ECOMMERCE 스키마에 대한 SELECT, INSERT, UPDATE, DELETE, CREATE 권한을 부여하고 SHOW GRANTS 명령어를 사용해 확인 하시오.
GRANT SELECT, INSERT, UPDATE, DELETE ON ecommerce_temp.* TO 'ROLE_WEB'@'localhost';
SHOW GRANTS FOR 'ROLE_WEB'@'localhost';

-- 9. 'ROLE_WEB' ROLE 을 SHOP_WEB 사용자에게 부여 하시오.
GRANT 'ROLE_WEB'@'localhost' TO 'SHOP_WEB'@'localhost';

SELECT CURRENT_USER();

SELECT CURRENT_ROLE();

SELECT * FROM information_schema.APPLICABLE_ROLES;
SHOW GRANTS FOR 'SHOP_WEB'@'localhost';

-- 10. 'ROLW_WEB'을 SHOP_WEB 사용자로부터 회수 하시오.
REVOKE 'ROLE_WEB'@'localhost' FROM 'SHOP_WEB'@'localhost';
SHOW GRANTS FOR 'SHOP_WEB'@'localhost';

-- 11. 주어진 ERD 내용대로 USER, ORDER, CATEGORY 테이블을 생성 하시오. ORDER 와 CATEGORY 테이블의 기본키는 1 부터 시작하며 자동으로 1 씩 증가하도록 지정 하시오.

DROP TABLE IF EXISTS User;
SHOW TABLES;
CREATE TABLE User (
	UserID VARCHAR(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Address TEXT,
    PhoneNumber VARCHAR(20),
    regDate TIMESTAMP
);

DROP TABLE IF EXISTS `ORDER`;
SHOW TABLES;
CREATE TABLE `Order` ( -- Order is a reserved keyword in SQL, use backticks to use it as a name
	OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    OrderDate TIMESTAMP NOT NULL,
    TotalAmount DECIMAL(10,2) NOT NULL,
    ShippingAddress TEXT,
    IsShipped BOOLEAN
);
DESC `ORDER`;

DROP TABLE IF EXISTS Category;
SHOW TABLES;
CREATE TABLE Category (
CategoryID INT PRIMARY KEY AUTO_INCREMENT,
UpperCategory TEXT,
CategoryName VARCHAR(255) NOT NULL,
Description TEXT
);
DESC Category;

-- 12. 주어진 ERD 내용대로 USERFAVORITE 테이블을 생성 하시오. 이때 USERID 컬럼이 USER 테이블의 USERID 컬럼을 외래키로 참조하도록 하시오. 기본키는 1 부터 시작하며 자동으로 1 씩 증가하도록 지정 하시오.
DROP TABLE IF EXISTS UserFavorite;
SHOW TABLES;
CREATE TABLE UserFavorite (
FavoriteID INT PRIMARY KEY AUTO_INCREMENT,
UserID VARCHAR(255),
ProductID INT,
regDate TIMESTAMP,
FOREIGN KEY (UserID) REFERENCES User(UserID)
);
DESC UserFavorite;
SHOW CREATE TABLE UserFavorite;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'UserFavorite' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 13. 주어진 ERD 내용대로 ORDERDETAIL 테이블을 생성 하시오. 이때 ORDERID 컬럼이 ORDER 테이블의 ORDERID 컬럼을 외래키로 참조하도록 하시오. 기본키는 1 부터 시작하며 자동으로 1 씩 증가하도록 지정 하시오.
DROP TABLE IF EXISTS OrderDetail;
SHOW TABLES;
CREATE TABLE OrderDetail (
	OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)
);
DESC OrderDetail;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'OrderDetail' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 14. 주어진 ERD 내용대로 PAYMENT 테이블을 생성 하시오. 이때 ORDERID 컬럼이 ORDER 테이블의 ORDERID 컬럼을 외래키로 참조하도록 하시오. 기본키는 1 부터 시작하며 자동으로 1 씩 증가하도록 지정 하시오.
DROP TABLE IF EXISTS Payment;
SHOW TABLES;
CREATE TABLE Payment (
PaymentID INT PRIMARY KEY AUTO_INCREMENT,
OrderID INT,
PaymentMethod VARCHAR(50) NOT NULL,
TransactionDate DATE NOT NULL,
PayAmount DECIMAL(10,2) NOT NULL,
IsSuccessful BOOLEAN,
FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)
);
DESC Payment;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'Payment' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 15. 주어진 ERD 내용대로 PRODUCT 테이블을 생성 하시오. 이때 CATEGORYID 컬럼이 CATEGORY 테이블의 CATEGORYID 컬럼을 외래키로 참조하도록 하시오.
DROP TABLE IF EXISTS Product;
SHOW TABLES;
CREATE TABLE Product (
	ProductID INT PRIMARY KEY,
    CategoryID INT NOT NULL,
    ProductName VARCHAR(255) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    StockQuantity INT NOT NULL,
    Description TEXT,
    Manufacturer VARCHAR(100),
    regDate TIMESTAMP,
    FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);
DESC Product;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'Product' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 16. ALTER 구문을 사용하여 USER 테이블의 EMAIL 컬럼에 UNIQUE 제약조건을 지정하시오.
DESC User;
ALTER TABLE User 
ADD CONSTRAINT unique_email UNIQUE (Email);
DESC User;

-- 17. USER 테이블의 USERNAME 컬럼에 NOT NULL 제약조건 추가 하시오.
DESC User;
ALTER TABLE User 
MODIFY Username VARCHAR(255) NOT NULL;
DESC User;

-- 18. ALTER 구문을 사용하여 PRODUCT 테이블의 STOCKQUANTITY 컬럼의 DEFAULT 값을 0 으로 지정 하시오.
DESC Product;
ALTER TABLE Product
MODIFY StockQuantity INT NOT NULL DEFAULT 0;
DESC Product;

-- 19. ALTER 구문을 사용하여 PRODUCT 테이블의 STOCKQUANTITY 컬럼에 0 미만의 값이 들어갈 수 없도록 CHECK 제약조건을 지정 하시오.
ALTER TABLE Product
ADD CONSTRAINT check_stockquantity CHECK (StockQuantity >= 0);
DESC Product;
SELECT *
FROM information_schema.CHECK_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'ecommerce_temp';
SELECT *
FROM information_schema.TABLE_CONSTRAINTS
WHERE TABLE_NAME = 'Product'
  AND CONSTRAINT_TYPE = 'CHECK';
  
-- 20. PRODUCT 테이블의 PRODUCTNAME 컬럼에 NOT NULL 제약 조건 추가 하시오.
DESC Product;
ALTER TABLE Product
MODIFY ProductName varchar(255) NOT NULL;
DESC Product;

-- 21. PAYMENT 테이블에 TRANSACTIONDATE 컬럼을 TIMESTAMP 타입으로 변경 하시오.
DESC Payment;
ALTER TABLE Payment
MODIFY TransactionDate TIMESTAMP;
DESC Payment;

-- 22. CATEGORY 테이블에 UPPERCATEGORY 컬럼을 INT 타입으로 변경 하시오.
DESC Category;
ALTER TABLE Category
MODIFY UpperCategory INT;
DESC Category;

-- 23. CATEGORY 테이블에 DESCRIPTION 컬럼에 NOT NULL 제약조건을 추가 하시오.
DESC Category;
ALTER TABLE Category
MODIFY Description TEXT NOT NULL;
DESC Category;

-- 24. USERFAVORITE 테이블에 지정되어 있는 외래키 제약조건을 삭제 하시오.
DESC UserFavorite;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'UserFavorite' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';
SHOW CREATE TABLE UserFavorite;
-- 'UserFavorite', 'CREATE TABLE 
-- `UserFavorite` (\n  `FavoriteID` int NOT NULL AUTO_INCREMENT,\n  
-- `UserID` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,\n  
-- `ProductID` int DEFAULT NULL,\n  
-- `regDate` timestamp NULL DEFAULT NULL,\n  
-- PRIMARY KEY (`FavoriteID`),\n  KEY `UserID` (`UserID`),\n  
-- CONSTRAINT `userfavorite_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `User` (`UserID`)\n) 
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci'

ALTER TABLE UserFavorite
DROP FOREIGN KEY userfavorite_ibfk_1;

DESC UserFavorite;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'UserFavorite' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- still see MUL in UserID column even after dropping FK
SHOW INDEXES FROM UserFavorite;

ALTER TABLE UserFavorite
DROP INDEX UserID; -- this workes, 1. drop FK, 2. then drop index
DESC UserFavorite;

-- 25. USERFAVORITE 테이블의 USERID 컬럼이 USER 테이블의 USERID 컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은
-- 'FK_USER_USERFAVORITE' 이며 USER 테이블의 튜플이 생략될 경우 해당 튜플을 참조하고 있는 USERFAVORITE 테이블 튜플의 USERID 컬럼 값은 NULL 이 들어가도록
-- 지정 하시오.
DESC UserFavorite;
ALTER TABLE UserFavorite
MODIFY UserID VARCHAR(255) NULL,
ADD CONSTRAINT FK_USER_USERFAVORITE FOREIGN KEY (UserID) REFERENCES User(UserID);

DESC UserFavorite;
SELECT * 
FROM information_schema.KEY_COLUMN_USAGE 
WHERE TABLE_NAME = 'UserFavorite' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 26. PAYMENT 테이블에 지정되어 있는 외래키제약조건을 삭제 하시오.
DESC Payment;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Payment' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

ALTER TABLE Payment
DROP FOREIGN KEY payment_ibfk_1;
ALTER TABLE Payment
DROP INDEX OrderID; -- this workes, 1. drop FK, 2. then drop index

DESC Payment;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Payment' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 27. PAYMENT 테이블의 ORDERID 컬럼이 ORDER 테이블의 ORDERID 컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은
-- 'FK_ORDER_PAYMENT' 이며 ORDER 테이블의 튜플이 생략될 경우 해당 튜플을 참조하고 있는 PAYMENT 테이블 튜플도 함께 삭제되도록 하시오.
DESC Payment;

ALTER TABLE Payment
MODIFY OrderID INT NULL,
ADD CONSTRAINT FK_ORDER_PAYMENT FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)
ON DELETE CASCADE;

DESC Payment;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Payment' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'ecommerce_temp' AND TABLE_NAME = 'Payment';

-- 28. ORDERDETAIL 테이블에 지정되어 있는 외래키제약조건을 삭제 하시오.
DESC OrderDetail;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'OrderDetail' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

ALTER TABLE OrderDetail
DROP FOREIGN KEY orderdetail_ibfk_1;
ALTER TABLE OrderDetail
DROP INDEX OrderID; -- this workes, 1. drop FK, 2. then drop index

DESC OrderDetail;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'OrderDetail' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 29. ORDERDETAIL 테이블의 ORDERID 컬럼이 ORDER 테이블의 ORDERID 컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은
-- 'FK_ORDER_ORDERDETAIL' 이며 ORDER 테이블의 튜플이 수정될 경우 해당 튜플을 참조하고 있는 PAYMENT 테이블 튜플의 ORDERID 컬럼의 값에 NULL 이 들어가도록 지정하시오.
ALTER TABLE OrderDetail
MODIFY OrderID INT NULL,
ADD CONSTRAINT FK_ORDER_ORDERDETAIL FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID)
ON UPDATE SET NULL;

DESC OrderDetail;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'OrderDetail' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'ecommerce_temp' AND TABLE_NAME = 'OrderDetail';

-- 30. PRODUCT 테이블에서 기존의 외래키제약조건을 삭제하고 CATEGORYID 컬럼이 CATEGORY 테이블의 CATEGORYID 컬럼을 외래키로 참조하도록 새로운
-- 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은 'FK_CATEGORY_PRODUCT' 이며 CATEGORY 테이블의 튜플이 수정될 경우 해당 튜플을 참조하고 있는 PRODUCT
-- 테이블 튜플의 CATEGORYID 컬럼의 값이 함께 수정되도록 지정 하시오. *. 하나의 쿼리로 작성하시오.
DESC Product;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Product' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

ALTER TABLE Product
DROP FOREIGN KEY product_ibfk_1,
MODIFY CategoryID INT NOT NULL,
ADD CONSTRAINT FK_CATEGORY_PRODUCT FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
ON UPDATE CASCADE;

DESC Product;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'Product' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

SELECT CONSTRAINT_NAME, UPDATE_RULE, DELETE_RULE
FROM information_schema.REFERENTIAL_CONSTRAINTS
WHERE CONSTRAINT_SCHEMA = 'ecommerce_temp' AND TABLE_NAME = 'Product';

-- 31. USER 테이블의 PHONENUMBER 컬럼의 크기를 VARCHAR(15)로 수정 하시오.
DESC User;

ALTER TABLE User
MODIFY PhoneNumber VARCHAR(15) NULL;

DESC USER;

-- 32. USER 테이블에 BIRTHDATE 컬럼을 추가 하시오.
DESC User;

ALTER TABLE User
ADD COLUMN BirthDate DATE;

DESC User;

-- 33. PRODUCT 테이블에 WEIGHT 컬럼을 추가 하시오. 
DESC Product;

ALTER TABLE Product
ADD COLUMN Weight INT;

DESC Product;

-- 34. USER 테이블에 BIRTHDATE 컬럼을 삭제 하시오.
DESC User;

ALTER TABLE User
DROP COLUMN BirthDate;

DESC User;

-- 35. PRODUCT 테이블에 WEIGHT 컬럼을 삭제 하시오.
DESC Product;

ALTER TABLE Product
DROP COLUMN Weight;

DESC Product;

-- 36. USER 테이블의 USERNAME 과 EMAIL 컬럼의 순서를 변경 하시오.
DESC User;

ALTER TABLE User
MODIFY COLUMN Username VARCHAR(255) NOT NULL AFTER Email; 

DESC User;

-- 37. USER 테이블의 REGDATE 컬럼의 이름을 CREATEDAT 으로 변경 하시오.
ALTER TABLE User
RENAME COLUMN regDate TO createDate;

DESC User;

-- 38. ORDERDETAIL 테이블의 PRIMARY KEY 를 (ORDERID, PRODUCTID)의 복합키로 변경 하시오.
DESC OrderDetail;

ALTER TABLE OrderDetail
MODIFY ProductID INT NOT NULL, -- 복합키의 경우 컬럼이 NOT NULL이어야 함
DROP Primary KEY,
ADD PRIMARY KEY (OrderDetailID, ProductID);

DESC OrderDetail;
SELECT *
FROM information_schema.KEY_COLUMN_USAGE
WHERE TABLE_NAME = 'OrderDetail' AND CONSTRAINT_SCHEMA = 'ecommerce_temp';

-- 39. PAYMENT 테이블의 TRASACTIONDATE 컬럼의 DEFAULT 값을 행이 삽입될때 날짜와 시간으로 지정하고, 만약 해당 튜플이 수정 될 경우 수정시간으로 자동으로 변경되도록 하시오.
DESC Payment;

ALTER TABLE Payment
MODIFY TransactionDate timestamp 
DEFAULT CURRENT_TIMESTAMP NOT NULL
ON UPDATE CURRENT_TIMESTAMP;

DESC Payment;

-- 40 . PRODUCT, ORDERDETAIL, USERFAVORITE, PAYMENT , USER, ORDER, CATEGORY 테이블을 삭제 하시오.
SHOW TABLES FROM ECOMMERCE_TEMP;

DROP TABLE PRODUCT, ORDERDETAIL, USERFAVORITE, PAYMENT, USER, `ORDER`, CATEGORY;

SHOW TABLES FROM ECOMMERCE_TEMP;