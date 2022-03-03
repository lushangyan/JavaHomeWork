package io.lushangyan.springrouting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.lushangyan.springrouting.entity.Orders;
import io.lushangyan.springrouting.mapper.OrdersMapper;
import io.lushangyan.springrouting.service.OrdersService;
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
    public int insert(Orders orders) {
        return ordersMapper.insertOrder(orders);
    }

    @Override
    public int insertAnnotation(Orders orders) {
        return ordersMapper.insertOrderAnnotation(orders);
    }

    @Override
    public Orders findOrder(int id) {
        return ordersMapper.findOrder(id);
    }

    @Override
    public Orders findOrderAnnotation(int id) {
        return ordersMapper.findOrderAnnotation(id);
    }






}
