package io.lushangyan.springrouting;

import com.alibaba.fastjson.JSON;
import io.lushangyan.springrouting.entity.Orders;
import io.lushangyan.springrouting.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringroutingApplicationTests {

    @Autowired
    private OrdersService ordersService;


    @Test
    void inserOrder() {
        //插入默认路由到db0数据库
        for (int i = 1; i < 11; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setUserId(1);
            int i1 = ordersService.insert(orders);
            System.out.println(i1);
        }

        //插入指定注解路由到db1数据库
        for (int i = 10; i < 21; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setUserId(i);
            int i1 = ordersService.insertAnnotation(orders);
            System.out.println(i1);
        }

        //查询使用注解实现，路由到db1进行查询
        Orders byId = ordersService.findUserByAnnotation(10);
        System.out.println(JSON.toJSONString(byId));
    }




}
