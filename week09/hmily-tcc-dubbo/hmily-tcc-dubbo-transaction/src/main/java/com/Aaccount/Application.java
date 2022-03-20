/*
 * Copyright 2017-2021 Dromara.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Aaccount;

import com.Aaccount.service.AccountService;
import com.Baccount.service.MyAccountService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ImportResource;


/**
 * The DubboHmilyAccountApplication.
 *
 * @author xiaoyu
 */
@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
public class Application implements CommandLineRunner , ApplicationContextAware {

    //TODO 暂时不知道为什么注入不进来
    //TODO 还需要了解Hmily对数据库命名的使用
//    @Autowired
//    private MyAccountService myAccountService;
    @Autowired
    private AccountService accountService;

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static void main(final String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }
    @Override
    public void run(String... args) throws Exception {
        //人民币帐号加钱
        accountService.pay("1",7,0);
        //myAccountService.pay("2",-7,1);
    }





}
