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


    /**
     * 动态 切换数据源版本 1.0 进行测试
     * 测试时会打印当前使用的数据库名称，用这个来判断是否切换成功
     * insert插入 走默认数据源主库db0
     * find查询 根据注解指定，走从库db1
     */
    @Test
    void inserOrder() {
        //插入默认走主库db0
        for (int i = 1; i < 11; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setUserId(1);
            int i1 = ordersService.insert(orders);
            System.out.println(i1);
        }

        //插入使用注解指定从库插入
        for (int i = 10; i < 21; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setUserId(i);
            int i1 = ordersService.insertAnnotation(orders);
            System.out.println(i1);
        }

        //查询 根据注解指定，走从库db1
        Orders byId = ordersService.findUserByAnnotation(10);
        System.out.println(JSON.toJSONString(byId));
    }




}
