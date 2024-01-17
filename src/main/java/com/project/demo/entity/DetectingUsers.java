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
 * 检测用户：(DetectingUsers)表实体类
 *
 */
@TableName("`detecting_users`")
@Data
@EqualsAndHashCode(callSuper = false)
public class DetectingUsers implements Serializable {

    // DetectingUsers编号
    @TableId(value = "detecting_users_id", type = IdType.AUTO)
    private Integer detecting_users_id;

    // 用户姓名
    @TableField(value = "`user_name`")
    private String user_name;
    // 用户性别
    @TableField(value = "`user_gender`")
    private String user_gender;
    // 用户电话
    @TableField(value = "`user_phone_number`")
    private String user_phone_number;
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
