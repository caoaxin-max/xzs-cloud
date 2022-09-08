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
 * @Date 2022/5/24/17:44
 */
@Data
@TableName("t_task_exam_customer_answer")
public class TaskExamCustomerAnswer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 任务Id
     */
    @TableField("task_exam_id")
    private Integer taskExamId;

    /**
     * 创建者
     */
    @TableField("create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /**
     * 任务完成情况(Json)
     */
    @TableField("text_content")
    private Integer textContent;
}
