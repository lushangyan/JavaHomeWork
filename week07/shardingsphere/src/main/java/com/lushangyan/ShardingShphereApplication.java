package com.lushangyan;

import com.alibaba.fastjson.JSON;
import com.lushangyan.entity.Orders;
import com.lushangyan.entity.Shop;
import com.lushangyan.service.OrdersService;
import com.lushangyan.service.ShopService;
import groovyjarjarcommonscli.CommandLine;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lushangyan.mapper.*")
@SpringBootApplication(scanBasePackages = {"com.lushangyan"})
public class ShardingShphereApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ShardingShphereApplication.class, args);
    }


    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ShopService shopService;


    @Override
    public void run(String... args) throws Exception {
        //查询订单数据源
        Orders orders = ordersService.findById(1);
        System.out.println(JSON.toJSONString(orders));

        //查询店铺数据源
        Shop shop = shopService.findById(1);
        System.out.println(JSON.toJSONString(shop));
    }
}
