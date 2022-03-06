CREATE SCHEMA IF NOT EXISTS `db-1` DEFAULT CHARACTER SET utf8mb4 ;
USE `db-1` ;

DROP TABLE IF EXISTS `db-1`.`orders_1` ;
create table IF NOT EXISTS `db-1`.`orders_1`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_3` ;
create table IF NOT EXISTS `db-1`.`orders_3`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_5` ;
create table IF NOT EXISTS `db-1`.`orders_5`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_7` ;
create table IF NOT EXISTS `db-1`.`orders_7`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_9` ;
create table IF NOT EXISTS `db-1`.`orders_9`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_11` ;
create table IF NOT EXISTS `db-1`.`orders_11`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_13` ;
create table IF NOT EXISTS `db-1`.`orders_13`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_15` ;
create table IF NOT EXISTS `db-1`.`orders_15`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_17` ;
create table IF NOT EXISTS `db-1`.`orders_17`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_19` ;
create table IF NOT EXISTS `db-1`.`orders_19`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_21` ;
create table IF NOT EXISTS `db-1`.`orders_21`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_23` ;
create table IF NOT EXISTS `db-1`.`orders_23`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_25` ;
create table IF NOT EXISTS `db-1`.`orders_25`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_27` ;
create table IF NOT EXISTS `db-1`.`orders_27`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_29` ;
create table IF NOT EXISTS `db-1`.`orders_29`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';

DROP TABLE IF EXISTS `db-1`.`orders_31` ;
create table IF NOT EXISTS `db-1`.`orders_31`
(
    id          int auto_increment primary key,
    order_no    varchar(255)   null comment '订单号',
    shop_id     int          null,
    user_id     int          not null,
    user_name   varchar(255) null comment '用户名',
    address     varchar(255) null comment '住址',
    phone       varchar(15)  null comment '电话',
    status      int          null comment '物流状态,0未发货1已发货2已签收3客服处理4退款',
    good_id     int          not null comment '商品id',
    good_name   varchar(255) null comment '商品名称',
    order_time  datetime     null comment '下单时间',
    update_time datetime     null comment '修改时间'
    )
    comment '订单主表';