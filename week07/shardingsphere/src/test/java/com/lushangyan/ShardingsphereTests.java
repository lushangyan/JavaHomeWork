package com.lushangyan;

import com.alibaba.fastjson.JSON;
import com.lushangyan.entity.Orders;
import com.lushangyan.entity.Shop;
import com.lushangyan.service.OrdersService;
import com.lushangyan.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingsphereTests {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ShopService shopService;

    @Test
    void mytest() {
        //查询订单数据源
        Orders orders = ordersService.findById(1);
        System.out.println(JSON.toJSONString(orders));

        //查询店铺数据源
        Shop shop = shopService.findById(1);
        System.out.println(JSON.toJSONString(shop));

    }




}
