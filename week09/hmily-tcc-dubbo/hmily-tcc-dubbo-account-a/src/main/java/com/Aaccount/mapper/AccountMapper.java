/*
 * Copyright 2017-2021 Dromara.org

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

package com.Aaccount.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.Aaccount.entity.AccountDTO;

/**
 * The interface Account mapper.
 *
 * @author xiaoyu
 */
public interface AccountMapper {
    

    @Update(" update account set "+
            " cny_balance = cny_balance - #{cnyAmount}," +
            " free_cny_balance = free_cny_balance + #{cnyAmount}, " +
//            " do_balance = do_balance - #{doAmount},"+
//            " free_do_balance = free_do_balance + #{doAmount}," +
            " update_time = now()where user_id =#{userId} ")
    int update(String userId,Integer cnyAmount,Integer doAmount);


    @Update("update account set " +
            " free_cny_balance= free_cny_balance - #{cnyAmount}" +
//            " free_do_balance= free_do_balance - #{doAmount}" +
            " where user_id =#{userId} ")
    int confirm(String userId,Integer cnyAmount,Integer doAmount);
    

    @Update("update account set "+
            " cny_balance = cny_balance + #{cnyAmount}," +
            " free_cny_balance= free_cny_balance -  #{cnyAmount} " +
//            " do_balance = do_balance + #{doAmount}," +
//            " free_do_balance= free_do_balance -  #{doAmount} " +
            " where user_id =#{userId} ")
    int cancel(String userId,Integer cnyAmount,Integer doAmount);

    /**
     * 根据userId获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    @Select("select id,user_id,cny_balance, free_cny_balance,do_balance,free_do_balance from account where user_id =#{userId} limit 1")
    AccountDTO findByUserId(String userId);
}
