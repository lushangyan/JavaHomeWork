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
     * 读写分离 - 动态切换数据源版本 1.0
     * 配置数据库主从复制 db0主库 db1从库
     * 测试时会输出当前使用的数据库名称，用这个来判断是否切换成功
     * insert插入 默认走主库
     * find查询   使用注解切换从库
     */
    @Test
    void inserOrder() {
        //插入默认走主库db0
        System.out.println("插入开始");
        for (int i = 1; i < 11; i++) {
            Orders orders = new Orders();
            orders.setId(i);
            orders.setUserId(1);
            int i1 = ordersService.insert(orders);
            System.out.println(i1);
        }
        System.out.println("插入结束");

        System.out.println("查询开始");
        //查询 使用注解切换从库
        Orders byId2 = ordersService.findUserByAnnotation(1);
        System.out.println(JSON.toJSONString(byId2));
    }




}
