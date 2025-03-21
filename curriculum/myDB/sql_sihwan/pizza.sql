CREATE TABLE pizza_price_cost (id INTEGER PRIMARY KEY, name TEXT, price INTEGER, cost INTEGER);
INSERT INTO pizza_price_cost VALUES (1, 'Potato Bacon Pizza', 22000, 14000);
INSERT INTO pizza_price_cost VALUES (2, 'Sweet Potato Pizza', 24000, 14000);
INSERT INTO pizza_price_cost VALUES (3, 'Combination Pizza', 25000, 13000);
INSERT INTO pizza_price_cost VALUES (4, 'Bacon Cheddar Pizza', 32000, 20000);
INSERT INTO pizza_price_cost VALUES (5, 'Pineapple Pizza', 25000, 22000);
INSERT INTO pizza_price_cost VALUES (6, 'Garlic Shrimp Pizza', 26000, 19000);
INSERT INTO pizza_price_cost VALUES (7, 'Cheeze Pizza', 23000, 17000);
INSERT INTO pizza_price_cost VALUES (8, 'Pepperoni Pizza', 24000, 13000);

SELECT * FROM pizza_price_cost;

/*
Q1. 
pizza_price_cost 테이블에는 피자의 가격(price)과 원가(cost)가 저장되어 있습니다. 
우리는 이 데이터를 활용하여 각 피자의 원가 대비 가격 비율을 분석하고, 효율성 기준으로 카테고리를 나누고자 합니다.
이를 통해 비용 대비 가격이 낮은 메뉴를 파악하고, 원가 절감 방안을 찾거나 가격을 조정하는 전략을 수립할 수 있습니다.

피자 이름(name) 컬럼

가격(price) 컬럼

효율성 컬럼-원가 대비 가격(price를 cost로 나눈 값)을 구해 주세요.-별칭은 efficiency로 설정해 주세요.
효율성 기준 카테고리 구분 컬럼
efficiency 값에 따라 아래와 같이 구분된 값을 넣어 주세요.
   1 이상 1.5 미만: 저효율 메뉴1.5 이상 1.7 미만: 중효율 메뉴1.7 이상: 고효율 메뉴
별칭은 efficiency_category로 설정해 주세요.
이때 전체 로우를 efficiency 컬럼 기준, 그 다음 price 컬럼 순서대로 오름차순 정렬해 주세요. 여기서 위에서 5번째 로우까지만 출력합니다.
*/

# 시환님 풀이:
SELECT 
    name, price,
    price / cost AS efficiency, 
    CASE 
        WHEN price / cost >= 1 AND price / cost < 1.5 THEN '저효율 메뉴'
        WHEN price / cost >= 1.5 AND price / cost < 1.7 THEN '중효율 메뉴'
        ELSE '고효율 메뉴'
    END AS efficiency_category
FROM 
    pizza_price_cost
ORDER BY 
    efficiency, price
LIMIT 5;

