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
 * @Date 2022/5/24/17:42
 */
@Data
@TableName("t_exam_paper_question_customer_answer")
public class EPQCustomerAnswer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 题目Id
     */
    @TableField("question_id")
    private Integer questionId;

    /**
     * 试卷Id
     */
    @TableField("exam_paper_id")
    private Integer examPaperId;

    /**
     * 答案Id
     */
    @TableField("exam_paper_answer_id")
    private Integer examPaperAnswerId;

    /**
     * 题型
     */
    @TableField("question_type")
    private Integer questionType;

    /**
     * 学科
     */
    @TableField("subject_id")
    private Integer subjectId;

    /**
     * 得分
     */
    @TableField("customer_score")
    private Integer customerScore;

    /**
     * 题目原始分数
     */
    @TableField("question_score")
    private Integer questionScore;

    /**
     * 问题内容
     */
    @TableField("question_text_content")
    private String questionTextContent;

    /**
     * 做题答案
     */
    @TableField("answer")
    private String answer;

    /**
     * 做题内容
     */
    @TableField("text_content")
    private String  textContent;

    /**
     * 是否正确
     */
    @TableField("do_right")
    private Boolean doRight;

    /**
     * 做题人
     */
    @TableField("create_user")
    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableField("item_order")
    private Integer itemOrder;

}
