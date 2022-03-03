package com.lushangyan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lushangyan.entity.Orders;
import com.lushangyan.entity.Shop;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author lushangyan
 */
public interface ShopService extends IService<Shop> {


    Shop findById(Integer id);
}
