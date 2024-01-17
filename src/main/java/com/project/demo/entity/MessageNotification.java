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
 * 消息通知：(MessageNotification)表实体类
 *
 */
@TableName("`message_notification`")
@Data
@EqualsAndHashCode(callSuper = false)
public class MessageNotification implements Serializable {

    // MessageNotification编号
    @TableId(value = "message_notification_id", type = IdType.AUTO)
    private Integer message_notification_id;

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
    // 通知日期
    @TableField(value = "`notification_date`")
    private Timestamp notification_date;
    // 通知内容
    @TableField(value = "`notification_content`")
    private String notification_content;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
