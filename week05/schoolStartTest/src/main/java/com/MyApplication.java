package com;

import com.starter.MySchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {


    public static void main(String[] args) {
        new SpringApplicationBuilder(MyApplication.class).bannerMode(Banner.Mode.OFF).run(args);
    }

    @Autowired
    private MySchool mySchool;
    @Override
    public void run(String... args) throws Exception {

        System.out.println(mySchool.toString());
    }
}

