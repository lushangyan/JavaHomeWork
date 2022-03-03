package io.lushangyan.springrouting;

import com.alibaba.fastjson.JSON;
import io.lushangyan.springrouting.datasource.CurDataSource;
import io.lushangyan.springrouting.datasource.DataSourceNames;
import io.lushangyan.springrouting.entity.Orders;
import io.lushangyan.springrouting.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

//@RunWith(SpringRunner.class)
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
    void mytest() {
        //插入默认走主库db0
        System.out.println("插入开始");
        Orders orders = new Orders();
        orders.setId(90);
        orders.setUserId(70);
        int i1 = ordersService.insert(orders);
        System.out.println(i1);
        System.out.println("插入结束");

        System.out.println("查询开始");
        //查询 使用注解切换从库
        Orders byId2 = ordersService.findOrderAnnotation(1);
        System.out.println(JSON.toJSONString(byId2));
    }




}
