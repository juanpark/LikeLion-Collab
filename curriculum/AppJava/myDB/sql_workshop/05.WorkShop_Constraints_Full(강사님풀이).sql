-- 1. ECOMMERCE 스키마를 생성하시오.
CREATE SCHEMA ECOMMERCE;

use ECOMMERCE;
-- 2. 비밀번호가 123QWE!@#인 SHOP_WEB 사용자를 생성하시오
CREATE USER 'SHOP_WEB'@'%' IDENTIFIED BY '123QWE!@#';

-- 3. 비밀번호가 123QWE!@#인 SHOP_ADMIN 사용자를 생성하시오
CREATE USER 'SHOP_ADMIN'@'%' IDENTIFIED BY '123QWE!@#';

-- 4. SHOP_WEB 사용자에게 ECOMMERCE 스키마에 존재하는 모든 테이블에 대한 SELECT, INSERT, UPDATE, DELTE 권한을 부여하고 SHOW GRANTS 명령어를 사용해 확인 하시오
GRANT SELECT, INSERT, UPDATE, DELETE ON ECOMMERCE.* TO 'SHOP_WEB'@'%';
SHOW GRANTS FOR 'SHOP_WEB'@'%';

-- 5. SHOP_ADMIN 사용자에게 ECOMMERCE 스키마에 대한 모든 권한과, 해당 권한을 다른 사용자에게 부여할 수 있는 권한을 부여하시오. 이후 SHOW GRANTS 명령어를 사용해 확인 하시오
GRANT ALL PRIVILEGES ON ECOMMERCE.* TO 'SHOP_ADMIN'@'%' WITH GRANT OPTION;
SHOW GRANTS FOR 'SHOP_ADMIN'@'%';

-- 6. SHOP_WEB의 INSERT 권한을 회수하고 SHOW GRANTS 명령어로 확인 하시오
REVOKE INSERT ON ECOMMERCE.* FROM 'SHOP_WEB'@'%';
SHOW GRANTS FOR 'SHOP_WEB'@'%';

-- 7. 'ROLE_WEB' 이란 이름을 가지는 ROLE을 생성 하시오
CREATE ROLE 'ROLE_WEB';

-- 8. 'ROLE_WEB' 에 ECOMMERCE 스키마에 대한 SELECT, INSERT, UPDATE, DELETE, CREATE 권한을 부여하고 SHOW GRANTS 명령어를 사용해 확인 하시오.
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE ON ECOMMERCE.* TO 'ROLE_WEB';
SHOW GRANTS FOR 'ROLE_WEB';

-- 9. 'ROLE_WEB' ROLE을 SHOP_WEB 사용자에게 부여 하시오.
GRANT 'ROLE_WEB' TO 'SHOP_WEB'@'%';

-- 10. 'ROLW_WEB'을 SHOP_WEB 사용자로부터 회수 하시오.
REVOKE 'ROLE_WEB' FROM 'SHOP_WEB'@'%';

-- 11. 주어진 ERD 내용대로 USER, ORDER, CATEGORY 테이블을 생성 하시오.
-- ORDER와 CATEGORY 테이블의 기본키는 1부터 시작하며 자동으로 1씩 증가하도록 지정 하시오.
CREATE TABLE ECOMMERCE.User (
    UserID VARCHAR(255) PRIMARY KEY,
    Username VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    Address TEXT,
    PhoneNumber VARCHAR(20),
    regDate TIMESTAMP
);
CREATE TABLE ECOMMERCE.Order (
    OrderID INT PRIMARY KEY AUTO_INCREMENT,
    UserID INT,
    OrderDate TIMESTAMP NOT NULL,
    TotalAmount DECIMAL(10,2) NOT NULL,
    ShippingAddress TEXT,
    IsShipped BOOLEAN
);
CREATE TABLE ECOMMERCE.Category (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT,
    UpperCategory TEXT,
    CategoryName VARCHAR(255) NOT NULL,
    Description TEXT
);

