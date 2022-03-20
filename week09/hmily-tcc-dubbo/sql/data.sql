
use hmily_account;
create table account
(
    id               int                                null,
    user_id          int                                null comment '用户id',
    cny_balance      int                                null comment '人名币余额',
    free_cny_balance int                                null comment '冻结人名币余额',
    do_balance       int                                null comment '美元余额',
    free_do_balance  int                                null comment '冻结美元余额',
    create_time      datetime default CURRENT_TIMESTAMP null,
    update_time      datetime default CURRENT_TIMESTAMP null
);
insert into account (id, user_id, cny_balance, free_cny_balance,do_balance,free_do_balance)
values (1, '1', 10, 0, 0 ,0);

use hmily_account_b;
create table account
(
    id               int                                null,
    user_id          int                                null comment '用户id',
    cny_balance      int                                null comment '人名币余额',
    free_cny_balance int                                null comment '冻结人名币余额',
    do_balance       int                                null comment '美元余额',
    free_do_balance  int                                null comment '冻结美元余额',
    create_time      datetime default CURRENT_TIMESTAMP null,
    update_time      datetime default CURRENT_TIMESTAMP null
);
insert into account (id, user_id, cny_balance, free_cny_balance,do_balance,free_do_balance)
values (1, '1', 10, 0, 0 ,0);



