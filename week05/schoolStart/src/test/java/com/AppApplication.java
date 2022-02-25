package com;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AppApplication{


    public static void main(String[] args) {
        new SpringApplicationBuilder(AppApplication.class).bannerMode(Banner.Mode.OFF).run(args);
    }

}

