package io.lushangyan.springrouting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.lushangyan.springrouting.datasource.CurDataSource;
import io.lushangyan.springrouting.datasource.DataSourceNames;
import io.lushangyan.springrouting.entity.Orders;
import io.lushangyan.springrouting.mapper.OrdersMapper;
import io.lushangyan.springrouting.service.OrdersService;
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



    @Override
    public int insert(Orders orders) {
        return this.baseMapper.insert(orders);
    }

    @CurDataSource(name = DataSourceNames.DB1)
    @Override
    public int insertAnnotation(Orders orders) {
        return this.baseMapper.insert(orders);
    }

    @Override
    public Orders findUser(int id) {
        return this.baseMapper.selectById(id);
    }

    @CurDataSource(name = DataSourceNames.DB1)
    @Override
    public Orders findUserByAnnotation(int id) {
        return this.baseMapper.selectById(id);
    }






}
