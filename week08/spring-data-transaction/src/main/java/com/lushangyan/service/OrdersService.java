package com.lushangyan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lushangyan.entity.Orders;
import com.lushangyan.exception.RollbackException;
import org.apache.shardingsphere.transaction.core.TransactionType;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author lushangyan
 */
public interface OrdersService extends IService<Orders> {

    /**
     * 插入订单数据
     *
     * @return {@link TransactionType}
     */
    TransactionType insertMy(Orders order);

    /**
     * 测试分布式事务
     */
    void insertThenRollback(List<Orders> orders) throws RollbackException;



}
