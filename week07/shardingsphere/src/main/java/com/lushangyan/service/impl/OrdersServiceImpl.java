package com.lushangyan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lushangyan.entity.Orders;
import com.lushangyan.mapper.OrdersMapper;
import com.lushangyan.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author lushangyan
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {


    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public Orders findById(Integer id) {
        return ordersMapper.selectById(id);
    }









}
