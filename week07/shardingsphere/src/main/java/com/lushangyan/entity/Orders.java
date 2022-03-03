package com.lushangyan.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private int id;

    @TableId(value = "user_id")
    private int userId;

    @TableId(value = "create_time")
    private Date createTime;



}
