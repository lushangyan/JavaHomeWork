package com.lushangyan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lushangyan.entity.Orders;
import com.lushangyan.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class ShardingsphereTests {
    @Autowired
    private OrdersService orderService;

    @Test
    public void testInsert() {
        for (int i = 1; i <= 16; i++) {
            boolean save = orderService.save(buildOrder(i));
        }
        log.info("end");
    }

    @Test
    public void testSelectById() {
        for (int i = 1; i <= 16; i++) {
            Orders orders = orderService.getById(i);
            assertNotNull(orders);
            assertEquals(i, orders.getId());
        }
        log.info("end");
    }

    @Test
    public void testListAllOrders() {
        List<Orders> orders = new Orders().selectAll();
        assertNotNull(orders);
        assertEquals(32, orders.size());
    }



    @Test
    public void testDeleteById() {
        for (int i = 1; i <= 16; i++) {
            new Orders().deleteById(i);
        }
        log.info("end");
    }

    private Orders buildOrder(int id) {
        Orders order = new Orders();
        order.setId(id);
        order.setOrderNo(id+"");
        order.setShopId(id);
        order.setUserId(id);
        order.setUserName("userName");
        order.setAddress("广州市白云区");
        order.setPhone("137888" + id);
        order.setStatus(id);
        order.setGoodId(id);
        order.setGoodName("GoodName");
        order.setOrderTime(new Date());
        order.setUpdateTime(new Date());
        return order;
    }



}
