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
 * 检测地址：(DetectionAddress)表实体类
 *
 */
@TableName("`detection_address`")
@Data
@EqualsAndHashCode(callSuper = false)
public class DetectionAddress implements Serializable {

    // DetectionAddress编号
    @TableId(value = "detection_address_id", type = IdType.AUTO)
    private Integer detection_address_id;

    // 店铺名称
    @TableField(value = "`store_name`")
    private String store_name;
    // 店铺图片
    @TableField(value = "`store_image`")
    private String store_image;
    // 检测地址
    @TableField(value = "`detection_address`")
    private String detection_address;
    // 检测价格
    @TableField(value = "`testing_prices`")
    private Integer testing_prices;
    // 可约时间
    @TableField(value = "`available_time_for_scheduling`")
    private Timestamp available_time_for_scheduling;
    // 检测项目
    @TableField(value = "`testing_items`")
    private String testing_items;










    // 更新时间
    @TableField(value = "update_time")
    private Timestamp update_time;

    // 创建时间
    @TableField(value = "create_time")
    private Timestamp create_time;







}