-- 12. 주어진 ERD 내용대로 USERFAVORITE 테이블을 생성 하시오. 이때 USERID컬럼이 USER 테이블의 USERID컬럼을 외래키로 참조하도록 하시오. 기본키는 1부터 시작하며 자동으로 1씩 증가하도록 지정 하시오.
CREATE TABLE ECOMMERCE.UserFavorite (
    FavoriteID INT PRIMARY KEY AUTO_INCREMENT,
    UserID VARCHAR(255),
    ProductID INT,
    regDate TIMESTAMP,
    FOREIGN KEY (UserID) REFERENCES ECOMMERCE.User(UserID)
);

-- 13. 주어진 ERD 내용대로 ORDERDETAIL 테이블을 생성 하시오. 이때 ORDERID컬럼이 ORDER 테이블의 ORDERID 컬럼을 외래키로 참조하도록 하시오. 기본키는 1부터 시작하며 자동으로 1씩 증가하도록 지정 하시오.
CREATE TABLE ECOMMERCE.OrderDetail (
    OrderDetailID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    ProductID INT,
    Quantity INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES ECOMMERCE.Order(OrderID)
);

-- 14. 주어진 ERD 내용대로 PAYMENT 테이블을 생성 하시오. 이때 ORDERID컬럼이 ORDER 테이블의 ORDERID컬럼을 외래키로 참조하도록 하시오. 기본키는 1부터 시작하며 자동으로 1씩 증가하도록 지정 하시오.
CREATE TABLE ECOMMERCE.Payment (
    PaymentID INT PRIMARY KEY AUTO_INCREMENT,
    OrderID INT,
    PaymentMethod VARCHAR(50) NOT NULL,
    TransactionDate DATE NOT NULL,
    PayAmount DECIMAL(10,2) NOT NULL,
    IsSuccessful BOOLEAN,
    FOREIGN KEY (OrderID) REFERENCES ECOMMERCE.Order(OrderID)
);

-- 15. 주어진 ERD 내용대로 PRODUCT 테이블을 생성 하시오. 이때 CATEGORYID컬럼이 CATEGORY 테이블의 CATEGORYID 컬럼을 외래키로 참조하도록 하시오.
CREATE TABLE ECOMMERCE.Product (
    ProductID INT PRIMARY KEY AUTO_INCREMENT,
    CategoryID INT NOT NULL,
    ProductName VARCHAR(255) NOT NULL,
    Price DECIMAL(10,2) NOT NULL,
    StockQuantity INT NOT NULL,
    Description TEXT,
    Manufacturer VARCHAR(100),
    regDate TIMESTAMP,
    FOREIGN KEY (CategoryID) REFERENCES ECOMMERCE.Category(CategoryID)
);

-- 16. ALTER 구문을 사용하여 USER 테이블의 EMAIL 컬럼에 UNIQUE 제약조건을 지정 하시오.
ALTER TABLE ECOMMERCE.User ADD UNIQUE (Email);

-- 17. USER 테이블의 USERNAME 컬럼에 NOT NULL 제약조건 추가 하시오.
ALTER TABLE ECOMMERCE.User MODIFY COLUMN Username VARCHAR(255) NOT NULL;

-- 18. ALTER 구문을 사용하여 PRODUCT 테이블의 STOCKQUANTITY 컬럼의 DEFAULT 값을 0으로 지정 하시오.
ALTER TABLE ECOMMERCE.Product ALTER COLUMN StockQuantity SET DEFAULT 0;

-- 19. ALTER 구문을 사용하여 PRODUCT 테이블의 STOCKQUANTITY 컬럼에 0미만의 값이 들어갈 수 없도록 CHECK 제약조건을 지정 하시오.
ALTER TABLE ECOMMERCE.Product ADD CONSTRAINT CK_StockQuantity CHECK (StockQuantity >= 0);

-- 20. PRODUCT 테이블의 PRODUCTNAME 컬럼에 NOT NULL 제약 조건 추가 하시오.
ALTER TABLE ECOMMERCE.Product MODIFY COLUMN ProductName VARCHAR(255) NOT NULL;

