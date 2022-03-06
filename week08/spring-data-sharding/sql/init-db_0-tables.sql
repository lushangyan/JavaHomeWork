CREATE SCHEMA IF NOT EXISTS `db-0` DEFAULT CHARACTER SET utf8mb4 ;
USE `db-0` ;

DROP TABLE IF EXISTS `db-0`.`orders_0` ;
create table IF NOT EXISTS `db-0`.`orders_0`
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

DROP TABLE IF EXISTS `db-0`.`orders_2` ;
create table IF NOT EXISTS `db-0`.`orders_2`
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

DROP TABLE IF EXISTS `db-0`.`orders_4` ;
create table IF NOT EXISTS `db-0`.`orders_4`
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

DROP TABLE IF EXISTS `db-0`.`orders_6` ;
create table IF NOT EXISTS `db-0`.`orders_6`
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

DROP TABLE IF EXISTS `db-0`.`orders_8` ;
create table IF NOT EXISTS `db-0`.`orders_8`
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

DROP TABLE IF EXISTS `db-0`.`orders_10` ;
create table IF NOT EXISTS `db-0`.`orders_10`
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

DROP TABLE IF EXISTS `db-0`.`orders_12` ;
create table IF NOT EXISTS `db-0`.`orders_12`
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

DROP TABLE IF EXISTS `db-0`.`orders_14` ;
create table IF NOT EXISTS `db-0`.`orders_14`
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

DROP TABLE IF EXISTS `db-0`.`orders_16` ;
create table IF NOT EXISTS `db-0`.`orders_16`
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

DROP TABLE IF EXISTS `db-0`.`orders_18` ;
create table IF NOT EXISTS `db-0`.`orders_18`
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

DROP TABLE IF EXISTS `db-0`.`orders_20` ;
create table IF NOT EXISTS `db-0`.`orders_20`
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

DROP TABLE IF EXISTS `db-0`.`orders_22` ;
create table IF NOT EXISTS `db-0`.`orders_22`
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

DROP TABLE IF EXISTS `db-0`.`orders_24` ;
create table IF NOT EXISTS `db-0`.`orders_24`
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

DROP TABLE IF EXISTS `db-0`.`orders_26` ;
create table IF NOT EXISTS `db-0`.`orders_26`
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

DROP TABLE IF EXISTS `db-0`.`orders_28` ;
create table IF NOT EXISTS `db-0`.`orders_28`
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

DROP TABLE IF EXISTS `db-0`.`orders_30` ;
create table IF NOT EXISTS `db-0`.`orders_30`
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