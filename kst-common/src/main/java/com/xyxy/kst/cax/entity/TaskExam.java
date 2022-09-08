package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:43
 */
@Data
@TableName("t_task_exam")
public class TaskExam  implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 任务标题
     */
    @TableField("title")
    private String title;

    /**
     * 年级
     */
    @TableField("grade_level")
    private Integer gradeLevel;

    /**
     * 任务框架 内容为JSON
     */
    @TableField("text_content")
    private String textContent;

    /**
     * 创建者
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableLogic
    @TableField("deleted")
    private Boolean deleted;
}