-- 21. PAYMENT 테이블에 TRANSACTIONDATE 컬럼을 TIMESTAMP 타입으로 변경 하시오.
ALTER TABLE ECOMMERCE.Payment MODIFY COLUMN TransactionDate TIMESTAMP;

-- 22. CATEGORY 테이블에 UPPERCATEGORY 컬럼을 INT 타입으로 변경 하시오.
ALTER TABLE ECOMMERCE.Category MODIFY COLUMN UpperCategory INT;

-- 23. CATEGORY 테이블에 DESCRIPTION 컬럼에 NOT NULL 제약조건을 추가 하시오.
ALTER TABLE ECOMMERCE.Category MODIFY COLUMN Description TEXT NOT NULL;

-- 24. USERFAVORITE 테이블에 지정되어 있는 외래키 제약조건을 삭제 하시오.
ALTER TABLE ECOMMERCE.UserFavorite DROP FOREIGN KEY UserFavorite_ibfk_1; -- 실제 외래키 이름 확인 후 수정

-- 25. USERFAVORITE 테이블의 USERID컬럼이 USER 테이블의 USERID 컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은 'FK_USER_USERFAVORITE' 이며 USER테이블의 튜플이 생략될 경우 해당 튜플을 참조하고 있는 USERFAVORITE 테이블 튜플의 USERID컬럼 값은 NULL이 들어가도록 지정 하시오.
ALTER TABLE ECOMMERCE.UserFavorite ADD CONSTRAINT FK_USER_USERFAVORITE FOREIGN KEY (UserID) REFERENCES ECOMMERCE.User(UserID) ON DELETE SET NULL;

-- 26. PAYMENT 테이블에 지정되어 있는 외래키제약조건을 삭제 하시오.
ALTER TABLE ECOMMERCE.Payment DROP FOREIGN KEY Payment_ibfk_1; -- 실제 외래키 이름 확인 후 수정

-- 27. PAYMENT 테이블의 ORDERID컬럼이 ORDER테이블의 ORDERID컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은 'FK_ORDER_PAYMENT' 이며 ORDER테이블의 튜플이 생략될 경우 해당 튜플을 참조하고 있는 PAYMENT 테이블 튜플도 함께 삭제되도록 하시오.
ALTER TABLE ECOMMERCE.Payment ADD CONSTRAINT FK_ORDER_PAYMENT FOREIGN KEY (OrderID) REFERENCES ECOMMERCE.Order(OrderID) ON DELETE CASCADE;

-- 28. ORDERDETAIL 테이블에 지정되어 있는 외래키제약조건을 삭제 하시오.
ALTER TABLE ECOMMERCE.OrderDetail DROP FOREIGN KEY OrderDetail_ibfk_1; -- 실제 외래키 이름 확인 후 수정

-- 29. ORDERDETAIL 테이블의 ORDERID컬럼이 ORDER테이블의 ORDERID컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은 'FK_ORDER_ORDERDETAIL' 이며 ORDER테이블의 튜플이 수정될 경우 해당 튜플을 참조하고 있는 PAYMENT 테이블 튜플의 ORDERID컬럼의 값에 NULL이 들어가도록 지정 하시오.
ALTER TABLE ECOMMERCE.OrderDetail ADD CONSTRAINT FK_ORDER_ORDERDETAIL FOREIGN KEY (OrderID) REFERENCES ECOMMERCE.Order(OrderID) ON UPDATE SET NULL;

-- 30. PRODUCT 테이블에서 기존의 외래키제약조건을 삭제하고 CATEGORYID컬럼이 CATEGORY테이블의 CATEGORYID컬럼을 외래키로 참조하도록 새로운 외래키제약조건을 추가 하시오. 외래키제약조건의 이름은 'FK_CATEGORY_PRODUCT' 이며 CATEGORY테이블의 튜플이 수정될 경우 해당 튜플을 참조하고 있는 PRODUCT 테이블 튜플의 CATEGORYID컬럼의 값이 함께 수정되도록 지정 하시오. *. 하나의 쿼리로 작성하시오.
ALTER TABLE ECOMMERCE.Product DROP FOREIGN KEY Product_ibfk_1, ADD CONSTRAINT FK_CATEGORY_PRODUCT FOREIGN KEY (CategoryID) REFERENCES ECOMMERCE.Category(CategoryID) ON UPDATE CASCADE; -- 실제 외래키 이름 확인 후 수정

