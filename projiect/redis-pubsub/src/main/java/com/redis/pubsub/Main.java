/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redis.pubsub;

import redis.clients.jedis.JedisPool;

import java.util.Objects;

/**
 * @author lw1243925457
 */
public class Main {

//    public static void main(String[] args) {
//        JedisPool jedisPool = new JedisPool();
//        String channelName = "ORDER";
//
//        SubscribeOrder subscribeOrder = new SubscribeOrder(jedisPool, channelName);
//        PublishOrder publishOrder = new PublishOrder(jedisPool, channelName);
//    }

    public  int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main main = (Main) o;
        return num == main.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.setNum(2);

        System.out.println(main.equals(main));

        Main main2 = new Main();
        main2.setNum(2);
        System.out.println(main.equals(main2));

        System.out.println(main.hashCode());
        System.out.println(main2.hashCode());


//        System.out.println("数组长度不-1：{}" +  (16 & "郭德纲".hashCode()));
//        System.out.println("数组长度不-1：{}" +  (16 & "彭于晏".hashCode()));
//        System.out.println("数组长度不-1：{}" +  (16 & "李小龙".hashCode()));
//        System.out.println("数组长度不-1：{}" +  (16 & "蔡徐鸡".hashCode()));
//        System.out.println("数组长度不-1：{}" +  (16 & "唱跳rap篮球鸡叫".hashCode()));
//
//        System.out.println("数组长度-1但是不进行异或和>>>16运算：{}" + (15 & "郭德纲".hashCode()));
//        System.out.println("数组长度-1但是不进行异或和>>>16运算：{}" + (15 & "彭于晏".hashCode()));
//        System.out.println("数组长度-1但是不进行异或和>>>16运算：{}" + (15 & "李小龙".hashCode()));
//        System.out.println("数组长度-1但是不进行异或和>>>16运算：{}" + (15 & "蔡徐鸡".hashCode()));
//        System.out.println("数组长度-1但是不进行异或和>>>16运算：{}" + (15 & "唱跳rap篮球鸡叫".hashCode()));
//
//        System.out.println("数组长度-1并且进行异或和>>>16运算：{}" + (15 & ("郭德纲".hashCode()^("郭德纲".hashCode()>>>16))));
//        System.out.println("数组长度-1并且进行异或和>>>16运算：{}" + (15 & ("彭于晏".hashCode()^("彭于晏".hashCode()>>>16))));
//        System.out.println("数组长度-1并且进行异或和>>>16运算：{}" + (15 & ("李小龙".hashCode()^("李小龙".hashCode()>>>16))));
//        System.out.println("数组长度-1并且进行异或和>>>16运算：{}" + (15 & ("蔡徐鸡".hashCode()^("蔡徐鸡".hashCode()>>>16))));
//        System.out.println("数组长度-1并且进行异或和>>>16运算：{}" + (15 & ("唱跳rap篮球鸡叫".hashCode()^("唱跳rap篮球鸡叫".hashCode()>>>16))));
//        System.out.println(Integer.toBinaryString("郭德纲".hashCode()));
//        System.out.println(Integer.toBinaryString("彭于晏".hashCode()));
//        System.out.println(Integer.toBinaryString("李小龙".hashCode()));
//        System.out.println(Integer.toBinaryString("蔡徐鸡".hashCode()));

    }
}
