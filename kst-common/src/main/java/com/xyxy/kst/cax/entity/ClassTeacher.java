package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/6/23/17:49
 */
@Data
@TableName("t_class_teacher")
public class ClassTeacher implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("class_id")
    private Integer classId;
    @TableField("teacher_id")
    private Integer teacherId;
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