-- 31. USER테이블의 PHONENUMBER 컬럼의 크기를 VARCHAR(15)로 수정 하시오.
ALTER TABLE ECOMMERCE.User MODIFY COLUMN PhoneNumber VARCHAR(15);

-- 32. USER 테이블에 BIRTHDATE 컬럼을 추가 하시오.
ALTER TABLE ECOMMERCE.User ADD COLUMN BIRTHDATE DATE;

-- 33. PRODUCT 테이블에 WEIGHT 컬럼을 추가 하시오.
ALTER TABLE ECOMMERCE.Product ADD COLUMN WEIGHT DECIMAL(5,2);

-- 34. USER 테이블에 BIRTHDATE 컬럼을 삭제 하시오.
ALTER TABLE ECOMMERCE.User DROP COLUMN BIRTHDATE;

-- 35. PRODUCT 테이블에 WEIGHT 컬럼을 삭제 하시오.
ALTER TABLE ECOMMERCE.Product DROP COLUMN WEIGHT;

-- 36. USER 테이블의 USERNAME과 EMAIL 컬럼의 순서를 변경 하시오.
ALTER TABLE ECOMMERCE.User MODIFY COLUMN USERNAME VARCHAR(255) AFTER UserID, MODIFY COLUMN EMAIL VARCHAR(255) AFTER USERNAME;

-- 37. USER 테이블의 REGDATE 컬럼의 이름을 CREATEDAT으로 변경 하시오.
ALTER TABLE ECOMMERCE.User CHANGE COLUMN regDate CREATEDAT TIMESTAMP;

-- 38. ORDERDETAIL테이블의 PRIMARY KEY를 (ORDERID, PRODUCTID)의 복합키로 변경 하시오.
/*OrderDetailID 컬럼을 유지하면서 복합 UNIQUE 키를 추가할지, 아니면 AUTO_INCREMENT 속성을 제거하고 복합 PRIMARY KEY로 변경할지 결정하여 해당 SQL 구문을 사용
*/
-- case 1:  기존 OrderDetailID 유지 및 UNIQUE 키 추가
ALTER TABLE ECOMMERCE.OrderDetail
ADD UNIQUE KEY (OrderID, ProductID);

-- case 2:OrderDetailID의 AUTO_INCREMENT 제거 후 복합 기본 키 설정
ALTER TABLE ECOMMERCE.OrderDetail MODIFY COLUMN OrderDetailID INT;
ALTER TABLE ECOMMERCE.OrderDetail DROP PRIMARY KEY, ADD PRIMARY KEY (OrderID, ProductID);

-- 39. PAYMENT 테이블의 TRASACTIONDATE 컬럼의 DEFAULT 값을 행이 삽입될때 날짜와 시간으로 지정하고, 만약 해당 튜플이 수정 될 경우 수정시간으로 자동으로 변경되도록 하시오.
ALTER TABLE ECOMMERCE.Payment MODIFY COLUMN TransactionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

-- 40 . PRODUCT, ORDERDETAIL, USERFAVORITE, PAYMENT , USER, ORDER, CATEGORY 테이블을 삭제 하시오.
DROP TABLE ECOMMERCE.USERFAVORITE;
DROP TABLE ECOMMERCE.ORDERDETAIL;
DROP TABLE ECOMMERCE.PAYMENT;
DROP TABLE ECOMMERCE.PRODUCT;
DROP TABLE ECOMMERCE.ORDER;
DROP TABLE ECOMMERCE.USER;
DROP TABLE ECOMMERCE.CATEGORY;
