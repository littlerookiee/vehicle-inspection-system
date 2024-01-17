package com.project.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 车主用户：(CarOwnersAndUsers)表实体类
 *
 */
@TableName("`car_owners_and_users`")
@Data
@EqualsAndHashCode(callSuper = false)
public class CarOwnersAndUsers implements Serializable {

    // CarOwnersAndUsers编号
    @TableId(value = "car_owners_and_users_id", type = IdType.AUTO)
    private Integer car_owners_and_users_id;

    // 车主姓名
    @TableField(value = "`owners_name`")
    private String owners_name;
    // 车主性别
    @TableField(value = "`vehicle_owner_gender`")
    private String vehicle_owner_gender;
    // 车主电话
    @TableField(value = "`car_owners_phone_number`")
    private String car_owners_phone_number;
    // 身份证号
    @TableField(value = "`id_number`")
    private String id_number;







    // 用户编号
    @TableField(value = "user_id")
    private Integer userId;



    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
