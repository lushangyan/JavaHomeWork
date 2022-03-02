package io.lushangyan.springrouting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("io.lushangyan.springrouting.mapper")
@SpringBootApplication
public class SpringroutingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringroutingApplication.class, args);
    }

}
