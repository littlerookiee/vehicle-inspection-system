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
 * 年检报告：(AnnualInspectionReport)表实体类
 *
 */
@TableName("`annual_inspection_report`")
@Data
@EqualsAndHashCode(callSuper = false)
public class AnnualInspectionReport implements Serializable {

    // AnnualInspectionReport编号
    @TableId(value = "annual_inspection_report_id", type = IdType.AUTO)
    private Integer annual_inspection_report_id;

    // 检测账号
    @TableField(value = "`detect_account`")
    private Integer detect_account;
    // 用户姓名
    @TableField(value = "`user_name`")
    private String user_name;
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
    // 年检日期
    @TableField(value = "`annual_inspection_date`")
    private Timestamp annual_inspection_date;
    // 下次年检
    @TableField(value = "`next_annual_inspection`")
    private Timestamp next_annual_inspection;
    // 年检报告
    @TableField(value = "`annual_inspection_report`")
    private String annual_inspection_report;
    // 年检状态
    @TableField(value = "`annual_inspection_status`")
    private String annual_inspection_status;
    // 年检结果
    @TableField(value = "`annual_inspection_results`")
    private String annual_inspection_results;
    // 年检记录
    @TableField(value = "`annual_inspection_records`")
    private String annual_inspection_records;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
