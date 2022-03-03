package com.lushangyan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lushangyan.entity.Shop;
import com.lushangyan.mapper.ShopMapper;
import com.lushangyan.service.ShopService;
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
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {


    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop findById(Integer id) {
        return shopMapper.selectById(id);
    }









}
