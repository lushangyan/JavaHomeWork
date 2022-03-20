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

package com.Baccount.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Account dto.
 *
 * @author xiaoyu
 */
@Data
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 7223470850578998427L;


    private Integer id;

    private String userId;


    /**
     * 人名币余额
     */
    private Integer cny_balance;

    /**
     * 冻结人名币余额
     */
    private Integer free_cny_balance;

    /**
     * 美元余额
     */
    private Integer do_balance;

    /**
     * 冻结美元余额
     */
    private Integer free_do_balance;


    private Date createTime;

    private Date updateTime;



}
