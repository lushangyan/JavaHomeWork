
create table good
(
    id        int auto_increment
        primary key,
    name      varchar(255)  null comment '商品名称',
    category  varchar(255)  null comment '类目',
    shop_id   int           not null comment '店铺id',
    shop_name varchar(255)  null comment '店铺名称',
    `desc`    varchar(1000) null comment '商品描述',
    status    int           not null comment '商品状态:0未上架,1已上架,2已下架,3缺货,4删除',
    stock     int           null comment '库存'
)
    comment '商品表';

create table `orders`
(
    id          int auto_increment
        primary key,
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
create index idx_good_id
    on orders (good_id);

create index idx_order_time
    on orders (order_time);

create index idx_phone
    on orders (phone);

create index idx_shop_id
    on orders (shop_id);

create index idx_update_time
    on orders (update_time);

create index idx_user_id
    on orders (user_id);


create table shop
(
    id        int auto_increment
        primary key,
    shop_name varchar(255) default '' not null
)
    comment '店铺表';

create table user
(
    id            int auto_increment
        primary key,
    user_name     varchar(255) null comment '用户姓名',
    user_password varchar(255) not null comment '密码',
    user_account  varchar(255) not null comment '用户账号',
    sex           tinyint      null comment '性别 0女1男',
    phone         int          null comment '电话',
    address       varchar(255) null comment '住址',
    e_mail        varchar(255) null comment '邮箱',
    constraint user_user_account_uindex
        unique (user_account)
)
    comment '用户表';
