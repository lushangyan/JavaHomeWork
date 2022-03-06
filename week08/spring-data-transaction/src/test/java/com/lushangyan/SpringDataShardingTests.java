package com.lushangyan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lushangyan.entity.Orders;
import com.lushangyan.exception.RollbackException;
import com.lushangyan.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
class SpringDataShardingTests {
    @Autowired
    private OrdersService orderService;

    @Test
    public void testInsert() {
        for (int i = 1; i <= 16; i++) {
            new Orders().deleteById(i);
            TransactionType transactionType = orderService.insertMy(buildOrder(i));
            new Orders().deleteById(i);
            log.info("TransactionType: [{}]", transactionType); // XA
        }
        log.info("end");
    }

    @Test
    public void testInsertThenRollback() {
        Orders order1 = buildOrder(1);
        Orders order2 = buildOrder(2);
        try {
            orderService.insertThenRollback(Arrays.asList(order1, order2));
        } catch (RollbackException e) {
            log.error("failed", e);
        }

    }


    @Test
    public void testListAllOrders() {
        List<Orders> orders = new Orders().selectAll();
//        List<Orders> orders = orderService.list(new QueryWrapper<>());
        assertNotNull(orders);
        assertEquals(32, orders.size());
    }
    @Test
    public void testCountAllOrders() {
        int count = orderService.count(new QueryWrapper<>());
        assertEquals(32, count);
    }


    @Test
    public void testDeleteById() {
        for (int i = 1; i <= 32; i++) {
            new Orders().deleteById(i);
        }
        log.info("end");
    }

    @Test  //不支持批量操作 会报错
    public void testDeleteBatch() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= 32; i++) {
            ids.add(i);
        }
        orderService.removeByIds(ids);
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
