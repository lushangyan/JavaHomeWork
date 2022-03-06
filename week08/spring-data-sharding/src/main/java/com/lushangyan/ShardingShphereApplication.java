package com.lushangyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.lushangyan.mapper.*")
@SpringBootApplication(scanBasePackages = {"com.lushangyan"})
public class ShardingShphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingShphereApplication.class, args);
    }


}
