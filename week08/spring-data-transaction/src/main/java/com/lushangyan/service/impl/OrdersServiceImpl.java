package com.lushangyan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lushangyan.entity.Orders;
import com.lushangyan.exception.RollbackException;
import com.lushangyan.mapper.OrdersMapper;
import com.lushangyan.service.OrdersService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(rollbackFor = RollbackException.class)
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType insertMy(Orders order) {
//        TransactionTypeHolder.set(TransactionType.XA);
        save(order);
        return TransactionTypeHolder.get();
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    @ShardingTransactionType(TransactionType.XA)
    public void insertThenRollback(final List<Orders> orders) throws RollbackException {
        saveBatch(orders);
        throw new RollbackException("Mock access failed");
    }









}
