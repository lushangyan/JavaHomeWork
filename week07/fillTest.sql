-- # 插入数据到订单表中，关闭自动提交，批量插入
DROP PROCEDURE IF EXISTS insert_orders_data_batch;
DELIMITER $
CREATE PROCEDURE insert_orders_data_batch()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=1;
    WHILE i<=1000000 DO
            insert into test.orders (order_no, shop_id, user_id,user_name, address, phone, status, good_id,good_name,order_time,update_time)
            VALUES (i, CEILING(rand()*100), CEILING(rand()*100),'user_name','address','13788888888',1,CEILING(rand()*100) ,'good_name',now() ,now());
            SET i = i+1;
END WHILE;
commit;
END $
CALL insert_orders_data_batch();

-- # 插入数据到订单表中，自动提交，一条一条的插入
DROP PROCEDURE IF EXISTS insert_orders_data_one;
DELIMITER $
CREATE PROCEDURE insert_orders_data_one()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=1000000 DO
            insert into test.orders (order_no, shop_id, user_id,user_name, address, phone, status, good_id,good_name,order_time,update_time)
            VALUES (i, CEILING(rand()*100), CEILING(rand()*100),'user_name','address','13788888888',1,CEILING(rand()*100) ,'good_name',now() ,now());
            SET i = i+1;
END WHILE;
END $
CALL insert_orders_data_one();


