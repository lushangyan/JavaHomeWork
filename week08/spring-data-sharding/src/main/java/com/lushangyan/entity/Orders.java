package com.lushangyan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("orders")
public class Orders extends Model<Orders> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Integer id;
    @TableId(value = "order_no")
    private String orderNo;
    @TableId(value = "shop_id")
    private Integer shopId;
    @TableId(value = "user_id")
    private Integer userId;
    @TableId(value = "user_name")
    private String userName;
    @TableId(value = "address")
    private String address;
    @TableId(value = "phone")
    private String phone;
    @TableId(value = "status")
    private int status;
    @TableId(value = "good_id")
    private Integer goodId;
    @TableId(value = "good_name")
    private String goodName;
    @TableId(value = "order_time")
    private Date orderTime;
    @TableId(value = "update_time")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
