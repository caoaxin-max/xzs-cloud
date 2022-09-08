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
@TableName("t_question")
@Data
public class Question implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 	1.单选题 2.多选题 3.判断题 4.填空题 5.简答题
     */
    @TableField("question_type")
    private Integer questionType;

    /**
     * 学科
     */
    @TableField("subject_id")
    private Integer subjectId;

    /**
     * 题目总分(千分制)
     */
    @TableField("score")
    private Integer score;

    /**
     * 级别
     */
    @TableField("grade_level")
    private Integer gradeLevel;

    /**
     * 题目难度
     */
    @TableField("difficult")
    private Integer difficult;

    /**
     * 正确答案
     */
    @TableField("correct")
    private String correct;

    /**
     * 题目 填空、 题干、解析、答案等信息
     */
    @TableField("text_content")
    private String textContent;

    /**
     * 创建人
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 1.正常
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

    @TableField(exist = false)
    private String shortTitle;
}
