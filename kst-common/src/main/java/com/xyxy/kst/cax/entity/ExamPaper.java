package com.xyxy.kst.cax.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author 曹阿鑫
 * @Date 2022/5/24/17:41
 */
@Data
@TableName("t_exam_paper")
public class ExamPaper  implements Serializable {
    private static final long serialVersionUID = 8509645224550501395L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 试卷名称
     */
    @TableField("name")
    private String name;

    /**
     * 学科
     */
    @TableField("subject_id")
    private Integer subjectId;

    /**
     * 试卷类型( 1固定试卷 4.时段试卷 6.任务试卷)
     */
    @TableField("paper_type")
    private Integer paperType;

    /**
     * 年级
     */
    @TableField("grade_level")
    private Integer gradeLevel;

    /**
     * 试卷总分(千分制)
     */
    @TableField("score")
    private Integer score;

    /**
     * 题目数量
     */
    @TableField("question_count")
    private Integer questionCount;

    /**
     * 建议时长(分钟)
     */
    @TableField("suggest_time")
    private Integer suggestTime;

    /**
     * 时段试卷 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("limit_start_time")
    private Date limitStartTime;

    /**
     * 时段试卷 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("limit_end_time")
    private Date limitEndTime;

    /**
     * 试卷框架 内容为JSON
     */
    @TableField("text_content")
    private String textContent;

    @TableField("create_user")
    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

    @TableField("task_exam_id")
    private Integer taskExamId;

    @TableField("status")
    private Integer status;
}
