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

package com.Baccount.service;

import com.Baccount.entity.AccountDTO;
import com.Baccount.mapper.AccountMapper;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Account service.
 *
 * @author xiaoyu
 */
@Service("myAccountService")
public class MyAccountServiceImpl implements MyAccountService {


    private static final Logger LOGGER = LoggerFactory.getLogger(MyAccountServiceImpl.class);

    /**
     * The Confrim count.
     */
    private static AtomicInteger confrimCount = new AtomicInteger(0);

    private final AccountMapper accountMapper;


    @Autowired(required = false)
    public MyAccountServiceImpl(final AccountMapper accountMapper ){
        this.accountMapper = accountMapper;

    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean pay(String userId,Integer cnyAmount,Integer doAmount) {
        int count = accountMapper.update(userId,cnyAmount,doAmount);
        if (count > 0 ) {
            return true;
        } else {
            throw new HmilyRuntimeException(" 账户扣减异常！");
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(String userId,Integer cnyAmount,Integer doAmount) {
        LOGGER.info("============dubbo tcc 执行  确认付款接口===============");
        accountMapper.confirm(userId,cnyAmount,doAmount);
        final int i = confrimCount.incrementAndGet();
        LOGGER.info("调用了account confirm " + i + " 次");
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(String userId,Integer cnyAmount,Integer doAmount) {
        LOGGER.info("============ dubbo tcc 执行  取消付款接口===============");
        final AccountDTO accountDO = accountMapper.findByUserId(userId);
        accountMapper.cancel(userId,cnyAmount,doAmount);
        return Boolean.TRUE;
    }








}
