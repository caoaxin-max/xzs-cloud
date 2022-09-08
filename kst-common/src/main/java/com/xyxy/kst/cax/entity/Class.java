package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/15:45
 */
@Data
@TableName("t_class")
public class Class implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("class_name")
    private String className;
    @TableField("class_password")
    private String classPassword;
    @TableField("level")
    private Integer level;
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("deleted")
    @TableLogic
    private Integer deleted;
    @TableField(exist = false)
    private Integer classNumber;
}
