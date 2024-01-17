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
 * 维修记录：(MaintenanceRecords)表实体类
 *
 */
@TableName("`maintenance_records`")
@Data
@EqualsAndHashCode(callSuper = false)
public class MaintenanceRecords implements Serializable {

    // MaintenanceRecords编号
    @TableId(value = "maintenance_records_id", type = IdType.AUTO)
    private Integer maintenance_records_id;

    // 车主账号
    @TableField(value = "`car_owner_account`")
    private Integer car_owner_account;
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
    // 车辆车型
    @TableField(value = "`vehicle_model`")
    private String vehicle_model;
    // 车辆颜色
    @TableField(value = "`vehicle_color`")
    private String vehicle_color;
    // 发动机号
    @TableField(value = "`engine_number`")
    private String engine_number;
    // 车架号码
    @TableField(value = "`frame_number`")
    private String frame_number;
    // 维修日期
    @TableField(value = "`repair_date`")
    private Timestamp repair_date;
    // 维修原因
    @TableField(value = "`maintenance_reasons`")
    private String maintenance_reasons;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
