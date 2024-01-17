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
 * 年检预约：(AnnualInspectionAppointment)表实体类
 *
 */
@TableName("`annual_inspection_appointment`")
@Data
@EqualsAndHashCode(callSuper = false)
public class AnnualInspectionAppointment implements Serializable {

    // AnnualInspectionAppointment编号
    @TableId(value = "annual_inspection_appointment_id", type = IdType.AUTO)
    private Integer annual_inspection_appointment_id;

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
    // 车牌号码
    @TableField(value = "`license_plate_number`")
    private String license_plate_number;
    // 店铺名称
    @TableField(value = "`store_name`")
    private String store_name;
    // 检测地址
    @TableField(value = "`detection_address`")
    private String detection_address;
    // 可约时间
    @TableField(value = "`available_time_for_scheduling`")
    private Timestamp available_time_for_scheduling;
    // 检测价格
    @TableField(value = "`testing_prices`")
    private Integer testing_prices;
    // 预约时间
    @TableField(value = "`appointment_time`")
    private Timestamp appointment_time;
    // 检测内容
    @TableField(value = "`detection_content`")
    private String detection_content;
    // 订单编号
    @TableField(value = "`order_number`")
    private String order_number;



    // 审核状态
    @TableField(value = "examine_state")
    private String examine_state;

    // 支付状态
    @TableField(value = "pay_state")
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @TableField(value = "pay_type")
    private String pay_type;


    // 审核回复
    @TableField(value = "examine_reply")
    private String examine_reply;




    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
