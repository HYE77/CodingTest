-- 코드를 입력하세요
SELECT MILK.CART_ID
FROM (SELECT CART_ID
    FROM CART_PRODUCTS
    WHERE NAME = 'Milk')  MILK INNER JOIN (SELECT CART_ID
                                      FROM CART_PRODUCTS
                                      WHERE NAME = 'Yogurt') YOGURT ON MILK.CART_ID = YOGURT.CART_ID