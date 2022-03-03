package io.lushangyan.springrouting.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.lushangyan.springrouting.entity.Orders;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author lushangyan
 */
public interface OrdersService extends IService<Orders> {

    Orders findOrder(int id);

    Orders findOrderAnnotation(int id);

    int insert(Orders orders);

    int insertAnnotation(Orders orders);

}
